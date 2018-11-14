package com.service;

import com.dao.AddressMapper;
import com.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AddressService {
    @Autowired
    private AddressMapper addressMapper;

    public List<Address> findByFatherId(Integer fatherId ){
        return addressMapper.findByFatherId(fatherId);
    }
}
