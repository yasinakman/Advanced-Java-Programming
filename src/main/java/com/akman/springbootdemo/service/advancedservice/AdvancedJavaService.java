package com.akman.springbootdemo.service.advancedservice;

import com.akman.springbootdemo.model.multipletypegeneric.MultipleTypeGeneric;
import com.akman.springbootdemo.model.singletypegeneric.SingleTypeGenericClass;

import java.io.Serializable;
import java.util.List;

public interface AdvancedJavaService {

    SingleTypeGenericClass<Integer> getSingleTypeGeneric();

    List<MultipleTypeGeneric<String, Integer>> getMultipleTypeGeneric();

    List<MultipleTypeGeneric<String, SingleTypeGenericClass<Integer>>> getParameterizedMultipleTypeGeneric();

    List<SingleTypeGenericClass> getRawSingleTypeGeneric();

    List<MultipleTypeGeneric> getRawMultipleTypeGeneric();

    SingleTypeGenericClass<Integer> getRawWarningTypeGeneric();

    boolean getComparedMultipleTypeGeneric();

    List<String> getBoundedTypeTest();

    boolean getIntegerBoundedTypeIntValueTest();

    int getCompareToBoundedType(Integer number);

    List<String> testInheritanceAndSubTypes();

    Serializable typeInferenceTest();

    void upperAndLowerBoundedWildcard();
}