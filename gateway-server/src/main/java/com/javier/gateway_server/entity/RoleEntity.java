package com.javier.gateway_server.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "roles")
public class
RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Long idRole;

    /*@Transient
    @Getter
    private String nombreRole;*/

    @Enumerated(EnumType.STRING)
    @Getter
    private ERole nombre;
}