package com.web.spring.security.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.security.model.Greeting;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

	
	@RequestMapping( value="/hello/{name}",method=RequestMethod.GET,produces="application/json")
	public Greeting mymsg(@PathVariable String name)
	{
		Greeting msg=new Greeting(name,"hello"+ name);
		return msg;
	}
	
	
}
