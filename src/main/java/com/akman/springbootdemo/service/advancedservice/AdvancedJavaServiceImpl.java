package com.akman.springbootdemo.service.advancedservice;

import com.akman.springbootdemo.model.multipletypegeneric.MultipleTypeGeneric;
import com.akman.springbootdemo.model.multipletypegeneric.MultipleTypeGenericClass;
import com.akman.springbootdemo.model.singletypegeneric.SingleTypeGenericClass;
import com.akman.springbootdemo.model.singletypegeneric.SingleTypeGenericExtendsInteger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdvancedJavaServiceImpl implements AdvancedJavaService {

    @Override
    public SingleTypeGenericClass<Integer> getSingleTypeGeneric() {
        SingleTypeGenericClass<Integer> singleTypeGenericClass = new SingleTypeGenericClass<>();
        return singleTypeGenericClass;
    }

    @Override
    public List<MultipleTypeGeneric<String, Integer>> getMultipleTypeGeneric() {
        MultipleTypeGeneric<String, Integer> firstTypeGeneric =
                createMultipleTypeGeneric("Talha", 24);
        return Collections.singletonList(firstTypeGeneric);
    }

    @Override
    public List<MultipleTypeGeneric<String, SingleTypeGenericClass<Integer>>> getParameterizedMultipleTypeGeneric() {
        MultipleTypeGeneric<String, SingleTypeGenericClass<Integer>> firstTypeGeneric =
                createMultipleTypeGeneric("Yasin", createSingleTypeGeneric(24));
        MultipleTypeGeneric<String, SingleTypeGenericClass<Integer>> secondTypeGeneric =
                new MultipleTypeGenericClass<>("Talha", createSingleTypeGeneric(20));
        return Arrays.asList(firstTypeGeneric, secondTypeGeneric);
    }

    @Override
    public List<SingleTypeGenericClass> getRawSingleTypeGeneric() {
        SingleTypeGenericClass<String> firstTypeGeneric = createSingleTypeGeneric("Yasin");
        SingleTypeGenericClass<Integer> secondTypeGeneric = createSingleTypeGeneric(24);
        return Arrays.asList(firstTypeGeneric, secondTypeGeneric);
    }

    @Override
    public List<MultipleTypeGeneric> getRawMultipleTypeGeneric() {
        MultipleTypeGeneric<String, Integer> firstTypeGeneric =
                createMultipleTypeGeneric("Yasin", 24);
        MultipleTypeGeneric<String, String> secondTypeGeneric =
                createMultipleTypeGeneric("Yasin", "Akman");
        return Arrays.asList(firstTypeGeneric, secondTypeGeneric);
    }

    @Override
    public SingleTypeGenericClass<Integer> getRawWarningTypeGeneric() {
        SingleTypeGenericClass<Integer> warningRawTypeToInteger = getWarningRawTypeToInteger(); // warning: unchecked assignment
        return warningRawTypeToInteger;
    }

    private SingleTypeGenericClass getWarningRawTypeToInteger() {
        SingleTypeGenericClass p = createSingleTypeGeneric("Yasin");
        p.setObject(24); // warning: unchecked call to set(T)
        return p;
    }

    @Override
    public boolean getComparedMultipleTypeGeneric() {
        MultipleTypeGeneric<String, Integer> ageValue =
                createMultipleTypeGeneric("Yasin", 24);
        MultipleTypeGeneric<String, Integer> lengthValue =
                createMultipleTypeGeneric("Yasin", 180);
        MultipleTypeGeneric<String, String> surnameValue =
                createMultipleTypeGeneric("Yasin", "Akman");

        //boolean compareResult = Util.<String, Integer, String, String>compare(ageValue, surnameValue); // is not needed to indicate "<String, Integer, String, String>"

        boolean compareResult = Util.compare(ageValue, surnameValue); // OK

        return compareResult;
    }

    @Override
    public List<String> getBoundedTypeTest() {
        SingleTypeGenericClass<Integer> integerSingleTypeGenericClass = new SingleTypeGenericClass<>();
        integerSingleTypeGenericClass.setObject(new Integer(10));
        //integerSingleTypeGeneric.inspect("some text"); // error: inspect metod type is <U extends Number> so that means i can't parameterize this method with String!
        double doubleValue = 1.5D;
        long longValue = 2147483649L;
        List<String> inspect = integerSingleTypeGenericClass.inspect(doubleValue, longValue);
        return inspect;
    }

    @Override
    public boolean getIntegerBoundedTypeIntValueTest() {
        SingleTypeGenericExtendsInteger<Integer> integerSingleTypeGeneric = new SingleTypeGenericExtendsInteger<>();
        boolean isEven = integerSingleTypeGeneric.isEven();
        return isEven;
    }

    @Override
    public int getCompareToBoundedType(Integer number) {
        SingleTypeGenericExtendsInteger<Integer> integerSingleTypeGeneric = new SingleTypeGenericExtendsInteger<>();
        Integer intArray[] = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int greaterThan = integerSingleTypeGeneric.countGreaterThan(intArray, number);
        return greaterThan;
    }

    @Override
    public List<String> testInheritanceAndSubTypes() {
        Object object = new Object();
        Integer intObject = new Integer(10);
        Double doubleObject = new Double(10.1);
        object = doubleObject; /** is valid */
        object = intObject; /** is valid */

        List<String> validationStrings = new ArrayList<>();
        getTypeNameOfInputParameter(intObject);/** is valid */
        validationStrings.add(intObject.getClass().getTypeName() + " extends Number");
        getTypeNameOfInputParameter(doubleObject);/** is valid */
        validationStrings.add(doubleObject.getClass().getTypeName() + " extends Number");

        List<Number> numberList = new ArrayList<>();
        numberList.add(intObject); /** is valid */
        numberList.add(doubleObject); /** is valid */

        /**********************************************************************/
        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3));
        /*useNumberListInputParameter(integerList);*/ /** error - not valid, List<Integer> can't be cat to List<Number> */
        List<Double> doubleList = new ArrayList<>(Arrays.asList(1.2, 2.5, 3.4));
        /*useNumberListInputParameter(doubleList);*/ /** error - not valid, List<Double> can't be cat to List<Number> */
        /**********************************************************************/

        useNumberListInputParameter(numberList); /** is valid */
        return validationStrings;
    }

    @Override
    public Serializable typeInferenceTest() {
        //TEST
        Serializable t1 = typeInference("d", new ArrayList<String>()); // the typeInference method will infer that the new arrayList will be in type of String.
        return t1;
    }

    @Override
    public void upperAndLowerBoundedWildcard() {
        List<? super Integer> numberListSuper = lowerBoundedWildCard(new ArrayList<Integer>());/** wildcard is used.*/
        List<? extends Number> numberListExtends = upperBoundedWildCard(new ArrayList<Integer>());/** wildcard is used.*/
        useNumberListInputParameterWildCard(new ArrayList<Number>()); /** wildcard is used.*/
    }

    private List<? super Integer> lowerBoundedWildCard(List<? super Integer> superList) {
        return superList;
    }

    private List<? extends Number> upperBoundedWildCard(List<? extends Number> extendList) {
        return extendList;
    }

    private void useNumberListInputParameterWildCard(List<?> list) {
        // continue
    }

    private <T> T typeInference(T a1, T a2) {
        return a2;
    }

    private void getTypeNameOfInputParameter(Number number) {
        // continue;
    }

    private<T extends Number> void useNumberListInputParameter(List<T> numberList) {
        // continue
    }

    private <T> SingleTypeGenericClass<T> createSingleTypeGeneric(T typeParameterizedValue) {
        return new SingleTypeGenericClass<>(typeParameterizedValue);
    }

    private <T, U> MultipleTypeGenericClass<T, U> createMultipleTypeGeneric(T typeParameterizedKey, U typeParameterizedValue) {
        return new MultipleTypeGenericClass<>(typeParameterizedKey, typeParameterizedValue);
    }

    public static class Util {
        static <K, V, T, U> boolean compare(MultipleTypeGeneric<K, V> p1, MultipleTypeGeneric<T, U> p2) {
            return p1.getKey().equals(p2.getKey()) &&
                    p1.getValue().equals(p2.getValue());
        }
    }
}