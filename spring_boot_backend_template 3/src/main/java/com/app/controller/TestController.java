package com.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
public TestController() {
	System.out.println("In constructor of "+ getClass());
}
//http://host:port/test

@GetMapping
public List<Integer> testMe(){
	System.out.println("in test me");
	return List.of(1,2,3,4,5);
	}


//Test Controller --> @ResponseBody List<Integer>
//--> DispatcherSevlet D.S SpringContainer S.C uses jacson to martial Java
}
