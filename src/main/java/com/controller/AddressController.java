package com.controller;

import com.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping("findByFatherId")
    @ResponseBody
    public Object findByFatherId(@RequestParam(value = "fatherId")Integer fatherId){
        return addressService.findByFatherId(fatherId);
    }


    @RequestMapping("index")
    public Object index(@RequestParam(value = "fatherId")Integer fatherId){
        return "index";
    }
}
