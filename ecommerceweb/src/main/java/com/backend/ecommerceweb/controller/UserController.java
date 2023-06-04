package com.backend.ecommerceweb.controller;

import com.backend.ecommerceweb.entities.*;
import com.backend.ecommerceweb.handler.VeggyServiceException;
import com.backend.ecommerceweb.model.dtos.auths.*;
import com.backend.ecommerceweb.model.wrapper.ObjectResponseWrapper;
import com.backend.ecommerceweb.security.UserPrincipal;
import com.backend.ecommerceweb.services.impl.UserService;
import com.backend.ecommerceweb.services.impl.UserService;
import com.backend.ecommerceweb.utils.Constants;
import com.backend.ecommerceweb.utils.SendMail;
import lombok.experimental.ExtensionMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;

import java.io.UnsupportedEncodingException;
import java.util.*;

//@ExtensionMethod(Extensions.class)
@RestController
@RequestMapping(Constants.AUTH_SERVICE_URL)
//@Tag(name = "Authentication", description = "Authentication API")
@Validated

public class UserController extends BaseAPI{

    @Autowired

    private UserService userService;


    @PostMapping("/register")
    @Transactional
    public ObjectResponseWrapper register(@Valid @RequestBody RegisterAccountDTO user) {
        try {
            User check = userService.findByEmail(user.getEmail());
            if (check != null) {
                throw new VeggyServiceException("Email đã được đăng kí.");
            }
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword().trim()));
            User userCreate = mapper.map(user, User.class);
            userCreate.setCreated_at(new Date());
            userCreate.setUser_url_avt("https://i.pinimg.com/736x/97/d0/f9/97d0f95b9060ba41c4ea6bd1ae47267f.jpg");
            //tạo user
            userCreate = userService.createUser(userCreate);

            // tạo login
            UserLogin userLogin = new UserLogin();
            userLogin.setUserId(userCreate.getId());
            userLogin.setActive(false);
            userLogin.setPassword(user.getPassword());
            userLoginService.save(userLogin); // lưu user login

            /* tạo role*/
            UserRole role = new UserRole();
            role.setUserId(userCreate.getId());
            role.setRoleId("ADMIN");
            userRoleRepository.save(role);


//            // gửi mail
            UserPrincipal userPrincipal = new UserPrincipal();
            userPrincipal.setUserId(userCreate.getId());
            userPrincipal.setUsername(userCreate.getEmail());
            Token token = new Token();
            token.setToken(jwtUtil.generateToken(userPrincipal));
            token.setTokenExpDate(jwtUtil.generateExpirationDate());
            SendMail.sendMailActiveAccount(userCreate.getEmail(), token.getToken());

            return ObjectResponseWrapper.builder()
                    .status(1)
                    .message("Tạo tài khoản thành công")
                    .build();
        } catch (VeggyServiceException e) {
            return ObjectResponseWrapper.builder()
                    .status(0)
                    .message(e.getReason())
                    .build();
        } catch (Exception e2) {
            return ObjectResponseWrapper.builder()
                    .status(0)
                    .message(e2.getMessage())
                    .build();
        }
    }

    @PostMapping("/login")
    public ObjectResponseWrapper login(@Valid @RequestBody LoginDTO user) {
//        UserLogin userNet = userLoginService.findByUserName(user.getEmail());
        User userNet = userService.findByEmail(user.getEmail());

        if (userNet == null || userNet.getUserLogin() == null) {
            throw new VeggyServiceException("Không tìm thấy tài khoản");
        }

        UserLogin userLogin = userNet.getUserLogin();

        if (!userLogin.getActive()) {
            throw new VeggyServiceException("Tài khoản chưa được kích hoạt");
        }

        UserPrincipal userPrincipal = new UserPrincipal();
        if (null != userNet) {
            userPrincipal.setUserId(userNet.getId());
            userPrincipal.setUsername(userNet.getEmail());
            userPrincipal.setPassword(userLogin.getPassword());

            // lấy role
            Set<String> authorities = new HashSet<>();
            if (null != userNet.getRoles()) {
                userNet.getRoles().forEach(r -> {
                    authorities.add(r.getId());
//                    r.getPermissions().forEach(p -> authorities.add(p.getId()));
                });
            }
            userPrincipal.setAuthorities(authorities);
        }
        if (!new BCryptPasswordEncoder().matches(user.getPassword().trim(), userPrincipal.getPassword())) {
            throw new VeggyServiceException("Sai mật khẩu");
        }
        Token token = new Token();
        token.setToken(jwtUtil.generateToken(userPrincipal));
        token.setTokenExpDate(jwtUtil.generateExpirationDate());
//        token.setCreatedBy(userPrincipal.getUserId());
//        tokenService.createToken(token);
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(token.getToken())
                .build();
    }

    @GetMapping("/user/{user_id}")
//    @RequiredHeaderToken
//    @Operation(summary = "Lấy thông tin user")
    public ObjectResponseWrapper getUser(@PathVariable("user_id") Long userId) {
        User user = userService.findById(userId);
        if (user == null) {
            throw new VeggyServiceException("Không tìm thấy user này.");
        }

        return ObjectResponseWrapper.builder()
                .status(1)
                .data(user)
                .build();
    }

    @GetMapping("/active")
//    @RequiredHeaderToken
//    @Operation(summary = "Kích hoạt tài khoản")
    public ObjectResponseWrapper active(@RequestParam(name = "token", required = true) String token) {
        UserPrincipal userPrincipal = jwtUtil.getUserFromToken(token);

        if (userPrincipal == null) {
            throw new VeggyServiceException("Đã có lỗi xả ra.");
        }
        UserLogin user = userLoginService.findUserLoginByUserId(userPrincipal.getUserId());
        if (user == null) {
            throw new VeggyServiceException("Đã có lỗi xả ra.");
        }

        // kích hoạt
        user.setActive(true);
        userLoginService.save(user);
        return ObjectResponseWrapper
                .builder()
                .status(1)
                .message("Kích hoạt tài khoản thành công.")
                .build();

    }

    @GetMapping("/user")
//    @RequiredHeaderToken
//    @Operation(summary = "Lấy thông tin user")
    public ObjectResponseWrapper getUserOwner(@RequestHeader(Constants.HEADER_TOKEN_NAME) String accessToken) {
        String token = "";
        if (accessToken != null && accessToken.length() > 6) {
            token = accessToken.substring(6);
        }
        UserPrincipal userPrincipal = jwtUtil.getUserFromToken(token);
        User user = userService.findById(userPrincipal.getUserId());

        if (user == null) {
            throw new VeggyServiceException("Không tìm thấy user này.");
        }
        UserOutPutDTO userDTO = mapper.map(user, UserOutPutDTO.class);
        userDTO.setActive(user.getUserLogin().getActive());
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(userDTO)
                .build();
    }

    @PutMapping("/password")
//    @RequiredHeaderToken
//    @Operation(summary = "Đổi mật khẩu")
    public ObjectResponseWrapper changePassword(@RequestHeader(Constants.HEADER_TOKEN_NAME) String accessToken,
                                                @RequestBody(required = true) PasswordInputDTO passwordInputDTO) {
        String token = "";
        if (accessToken != null && accessToken.length() > 6) {
            token = accessToken.substring(6);
        }
        UserPrincipal userPrincipal = jwtUtil.getUserFromToken(token);
        if (userPrincipal == null) {
            throw new VeggyServiceException("Không tìm thấy user này.");
        }

        UserLogin userLogin = userLoginService.findUserLoginByUserId(userPrincipal.getUserId());

        if (!new BCryptPasswordEncoder().matches(passwordInputDTO.getOldPassword().trim(), userLogin.getPassword())) {
            throw new VeggyServiceException("Sai mật khẩu cũ.");
        }

        userLogin.setPassword(new BCryptPasswordEncoder().encode(passwordInputDTO.getNewPassword().trim()));
        userLoginService.save(userLogin);

        return ObjectResponseWrapper.builder()
                .status(1)
                .message("Đổi mật khẩu thành công.")
                .build();
    }

    @GetMapping("/forgot-password")
//    @Operation(summary = "Quên mật khẩu")
    public ObjectResponseWrapper forgotPassword(@RequestParam(required = true) String email) throws MessagingException, UnsupportedEncodingException {
        User user = userService.findByEmail(email);
        if (user == null) {
            throw new VeggyServiceException("Không tìm thấy user này.");
        }
        int otp = new Random().nextInt(1000000 - 100000) + 100000;
        SendMail.sendMailOTP(email, otp);
        otpRepository.save(new OTP(user.getId(), (long) otp, new Date()));
        return ObjectResponseWrapper.builder()
                .status(1)
                .message("Vui lòng kiểm tra email.")
                .build();
    }

    @PostMapping("/forgot-password/")
//    @Operation(summary = "Cập nhật mật khẩu mới")
    public ObjectResponseWrapper validateOTP(@RequestBody(required = true) ValidateOtpInpoutDTO validateOtpInpoutDTO) {
        User user = userService.findByEmail(validateOtpInpoutDTO.getEmail());
        if (user == null) {
            throw new VeggyServiceException("Không tìm thấy user này.");
        }

        OTP otp = otpRepository.findOtpByUserId(user.getId());
        if (otp == null) {
            throw new VeggyServiceException("OTP hết hạn.");
        }
        if (Calendar.getInstance().getTime().getTime() - otp.getCreated_at().getTime() > 2 * 60 * 1000) {
            throw new VeggyServiceException("OTP hết hạn.");
        }
        if (otp.getOtp_number() != validateOtpInpoutDTO.getOtp()) {
            throw new VeggyServiceException("OTP không đúng.");
        }
        UserLogin userLogin = userLoginService.findUserLoginByUserId(user.getId());
        userLogin.setPassword(new BCryptPasswordEncoder().encode(validateOtpInpoutDTO.getPassword().trim()));
        userLoginService.save(userLogin);
        otpRepository.delete(otp);
        return ObjectResponseWrapper.builder()
                .status(1)
                .message("Success")
                .build();
    }

    @GetMapping("/user/avatar")
//    @Operation(summary = "Cập nhật avatar")
//    @RequiredHeaderToken
    public ObjectResponseWrapper updateAvtatr(@Valid @RequestBody UpdateAvatarInputDTO updateAvatarInputDTO) {
        User user = userService.findById(updateAvatarInputDTO.getId());
        if (user == null) {
            throw new VeggyServiceException("Không tìm thấy user này.");
        }
        user.setUser_url_avt(updateAvatarInputDTO.getUrl());
        userRepository.save(user);
        return ObjectResponseWrapper.builder()
                .status(1)
                .message("Cập nhật avatar thành công.")
                .build();
    }

    @PutMapping("/users")
//    @Operation(summary = "Danh sách khách hàng")
//    @RequiredHeaderToken
    public ObjectResponseWrapper getUsers() {
        List<User> userList = userRepository.findAll();
        return ObjectResponseWrapper.builder()
                .status(1)
                .data(userList)
                .build();
    }


    @PutMapping("/user")
//    @Operation(summary = "Cập nhật thông tin tài khoản")
//    @RequiredHeaderToken
    public ObjectResponseWrapper updateInformationAccount(@Valid @RequestBody UpdateUserInputDTO updateUserInputDTO) {
        User user = userService.findById(updateUserInputDTO.getId());
        if (user == null) {
            throw new VeggyServiceException("Không tìm thấy user này.");
        }
        if(updateUserInputDTO.getBirthday() != null){
            user.setBirthday(new Date(updateUserInputDTO.getBirthday()));
        }
        if(updateUserInputDTO.getName() != null){
            user.setName(updateUserInputDTO.getName());
        }

        if(updateUserInputDTO.getGender() != null){
            user.setGender(updateUserInputDTO.getGender().toString());
        }

        if(updateUserInputDTO.getPhone() != null){
            user.setPhone(updateUserInputDTO.getPhone());
        }
//        userRepository.save(user);
        return ObjectResponseWrapper.builder()
                .status(1)
                .message("Cập nhật thông tin tài khoản thành công.")
                .build();
    }

    @GetMapping("/hello")
//    @RequiredHeaderToken
    @PreAuthorize("hasAnyAuthority('USER_READ')")
    public ObjectResponseWrapper hello() {
        return ObjectResponseWrapper.builder()
                .status(1)
                .data("Hello").build();
    }

}

