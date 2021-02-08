package com.akman.springbootdemo.rest_api.controller;

import com.akman.springbootdemo.model.multipletypegeneric.MultipleTypeGeneric;
import com.akman.springbootdemo.model.singletypegeneric.SingleTypeGenericClass;
import com.akman.springbootdemo.service.advancedservice.AdvancedJavaService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/advanced-java")
@Api(tags = {"Advanced-Java"})
@SwaggerDefinition(tags = {
        @Tag(name = "Advanced-Java", description = "Advanced java programming controller")
})
public class AdvancedJavaController {

    private final AdvancedJavaService advancedJavaService;

    @ApiOperation(value = "List single type generics")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 422, message = "Unprocessable entity")
    })
    @RequestMapping(value = "/list-single-type-generics", method = RequestMethod.GET)
    public ResponseEntity<SingleTypeGenericClass<Integer>> listSingleTypeGenerics() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(advancedJavaService.getSingleTypeGeneric());
    }

    @ApiOperation(value = "List multiple type generics")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 422, message = "Unprocessable entity")
    })
    @RequestMapping(value = "/list-multiple-type-generics", method = RequestMethod.GET)
    public ResponseEntity<List<MultipleTypeGeneric<String, Integer>>> listMultipleTypeGenerics() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(advancedJavaService.getMultipleTypeGeneric());
    }

    @ApiOperation(value = "List parameterized multiple type generics")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 422, message = "Unprocessable entity")
    })
    @RequestMapping(value = "/list-multiple-and-parameterized-type-generics", method = RequestMethod.GET)
    public ResponseEntity<List<MultipleTypeGeneric<String, SingleTypeGenericClass<Integer>>>> listParameterizedMultipleTypeGenerics() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(advancedJavaService.getParameterizedMultipleTypeGeneric());
    }

    @ApiOperation(value = "List raw single type generics")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 422, message = "Unprocessable entity")
    })
    @RequestMapping(value = "/list-raw-single-type-generics", method = RequestMethod.GET)
    public ResponseEntity<List<SingleTypeGenericClass>> listRawSingleTypeGenerics() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(advancedJavaService.getRawSingleTypeGeneric());
    }

    @ApiOperation(value = "List raw multiple type generics")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 422, message = "Unprocessable entity")
    })
    @RequestMapping(value = "/list-raw-multiple-type-generics", method = RequestMethod.GET)
    public ResponseEntity<List<MultipleTypeGeneric>> listRawMultipleTypeGenerics() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(advancedJavaService.getRawMultipleTypeGeneric());
    }

    @ApiOperation(value = "List raw warning type generics")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 422, message = "Unprocessable entity")
    })
    @RequestMapping(value = "/list-raw-warning-type-generics", method = RequestMethod.GET)
    public ResponseEntity<SingleTypeGenericClass> getRawWarningTypeGenerics() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(advancedJavaService.getRawWarningTypeGeneric());
    }

    @ApiOperation(value = "List raw warning type generics")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 422, message = "Unprocessable entity")
    })
    @RequestMapping(value = "/get-compare-result-multiple-type-generics", method = RequestMethod.GET)
    public ResponseEntity<Boolean> getCompareResultMultipleTypeGenerics() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(advancedJavaService.getComparedMultipleTypeGeneric());
    }

    @ApiOperation(value = "Bounded type generics test")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 422, message = "Unprocessable entity")
    })
    @RequestMapping(value = "/get-bounded-type-generics-test", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getBoundedTypeTestGenerics() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(advancedJavaService.getBoundedTypeTest());
    }

    @ApiOperation(value = "Integer bounded type generics object.intValue test")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 422, message = "Unprocessable entity")
    })
    @RequestMapping(value = "/get-int-value-bounded-type-generics-test", method = RequestMethod.GET)
    public ResponseEntity<Boolean> getIntegerBoundedTypeIntValueTest() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(advancedJavaService.getIntegerBoundedTypeIntValueTest());
    }

    @ApiOperation(value = "Integer bounded type generics compareTo method test")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 422, message = "Unprocessable entity")
    })
    @RequestMapping(value = "/get-compare-to-bounded-type-generics-test", method = RequestMethod.GET)
    public ResponseEntity<Integer> getCompareToBoundedType(@RequestParam(defaultValue = "5") Integer number) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(advancedJavaService.getCompareToBoundedType(number));
    }

    @ApiOperation(value = "Test inheritance and subtypes")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 422, message = "Unprocessable entity")
    })
    @RequestMapping(value = "/test-inheritance-and-subtypes", method = RequestMethod.GET)
    public ResponseEntity<List<String>> testInheritanceAndSubTypes() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(advancedJavaService.testInheritanceAndSubTypes());
    }

    @ApiOperation(value = "Test type inference")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 422, message = "Unprocessable entity")
    })
    @RequestMapping(value = "/test-type-inference", method = RequestMethod.GET)
    public ResponseEntity<Serializable> testTypeInference() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(advancedJavaService.typeInferenceTest());
    }

    @ApiOperation(value = "Test wildcards")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 422, message = "Unprocessable entity")
    })
    @RequestMapping(value = "/test-wildcards", method = RequestMethod.GET)
    public ResponseEntity<Void> testWildcards() {
        advancedJavaService.upperAndLowerBoundedWildcard();
        return ResponseEntity
                .status(HttpStatus.OK).build();
    }
}