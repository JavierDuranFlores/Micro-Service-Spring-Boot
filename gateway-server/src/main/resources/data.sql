INSERT INTO empleados (id_empleado, correo, nombre, password, usuario) VALUES (DEFAULT, 'usr_create@gmail.com', 'usrcreate', '$2a$10$yDfwfZZcIzaL9I9neTy.ZuMh30QnWpFn2Ua2/hfjfh7D2dmF7dZne', 'usr-create');
INSERT INTO empleados (id_empleado, correo, nombre, password, usuario) VALUES (DEFAULT, 'usr_read@gmail.com', 'usrread', '$2a$10$yDfwfZZcIzaL9I9neTy.ZuMh30QnWpFn2Ua2/hfjfh7D2dmF7dZne', 'usr-read');
INSERT INTO empleados (id_empleado, correo, nombre, password, usuario) VALUES (DEFAULT, 'usr_update@gmail.com', 'usrupdate', '$2a$10$yDfwfZZcIzaL9I9neTy.ZuMh30QnWpFn2Ua2/hfjfh7D2dmF7dZne', 'usr-update');
INSERT INTO empleados (id_empleado, correo, nombre, password, usuario) VALUES (DEFAULT, 'usr_delete@gmail.com', 'usrdelete', '$2a$10$yDfwfZZcIzaL9I9neTy.ZuMh30QnWpFn2Ua2/hfjfh7D2dmF7dZne', 'usr-delete');
INSERT INTO empleados (id_empleado, correo, nombre, password, usuario) VALUES (DEFAULT, 'usr_admin@gmail.com', 'usradmin', '$2a$10$yDfwfZZcIzaL9I9neTy.ZuMh30QnWpFn2Ua2/hfjfh7D2dmF7dZne', 'usr-admin');

INSERT INTO roles (id_role, nombre) VALUES (DEFAULT, 'CREATE'),(DEFAULT, 'READ'), (DEFAULT, 'UPDATE'), (DEFAULT, 'DELETE');
INSERT INTO empleados_roles (id_empleado, id_role) VALUES (1, 1);
INSERT INTO empleados_roles (id_empleado, id_role) VALUES (2, 2);
INSERT INTO empleados_roles (id_empleado, id_role) VALUES (3, 3);
INSERT INTO empleados_roles (id_empleado, id_role) VALUES (4, 4);
INSERT INTO empleados_roles (id_empleado, id_role) VALUES (5, 1);
INSERT INTO empleados_roles (id_empleado, id_role) VALUES (5, 2);
INSERT INTO empleados_roles (id_empleado, id_role) VALUES (5, 3);
INSERT INTO empleados_roles (id_empleado, id_role) VALUES (5, 4);