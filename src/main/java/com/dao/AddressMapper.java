package com.dao;

import com.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AddressMapper {

    List<Address> findByFatherId(@Param(value = "fatherId") Integer fatherId);
}