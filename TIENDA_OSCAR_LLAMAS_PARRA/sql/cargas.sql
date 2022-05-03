USE tienda_oscar_llamas_parra;

INSERT INTO categorias (nombre, descripcion)
VALUES ("Cuerda", "Instrumentos de cuerda frotada, punteada o percutida."),
("Viento metal","Instrumentos de viento metal: Tubas, trombones, trompetas,etc."),
("Viento madera","Instrumentos de viento madera: Flautas, clarinetes, saxofones, oboes, etc."),
("Percusion", "Instrumentos de percusion como cajas, tambores, platillos, etc."),
("Sintetizadores","Instrumentos electronicos MIDI.");

INSERT INTO roles (rol)
VALUES ("Cliente"),("Empleado"),("Administrador");

INSERT INTO usuarios (email, id_rol, clave, nombre, apellido1, apellido2, direccion, provincia, localidad, telefono, dni)
VALUES ("admin@admin.com", 3, SHA2('admin',256), "Admin", "istra","dor", "C/ Administrador nº 1", "Zamora", "Zamora", "666666666", "12345678Z" ),
("empleado1@tienda.com", 2, SHA2('paso',256), "Manuel", "Perez","Perez", "C/ Tienda nº 1", "Zamora", "Zamora", "677777777", "96930871Q" ),
("cliente1@mail.com", 1, SHA2('paso',256), "Pedro", "Fernandez","Fernandez", "C/ Ejemplo nº 1", "Zamora", "Zamora", "688888888", "17982331B" );

INSERT INTO proveedores (nombre, direccion, localidad, provincia, telefono, cif, email) 
VALUES ("Guitarras Paco","C/ Musica nº2","Zamora","Zamora","966666666","Q0541744I","paco@guitarras.com" ),
("Vientos Eos","C/ Aire nº3","Benavente", "Zamora", "999666999","V09595059","vientos@musica.com");

INSERT INTO productos (id_categoria,nombre,descripcion,precio,stock,fecha_baja,impuesto,imagen,audio,id_proveedor)
VALUES (1, "Guitarra", "Guitarra española",71.90, 321, null, 12, null,null,1),
(2, "Trompeta", "Trompeta normal",287.83, 123, null, 12, null,null,2);

INSERT INTO metodos_pago (metodo_pago)
VALUES ("Tarjeta"),("Paypal");

INSERT INTO opciones_menu (id_rol,nombre_opcion,url_opcion)
VALUES (1,"Mis pedidos","ServletPedido"),
(2,"Gestionar productos","/productos"),
(2,"Gestionar clientes","/login/clientes"),
(2,"Gestionar pedidos","/pedidos"),
(2,"Gestionar proveedores","/proveedores"),
(3,"Gestionar productos","/productos"),
(3,"Gestionar clientes","/login/clientes"),
(3,"Gestionar pedidos","/pedidos"),
(3,"Gestionar proveedores","/proveedores"),
(3,"Gestionar empleados","/login/empleados"),
(3,"Configurar aplicacion","/config");

INSERT INTO configuracion (clave,valor,tipo)
VALUES ("nombreTienda","","Texto"),
("direccionTienda", "C/Cosas nº 5", "Texto"),
("cifTienda", "D04272357", "Texto"),
("numFacturas","1","Numero")