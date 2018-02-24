package org.fran.demo.springmvc.swagger.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.fran.demo.springmvc.swagger.vo.JsonResult;
import org.fran.demo.springmvc.swagger.vo.RemoveConfigParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Api(value = "/api/test", tags = "TestRestController", description = "test post & get & fileupload")
@RestController
@RequestMapping("/api/test")
public class TestRestController {
	static Logger log = LoggerFactory.getLogger(TestRestController.class);

	@ApiIgnore()
	@ApiOperation("ignore api")
	@PostMapping(value = "/selectString2", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public JsonResult<String> oldTest(
			@RequestBody RemoveConfigParam baseParam){
		JsonResult<String> res = new JsonResult<>();
		return res;
	}

	@ApiOperation(
			value = "test post", notes = "post request parameter in body",
			response = JsonResult.class
	)
	@PostMapping(value = "/selectString", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public JsonResult<String> firstTest(
			@RequestBody RemoveConfigParam baseParam){
		log.info("firstTest");
		JsonResult<String> res = new JsonResult<>();
		res.setData("dsadsad");
		res.setDescription("sahdjhsajdhjsahdjsajdjh");
		res.setStatus(200);
		return res;
	}

	@ApiOperation(
			value = "test get", notes = "get request parameter in url",
			response = JsonResult.class
	)
	@GetMapping(value = "/selectList", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
	public JsonResult<List<String>> selectTest(
			@ApiParam("test id")
			@RequestParam(name="id") int ids){
		log.info("selectAll ids:["+ ids +"]");
		if(ids == 5)
			throw new RuntimeException("error!!!!");

		JsonResult<List<String>> res = new JsonResult<>();
		res.setData(new ArrayList<String>(){
			{
				add("sadsda1");
				add("sadsda2");
				add("sadsda3");
				add("sadsda4");
				add("sadsda5");
			}
		});
		res.setDescription("sahdjhsajdhjsahdjsajdjh");
		res.setStatus(200);
		return res;
	}

	@ApiOperation(
			value = "test fileupload", notes = "upload use MultipartFile",
			response = JsonResult.class
	)
	@PostMapping(value = "/upload",
			consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonResult upload(
			@ApiParam("uploadFile stream")
			@RequestPart("uploadFile")MultipartFile uploadFile,
			@ApiParam("file description")
			@RequestParam("description")String description,
			@ApiParam("file name")
			@RequestParam("name")String name
	){
		FileOutputStream o = null;
		InputStream inputStream = null;
		try {
			inputStream = uploadFile.getInputStream();
			File f = new File("C:\\temp\\aa.jpg");
			o = new FileOutputStream(f);
			byte[] b = new byte[1024];
			while(inputStream.read(b)!= -1){
				o.write(b);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(o!= null)
					o.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(inputStream!= null)
					inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		JsonResult res = new JsonResult();
		res.setData("success");
		res.setDescription("success");
		res.setStatus(200);
		return res;
	}
}
