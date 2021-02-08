package com.akman.springbootdemo.model.singletypegeneric;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SingleTypeGenericExtendsInteger<T extends Integer> {

    @ApiModelProperty(notes = "Object in SingleTypeGeneric Class with generic type in scope of Integer")
    private T object; // T is in Scope of Integer

    public boolean isEven() {
        return object.intValue() % 2 == 0;
        // object.intValue() is allowed to use because <T extends Integer>.
        // if T wouldn't be bounded with Integer, intValue() method for object parameter wouldn't be allowed to use.
    }

    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e.compareTo(elem) > 0) // compareTo method is just allowed if the type of T type parameter extends Comparable
                ++count;
        return count;
    }

    /*public static <T> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e > elem)  // compiler error
                ++count;
        return count;
    }*/

}
