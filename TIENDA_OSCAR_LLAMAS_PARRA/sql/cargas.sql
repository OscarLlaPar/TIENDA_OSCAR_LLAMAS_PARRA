USE tienda;

INSERT INTO categorias (nombre, descripcion)
VALUES ("Cuerda", "Instrumentos de cuerda frotada, punteada o percutida."),
("Viento metal","Instrumentos de viento metal: Tubas, trombones, trompetas,etc."),
("Viento madera","Instrumentos de viento madera: Flautas, clarinetes, saxofones, oboes, etc."),
("Percusion", "Instrumentos de percusion como cajas, tambores, platillos, etc."),
("Sintetizadores","Instrumentos electronicos MIDI.");

INSERT INTO roles (rol)
VALUES ("Cliente"),("Empleado"),("Administrador");

INSERT INTO usuarios (id_rol, email, clave, nombre, apellido1, apellido2, direccion, provincia, localidad, telefono, dni)
VALUES (3, "admin@admin.com", SHA2('adminadmin',256), "admin", "istra","dor", "C/ Administrador nº 1", "Zamora", "Zamora", "666666666", "12345678Z" ),
(2, "empleado1@tienda.com", SHA2('empleado1paso',256), "empleado1", "Perez","Perez", "C/ Tienda nº 1", "Zamora", "Zamora", "677777777", "96930871Q" ),
(1, "cliente1@mail.com", SHA2('cliente1paso',256), "cliente1", "Fernandez","Fernandez", "C/ Ejemplo nº 1", "Zamora", "Zamora", "688888888", "17982331B" );


INSERT INTO productos (id_categoria,nombre,descripcion,precio,stock,fecha_baja,impuesto,imagen)
VALUES (1, "Guitarra", "Guitarra española",71.90, 321, null, 12, null),
(2, "Trompeta", "Trompeta normal",287.83, 123, null, 12, null);