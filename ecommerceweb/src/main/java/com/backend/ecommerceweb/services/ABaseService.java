package com.backend.ecommerceweb.services;

import com.backend.ecommerceweb.repository.IUserLoginRepository;
import com.backend.ecommerceweb.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.logging.Logger;

public abstract class ABaseService {
    protected static final Logger logger = Logger.getLogger(ABaseService.class.getName());

//    @Autowired
//    private RestTemplate restTemplate;

    private final HttpHeaders httpHeaders;

    {
        httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    }


    // repositoty
//    @Autowired
//    protected ITokenRepository tokenRepository;

    @Autowired
    protected IUserRepository userRepository;

    @Autowired
    protected IUserLoginRepository userLoginRepository;

//    @Autowired
//    protected IRoleRepository roleRepository;

//    @Autowired
//    protected IUserRoleRepository userRoleRepository;
//    @Autowired
//    protected  IGradeRepository gradeRepository;
//
//    @Autowired
//    protected IProvinceRepository provinceRepository;
//
//    @Autowired
//    protected IDistrictRepository districtRepository;
//
//    @Autowired
//    protected IWardRepository wardRepository;
//
//    @Autowired
//    protected  IAddressRepository addressRepository;
}
