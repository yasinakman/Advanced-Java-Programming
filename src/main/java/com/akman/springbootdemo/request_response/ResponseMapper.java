package com.akman.springbootdemo.request_response;

import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Selma;

@Mapper
public interface ResponseMapper {

    ResponseMapper MAPPER = Selma.builder(ResponseMapper.class).build();

    /*@Maps(withIgnoreMissing = IgnoreMissing.ALL)
     */
}