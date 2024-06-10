CREATE TABLE empleados (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(255) NOT NULL,
	nombre VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    correo VARCHAR(255) NOT NULL
);

CREATE TABLE roles (
    id_role INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE empleados_roles (
    id_empleado INT AUTO_INCREMENT,
    id_role INT NOT NULL,
    PRIMARY KEY(id_empleado, id_role)
);