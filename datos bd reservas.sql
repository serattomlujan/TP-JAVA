INSERT INTO `reservas`.`categorias` (`descripcion`) VALUES('encargado');
INSERT INTO `reservas`.`categorias`(`descripcion`) VALUES('administrador');
INSERT INTO `reservas`.`categorias`(`descripcion`) VALUES('usuario');


INSERT INTO `reservas`.`tipo_elemento`
(`nombre_tipo`,`cant_max`,`lim_tiempo`,`dias_anticip`) VALUES('proyector',2,5,7);
INSERT INTO `reservas`.`tipo_elemento`
(`nombre_tipo`,`cant_max`,`lim_tiempo`,`dias_anticip`,encargado) VALUES('pantalla',2,8,3,1);
INSERT INTO `reservas`.`tipo_elemento`
(`nombre_tipo`,`cant_max`,`lim_tiempo`,`dias_anticip`,encargado) VALUES('cochera',1,24,3,1);
INSERT INTO `reservas`.`tipo_elemento`
(`nombre_tipo`,`cant_max`,`lim_tiempo`,`dias_anticip`) VALUES('notebook',5,3,2);


INSERT INTO `reservas`.`elementos`(`nombre`,`idtipo_elemento`) VALUES ('benQ',1);
INSERT INTO `reservas`.`elementos`(`nombre`,`idtipo_elemento`) VALUES ('epson 7200',1);
INSERT INTO `reservas`.`elementos`(`nombre`,`idtipo_elemento`) VALUES ('epson 9200',1);
INSERT INTO `reservas`.`elementos`(`nombre`,`idtipo_elemento`) VALUES ('subsuelo a',3);
INSERT INTO `reservas`.`elementos`(`nombre`,`idtipo_elemento`) VALUES ('subsuelo b',3);
INSERT INTO `reservas`.`elementos`(`nombre`,`idtipo_elemento`) VALUES ('acer negra',4);
INSERT INTO `reservas`.`elementos`(`nombre`,`idtipo_elemento`) VALUES ('acer gris',4);
INSERT INTO `reservas`.`elementos`(`nombre`,`idtipo_elemento`) VALUES ('lenovo',4);
INSERT INTO `reservas`.`elementos`(`nombre`,`idtipo_elemento`) VALUES ('lenovo',4);

INSERT INTO `reservas`.`personas`
(`dni`,`nombre`,`apellido`,`usuario`,`contrasenia`,`habilitado`,`id_categoria`)
VALUES ('123456','Juan','Perez','jperez','123',1,3);
INSERT INTO `reservas`.`personas`
(`dni`,`nombre`,`apellido`,`usuario`,`contrasenia`,`habilitado`,`id_categoria`)
VALUES ('555555','Daniel','Gomez','danig','777',1,1);
INSERT INTO `reservas`.`personas`
(`dni`,`nombre`,`apellido`,`usuario`,`contrasenia`,`habilitado`,`id_categoria`)
VALUES ('987654','Mariana','Sanchez','marianb','121',1,2);
INSERT INTO `reservas`.`personas`
(`dni`,`nombre`,`apellido`,`usuario`,`contrasenia`,`habilitado`,`id_categoria`)
VALUES ('4567890','Elsa','Natorio','elsita1','456',1,3);











