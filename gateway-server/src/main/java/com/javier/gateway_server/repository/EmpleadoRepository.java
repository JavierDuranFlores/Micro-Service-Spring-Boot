package com.javier.gateway_server.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javier.gateway_server.entity.EmpleadoEntity;


@Repository("empleadoRepository")
public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, String> {
    public abstract Optional<EmpleadoEntity> findByUsuario(String usuario);
}
