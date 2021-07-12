package com.capo.pruebaJava.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class QuasarController {
	
	@GetMapping(value = "/topsecret/{name}")
	public String getMessage() {
		return "Esto es el controlador prueba con jenkins y tomcat";
	}
}
