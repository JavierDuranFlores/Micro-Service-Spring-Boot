package com.javier.user.model.entity;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/*
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	@Getter @Setter
	private Integer idUser;
	
	@Getter @Setter
	private Boolean enable;
	
	@Getter @Setter
	private String password;
	
	@Column(unique = true)
	@Getter @Setter
	private String username;

	@Column(unique = true)
	@Getter @Setter
	private String email;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "users_to_roles",
			joinColumns = @JoinColumn(name="id_user"),
			inverseJoinColumns = @JoinColumn(name="id_role"),
			uniqueConstraints = {@UniqueConstraint(columnNames = {"id_user", "id_role"})}
	)
	@Getter @Setter
	private List<RoleEntity> roles;

}*/
