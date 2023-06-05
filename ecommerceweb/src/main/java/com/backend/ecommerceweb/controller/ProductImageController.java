package com.backend.ecommerceweb.controller;

import com.backend.ecommerceweb.utils.Constants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.API_VERSION+"/productImage")
public class ProductImageController extends BaseAPI {

}
