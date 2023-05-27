package com.backend.ecommerceweb.services;

import com.backend.ecommerceweb.repository.*;
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


    @Autowired
    protected IUserRepository userRepository;
    @Autowired
    protected IUserLoginRepository userLoginRepository;
    @Autowired
    protected ICategoryRepository categoryRepository;
    @Autowired
    protected IUserRoleRepository userRoleRepository;
    @Autowired
    protected IOrderDetailRepository orderDetailRepository;
    @Autowired
    protected IProvinceRepository provinceRepository;
    @Autowired
    protected IDistrictRepository districtRepository;
    @Autowired
    protected IWardRepository wardRepository;
    @Autowired
    protected IAddressRepository addressRepository;
    @Autowired
    protected IOrderRepository orderRepository;
    @Autowired
    protected IProductCancelRepository productCancelRepository;
    @Autowired
    protected IProductDescriptionRepository productDescriptionRepository;
    @Autowired
    protected IProductImageRepository productImageRepository;
    @Autowired
    protected IProductRepository productRepository;
    @Autowired
    protected IShipperRepository shipperRepository;
    @Autowired
    protected ISupplierRepository supplierRepository;
    @Autowired
    protected IUserCartRepository userCartRepository;

}
