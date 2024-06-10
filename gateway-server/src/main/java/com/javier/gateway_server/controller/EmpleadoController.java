package com.javier.gateway_server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javier.gateway_server.EmpleadoServiceImpl;
import com.javier.gateway_server.entity.EmpleadoEntity;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoServiceImpl empleadoServiceImpl;
	
	@GetMapping("/list")
	public List<EmpleadoEntity> list() {
		return empleadoServiceImpl.list();
	}
	

}
