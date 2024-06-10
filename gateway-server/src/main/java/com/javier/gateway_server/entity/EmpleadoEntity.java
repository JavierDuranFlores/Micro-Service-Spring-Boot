package com.javier.gateway_server.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "empleados")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpleadoEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_empleado")
	@Getter @Setter
	private Integer idEmpleado;
	
	@Column(name = "usuario")
	@Getter @Setter
	private String usuario;

	@Column(name = "nombre")
	@Getter @Setter
	private String nombre;
	
	@Column(name = "password")
	@Getter @Setter
	private String password;

	@Column(name = "correo")
	@Getter @Setter
	private String correo;

	@ManyToMany(fetch = FetchType.EAGER, targetEntity = RoleEntity.class, cascade = CascadeType.PERSIST)
	@JoinTable(name = "empleados_roles", 
				joinColumns = @JoinColumn(name = "id_empleado"), 
				inverseJoinColumns = @JoinColumn(name = "id_role"),
				uniqueConstraints = {@UniqueConstraint(columnNames = {"id_empleado", "id_role"})}
				)
	@Getter @Setter
	private Set<RoleEntity> roles;



}
