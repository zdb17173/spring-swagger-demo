package org.fran.demo.springmvc.swagger.rest;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fran.demo.springmvc.swagger.vo.JsonResult;
import org.fran.demo.springmvc.swagger.vo.RemoveConfigParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "/api/test2", tags = "TestSecondRestController", description = "test ")
@RestController
@RequestMapping("/api/test2")
public class TestSecondRestController {

    @ApiOperation(
            value = "test post", notes = "post request parameter in body",
            response = JsonResult.class
    )
    @PostMapping(value = "/selectString", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public JsonResult<String> firstTest(
            @RequestBody RemoveConfigParam baseParam){
        JsonResult<String> res = new JsonResult<>();
        res.setData("dsadsad");
        res.setDescription("sahdjhsajdhjsahdjsajdjh");
        res.setStatus(200);
        return res;
    }
}
