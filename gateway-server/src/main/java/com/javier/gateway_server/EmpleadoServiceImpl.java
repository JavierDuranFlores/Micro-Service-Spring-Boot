package com.javier.gateway_server;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javier.gateway_server.entity.EmpleadoEntity;
import com.javier.gateway_server.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
	
	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public List<EmpleadoEntity> list() {
		// TODO Auto-generated method stub
		return empleadoRepository.findAll();
	}

}
