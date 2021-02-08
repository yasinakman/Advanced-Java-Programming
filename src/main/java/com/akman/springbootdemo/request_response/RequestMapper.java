package com.akman.springbootdemo.request_response;

import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Selma;

@Mapper
public interface RequestMapper {

    RequestMapper MAPPER = Selma.builder(RequestMapper.class).build();
}