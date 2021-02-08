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
public class SingleTypeGenericClass<T> implements SingleTypeGeneric<T> {

    @ApiModelProperty(notes = "Object in SingleTypeGeneric Class with generic type")
    private T object;

    public <U extends Number, S extends Number> List<String> inspect(U u, S s) {
        return Arrays.asList("T: " + object.getClass().getName(),
                "U: " + u.getClass().getName(), "S: " + s.getClass().getName());
    }
}
