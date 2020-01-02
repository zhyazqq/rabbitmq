package com.onepage.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onepage.service.RabbitMqService;

@RestController
@RequestMapping("/rabbit")
public class Demo {

	@Resource
	private RabbitMqService service;

	@RequestMapping("/demo")
	public String tes() {
		try {
			return service.getResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}