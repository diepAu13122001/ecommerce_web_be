package com.backend.ecommerceweb.controller;

import com.backend.ecommerceweb.repository.*;
import com.backend.ecommerceweb.services.*;
import com.backend.ecommerceweb.services.impl.ShipperService;
import com.backend.ecommerceweb.utils.JwtUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;
import org.apache.http.HttpHeaders;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.Base64;
import java.util.Date;
import java.util.logging.Logger;

//@ExtensionMethod(Extensions.class)
@Transactional
public abstract class BaseAPI {
    protected static final Logger logger = Logger.getLogger(BaseAPI.class.getName());
    private Gson gson;


    // utils
    @Autowired
    protected JwtUtil jwtUtil;

    @Autowired
    protected ModelMapper mapper;


    @Autowired
    IUserRepository userRepository;

    @Autowired
    IUserLoginRepository loginRepository;

    @Autowired
    IUserRoleRepository userRoleRepository;

    @Autowired
    protected IProvinceRepository provinceRepository;

    @Autowired
    protected IDistrictRepository districtRepository;

    @Autowired
    protected IWardRepository wardRepository;

    @Autowired
    protected IAddressRepository addressRepository;

    @Autowired
    IShipperRepository shipperRepository;

    @Autowired
    IShipperService shipperService;

    @Autowired
    IAddressService addressService;

    @Autowired
    protected IOtpRepository otpRepository;

    // service
    @Autowired
    IUserService userService;

    @Autowired
    IPaymentMethodService paymentMethodService;

    @Autowired
    IUserLoginService userLoginService;

    @Autowired
    IUserRoleService userRoleService;

    @Autowired
    IUserCartService userCartService;

    @Autowired
    IProvinceService provinceService;
    @Autowired
    IDistrictService districtService;

//    @Autowired
//    IWardService wardService;

    @Autowired
    IProductCancelService productCancelService;

    @Autowired
    IProductDescriptionService productDescriptionService;

    @Autowired
    IProductService productService;

    @Autowired
    IProductImageService productImageService;

    @Autowired
    ICategoryService categoryService;

//    @Autowired
//    ISupplierService supplierService;

    @Autowired
    IOrderService orderService;

    protected <T> T doPost(String urlStr, Class<T> forClass) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod(HttpMethod.POST.toString());
        conn.setRequestProperty(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
        String username = "AWh2N_QYAt5pVmm9yjJO9hs0ALmLOybUUqZi7WK-v9BQxf6JDM1jmK5E87-X1Llm55T9C_XTc2R9l2Pf";
        String password = "EPvZeJYu-DFHTk2xWyFZ-faDsSB1cymaXmAgfIkajVB8det6pHm5OqIiQin552PO7PVdlt_Jx0Vssri6";

        String auth = new String(username + ":" + password);
        byte[] data1 = auth.getBytes("utf-8");
        String base64 = Base64.getEncoder().encodeToString(data1);
        conn.setRequestProperty("Authorization", "Basic " + base64);

        // body
        String jsonString = "grant_type=client_credentials";
        byte[] dataJson = jsonString.getBytes();
        OutputStream os = conn.getOutputStream();
        os.write(dataJson);
        os.flush();

        int responseCode = conn.getResponseCode();
        String result = getJsonResult(conn);
        //getLogger().info(result);

        if (responseCode != 200) {
            URL urls = conn.getURL();
            String path = urls.getPath();
            if (path.contains("sync")) {
//                addValidateError("Lỗi kết nối Gateway");
//                getLogger().info(urlStr + " - ResponseCode = " + responseCode);
                return null;
            }
//            addValidateError("Lỗi kết nối Gateway");
//            getLogger().info(urlStr + " - ResponseCode = " + responseCode);
            if (null != result) {
                return getGson().fromJson(result, forClass);
            }
        }
        if (result == null || result.isEmpty()) {
//            addValidateError("Không có dữ liệu trả về từ Gateway");
            return null;
        }
        return getGson().fromJson(result, forClass);
    }

    protected String getJsonResult(HttpURLConnection conn) throws IOException {
        BufferedReader br = null;
        String str = null;
        try {
            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } catch (Exception ex) {
            br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        } finally {
            StringBuilder result = new StringBuilder();
            String output;
            if (null == br) {
                return str;
            }
            while ((output = br.readLine()) != null) {
                result.append(output);
            }
            if (result.length() > 0) {
                result = new StringBuilder(result.toString().trim());
            }
            str = result.toString();
            if (str.equals("\"\"")) {
                return null;
            }
        }
        return str;
    }

    public Gson getGson() {
        if (null == gson) {
            gson = new GsonBuilder()
                    .registerTypeAdapter(Date.class, new DateTypeAdapter())
                    .create();
        }
        return gson;
    }

    private final class BasicAuthenticator extends Authenticator {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("user", "password".toCharArray());
        }
    }

}
