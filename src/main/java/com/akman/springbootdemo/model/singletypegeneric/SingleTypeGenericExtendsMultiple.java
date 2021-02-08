package com.akman.springbootdemo.model.singletypegeneric;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SingleTypeGenericExtendsMultiple<T extends Integer & SingleTypeGeneric> { /*<T extends SingleTypeGeneric, Integer>*//*-> error*/
        /* SingleTypeGeneric bir interface oldugu icin interface tanımınından sonra bir class tanımlanamaz önce class'lar sonra interfaceler sırasıyla tanımlanmalıdır*/

    @ApiModelProperty(notes = "Object in SingleTypeGeneric Class with generic type in scope of Integer")
    private T object; // T is in Scope of Integer

    public boolean isEven() {
        return object.intValue() % 2 == 0;
        // object.intValue() is allowed to use because <T extends Integer>.
        // if T wouldn't be bounded with Integer, intValue() method for object parameter wouldn't be allowed to use.
    }
}
