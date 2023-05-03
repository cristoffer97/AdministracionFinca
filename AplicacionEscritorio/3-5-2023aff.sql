-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-05-2023 a las 18:54:53
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `aff`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuadrilla`
--

CREATE TABLE `cuadrilla` (
  `Cod_Cuadrilla` int(11) NOT NULL,
  `nombre` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cuadrilla`
--

INSERT INTO `cuadrilla` (`Cod_Cuadrilla`, `nombre`) VALUES
(1, 'Veteranos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fruta`
--

CREATE TABLE `fruta` (
  `Cod_Fruta` int(11) NOT NULL,
  `Variedad` varchar(30) DEFAULT NULL,
  `nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `fruta`
--

INSERT INTO `fruta` (`Cod_Fruta`, `Variedad`, `nombre`) VALUES
(0, 'Nectarina\r\n', 'Freestone'),
(1, 'Baby God', 'Melocoton');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `herramientas`
--

CREATE TABLE `herramientas` (
  `Cod_Herramienta` int(11) NOT NULL,
  `Nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `herramientas`
--

INSERT INTO `herramientas` (`Cod_Herramienta`, `Nombre`) VALUES
(1, 'Desbrozadora'),
(2, 'Toro mecanico'),
(3, 'Cuba');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `informes`
--

CREATE TABLE `informes` (
  `Id` int(11) NOT NULL,
  `Cod_Perito` int(11) NOT NULL,
  `Id_Fruta` int(11) NOT NULL,
  `Asunto` varchar(50) DEFAULT NULL,
  `Descripcion` varchar(500) NOT NULL,
  `Fecha` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `informes`
--

INSERT INTO `informes` (`Id`, `Cod_Perito`, `Id_Fruta`, `Asunto`, `Descripcion`, `Fecha`) VALUES
(2, 4, 1, 'PruebaNetbeanas', 'Esto es una prueba de netbeans', '2023-04-26'),
(3, 1202, 0, 'Peruebkasnbgfoasng', 'dfsanfoiasngosadngioasn', '2023-04-26');

--
-- Disparadores `informes`
--
DELIMITER $$
CREATE TRIGGER `Registrar_Informes` AFTER INSERT ON `informes` FOR EACH ROW BEGIN  
INSERT INTO registro_informe_perito (`Cod_Perito`, `Id_Fruta`, `Asunto`,`Descripcion`)  VALUES (new.Cod_Perito, new.Id_Fruta , new.Asunto,new.Descripcion);  
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro`
--

CREATE TABLE `registro` (
  `ID` int(11) NOT NULL,
  `ID_Cuadrilla` int(11) NOT NULL,
  `ID_Tarea` int(11) NOT NULL,
  `ID_Fruta` int(11) NOT NULL,
  `TipoRecogida` varchar(20) DEFAULT NULL,
  `Fecha` date DEFAULT current_timestamp(),
  `CantidadPaleps` int(11) NOT NULL DEFAULT 0,
  `Nº_Pase` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `registro`
--

INSERT INTO `registro` (`ID`, `ID_Cuadrilla`, `ID_Tarea`, `ID_Fruta`, `TipoRecogida`, `Fecha`, `CantidadPaleps`, `Nº_Pase`) VALUES
(0, 1, 2, 0, 'CAJA', '2023-04-20', 0, 1);

--
-- Disparadores `registro`
--
DELIMITER $$
CREATE TRIGGER `Registrar_Tarea_Cuadrilla` AFTER INSERT ON `registro` FOR EACH ROW BEGIN  
INSERT INTO `registro_tarea_cuadrilla`(`ID_Cuadrilla`, `ID_Tarea`, `ID_Fruta`, `TipoRecogida`, `CantidadPaleps`, `Nº_Pase`) VALUES (new.ID_Cuadrilla , new.ID_Tarea , new.ID_Fruta ,new.TipoRecogida,new.CantidadPaleps, new.Nº_Pase);  
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registrofichar`
--

CREATE TABLE `registrofichar` (
  `ID` int(11) NOT NULL,
  `Cod_Trabajador` int(11) NOT NULL,
  `HEntada` timestamp NOT NULL DEFAULT current_timestamp(),
  `HSalida` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `registrofichar`
--

INSERT INTO `registrofichar` (`ID`, `Cod_Trabajador`, `HEntada`, `HSalida`) VALUES
(1, 4229, '2023-02-09 18:28:59', '2023-02-09 18:28:59'),
(2, 95, '2023-02-09 18:34:48', '2023-02-09 18:54:12'),
(3, 101, '2023-02-09 18:36:25', '2023-02-09 18:36:25'),
(4, 100, '2023-02-09 18:36:38', '2023-02-09 18:36:38'),
(5, 95, '2023-02-09 18:46:21', '2023-02-09 18:54:12'),
(6, 95, '2023-02-12 18:55:10', '2023-02-12 18:55:17'),
(7, 95, '2023-02-06 19:03:59', '2023-02-06 19:04:23'),
(8, 122, '2023-03-25 14:16:23', '2023-03-25 17:18:56'),
(9, 97, '2023-03-22 09:11:49', '2023-03-22 09:11:49'),
(10, 101, '2023-03-25 09:14:52', '2023-03-25 15:14:52'),
(11, 122, '2023-03-29 17:26:41', '2023-03-29 21:26:41');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registrotrabajadores`
--

CREATE TABLE `registrotrabajadores` (
  `ID` int(11) NOT NULL,
  `Cod_Trabajador` int(11) NOT NULL,
  `DNI` varchar(9) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Apellidos` varchar(50) NOT NULL,
  `FAlta` date NOT NULL DEFAULT current_timestamp(),
  `FBaja` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `registrotrabajadores`
--

INSERT INTO `registrotrabajadores` (`ID`, `Cod_Trabajador`, `DNI`, `Nombre`, `Apellidos`, `FAlta`, `FBaja`) VALUES
(1, 4229, 'Es un bue', 'Cristoffer', 'Alcalde Bautista', '2023-02-06', '2023-04-20'),
(2, 4755, '', 'Maria', 'Universita', '2023-02-06', '2023-02-09'),
(3, 15785, '', 'Cristoffer', 'Alcalde', '2023-02-09', '2023-02-09'),
(4, 25634, '', 'Mary', 'Muñoz Ramos', '2023-02-09', '2023-02-09'),
(5, 95, '', 'Ainhoa', 'Huertas Pizarro', '2023-02-09', '2023-02-09'),
(6, 8, '', 'Martin', 'Gonzalez Fernandez', '2023-02-20', '2023-02-20'),
(7, 97, '', 'Cristo', 'Alcalde Bautista', '2023-02-20', '2023-02-20'),
(8, 951, '', 'Carlos Javier', 'Mata', '2023-02-25', '2023-02-25'),
(9, 42, '', 'Cristoffer', 'alcal', '2023-03-06', '2023-03-15'),
(10, 4100, '', 'cristo', 'alcal', '2023-03-06', '2023-03-06'),
(11, 421, '', 'sdfas', 'asdffas', '2023-03-06', '2023-03-06'),
(12, 41, '', 'fasfasdf', 'efasdfasfs', '2023-03-06', '2023-03-06'),
(13, 4122, '', 'fasfasdf', 'efasdfasfs', '2023-03-06', '2023-03-06'),
(14, 10, '', 'Cristo', 'Alcalde', '2023-03-15', '2023-03-15'),
(15, 1, '', 'federico', 'mata', '2023-03-16', '2023-03-16'),
(16, 142, '12345679G', 'GABRIEL', 'NAVARRO PAREJO', '2023-03-24', '2023-03-24'),
(17, 10, 'Javie', 'GABRIELinColorado', 'NAVARRO PAREJO', '2023-03-24', '2023-03-24'),
(20, 5, '12345678A', 'Cristo', 'alcalde', '2023-03-25', '2023-03-25'),
(21, 4, '12345678B', 'Cristo', 'alcalde', '2023-03-25', '2023-03-25'),
(22, 4229, 'Es un bue', 'Cristoffer', 'Alcalde Bautista', '2023-04-20', '2023-04-20'),
(23, 45, '95135745g', 'Marcos', 'Feval', '2023-04-26', '2023-04-26');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro_informe_perito`
--

CREATE TABLE `registro_informe_perito` (
  `Id` int(11) NOT NULL,
  `Cod_Perito` int(11) NOT NULL,
  `Id_Fruta` int(11) NOT NULL,
  `Asunto` varchar(50) DEFAULT NULL,
  `Descripcion` varchar(500) NOT NULL,
  `Fecha` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `registro_informe_perito`
--

INSERT INTO `registro_informe_perito` (`Id`, `Cod_Perito`, `Id_Fruta`, `Asunto`, `Descripcion`, `Fecha`) VALUES
(1, 1203, 1, 'PruebaV1', 'QWERTRY', '2023-04-20'),
(2, 4, 1, 'PruebaNetbeanas', 'Esto es una prueba de netbeans', '2023-04-26'),
(3, 1202, 0, 'Peruebkasnbgfoasng', 'dfsanfoiasngosadngioasn', '2023-04-26');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro_tarea_cuadrilla`
--

CREATE TABLE `registro_tarea_cuadrilla` (
  `ID` int(11) NOT NULL,
  `ID_Cuadrilla` int(11) NOT NULL,
  `ID_Tarea` int(11) NOT NULL,
  `ID_Fruta` int(11) NOT NULL,
  `TipoRecogida` varchar(20) DEFAULT NULL,
  `Fecha` date DEFAULT current_timestamp(),
  `CantidadPaleps` int(11) NOT NULL DEFAULT 0,
  `Nº_Pase` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `registro_tarea_cuadrilla`
--

INSERT INTO `registro_tarea_cuadrilla` (`ID`, `ID_Cuadrilla`, `ID_Tarea`, `ID_Fruta`, `TipoRecogida`, `Fecha`, `CantidadPaleps`, `Nº_Pase`) VALUES
(1, 1, 2, 0, 'CAJA', '2023-04-20', 0, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro_tractor_tractorista`
--

CREATE TABLE `registro_tractor_tractorista` (
  `ID` int(11) NOT NULL,
  `ID_Tractor` int(11) NOT NULL,
  `ID_Tractorista` int(11) NOT NULL,
  `FInicio` date DEFAULT current_timestamp(),
  `FFin` date DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `registro_tractor_tractorista`
--

INSERT INTO `registro_tractor_tractorista` (`ID`, `ID_Tractor`, `ID_Tractorista`, `FInicio`, `FFin`) VALUES
(1, 5, 122, '2023-04-20', '2023-05-03');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tareas`
--

CREATE TABLE `tareas` (
  `Cod_Tarea` int(11) NOT NULL,
  `nombre` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tareas`
--

INSERT INTO `tareas` (`Cod_Tarea`, `nombre`) VALUES
(0, 'Curar'),
(1, 'Entresacar'),
(2, 'Recogida'),
(3, 'Poda'),
(4, 'Curar'),
(5, 'Triturar'),
(6, 'Pasar Rast');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_trabajador`
--

CREATE TABLE `tipo_trabajador` (
  `id_Tipo` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_trabajador`
--

INSERT INTO `tipo_trabajador` (`id_Tipo`, `nombre`) VALUES
(1, 'Encargado'),
(2, 'Manijero'),
(3, 'Tractorista'),
(4, 'Jornalero'),
(5, 'Perito');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajadores`
--

CREATE TABLE `trabajadores` (
  `Cod_Trabajador` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `DNI` varchar(9) DEFAULT NULL,
  `telefono` int(9) NOT NULL,
  `Cuadrilla` int(11) DEFAULT NULL,
  `podador` tinyint(1) DEFAULT NULL,
  `Tipo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `trabajadores`
--

INSERT INTO `trabajadores` (`Cod_Trabajador`, `nombre`, `apellido`, `DNI`, `telefono`, `Cuadrilla`, `podador`, `Tipo`) VALUES
(4, 'Cristo', 'alcaldebAUTISTA', '12345678B', 147963258, 1, 1, 1),
(5, 'Cristo', 'alcalde', '12345678A', 123456789, 1, 0, 2),
(6, 'Alcalde', 'Mata', '12345678C', 123456789, 1, 0, 2),
(7, 'Alcalde', 'Mata', '12345678D', 123456789, 1, 0, 2),
(8, 'Alcalde', 'MataRey', '1234567QW', 123456789, 1, 0, 3),
(10, 'Alcalde', 'Mata', '12345678F', 123456789, 1, 0, 2),
(97, 'Alcalde', 'Mata', '12345673G', 123456789, 1, 0, 2),
(101, 'Alcalde', 'Mata', '12345678Q', 123456789, 1, 0, 4),
(122, 'Alcalde', 'Mata', '12345678W', 123456789, 1, 0, 2),
(135, 'Alcalde', 'Mata', '12345678T', 123456789, 1, 0, 2),
(142, 'Alcalde', 'Mata', '12345678Z', 123456789, 1, 0, 4),
(951, 'Alcalde', 'Mata', '12345678X', 123456789, 1, 0, 4),
(1202, 'Alcalde', 'Mata', '12345678G', 123456789, 1, 0, 2),
(1205, 'Alcalde', 'Mata', '12345678O', 123456789, 1, 0, 4),
(4229, 'Cristoffer', 'Alcalde Bautista', 'Es un bue', 123456789, 1, NULL, 1),
(4300, 'Alcalde', 'Mata', '12345678I', 123456789, 1, 0, 4),
(15785, 'Alcalde', 'Mata', '12345678M', 123456789, 1, 0, 4);

--
-- Disparadores `trabajadores`
--
DELIMITER $$
CREATE TRIGGER `Borrar_Trabajador_en_Registro` BEFORE DELETE ON `trabajadores` FOR EACH ROW BEGIN  
UPDATE `registrotrabajadores` SET `FBaja`= now() WHERE Cod_Trabajador=old.Cod_Trabajador;  
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `Insertar_Trabajador_en_Registro` AFTER INSERT ON `trabajadores` FOR EACH ROW BEGIN  
INSERT INTO registrotrabajadores (`Cod_Trabajador`, `Nombre`, `Apellidos`,`DNI`)  VALUES (new.Cod_Trabajador, new.nombre, new.apellido,new.dni);  
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tractores`
--

CREATE TABLE `tractores` (
  `Cod_Tractor` int(11) NOT NULL,
  `Matricula` varchar(10) NOT NULL,
  `herramientas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tractores`
--

INSERT INTO `tractores` (`Cod_Tractor`, `Matricula`, `herramientas`) VALUES
(4, '123456', 1),
(5, '777', 2),
(7, '555', 1),
(12, 'sdfasfasd', 2),
(14, '1235fdg', 2),
(25, '977', 2),
(30, '2156', 1),
(42, 'safasfasdf', 3),
(45, '12152', 1),
(300, '12564', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tractor_tractorista`
--

CREATE TABLE `tractor_tractorista` (
  `ID` int(11) NOT NULL,
  `id_Tractor` int(11) NOT NULL,
  `Tractorista` int(11) NOT NULL,
  `F_Inicio` date DEFAULT current_timestamp(),
  `F_FIN` date DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tractor_tractorista`
--

INSERT INTO `tractor_tractorista` (`ID`, `id_Tractor`, `Tractorista`, `F_Inicio`, `F_FIN`) VALUES
(1, 4, 8, '2023-04-20', '2023-05-02'),
(3, 5, 6, '2023-04-20', '2023-04-24');

--
-- Disparadores `tractor_tractorista`
--
DELIMITER $$
CREATE TRIGGER `Guardar_Registros_Tractorista_Tractor` BEFORE INSERT ON `tractor_tractorista` FOR EACH ROW BEGIN  
INSERT INTO registro_tractor_tractorista (`id_Tractor`, `ID_Tractorista`)  VALUES (new.id_Tractor, new.Tractorista);  
END
$$
DELIMITER ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cuadrilla`
--
ALTER TABLE `cuadrilla`
  ADD PRIMARY KEY (`Cod_Cuadrilla`);

--
-- Indices de la tabla `fruta`
--
ALTER TABLE `fruta`
  ADD PRIMARY KEY (`Cod_Fruta`);

--
-- Indices de la tabla `herramientas`
--
ALTER TABLE `herramientas`
  ADD PRIMARY KEY (`Cod_Herramienta`);

--
-- Indices de la tabla `informes`
--
ALTER TABLE `informes`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Cod_Perito` (`Cod_Perito`),
  ADD KEY `Id_Fruta` (`Id_Fruta`);

--
-- Indices de la tabla `registro`
--
ALTER TABLE `registro`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_Cuadrilla` (`ID_Cuadrilla`),
  ADD KEY `ID_Tarea` (`ID_Tarea`),
  ADD KEY `ID_Fruta` (`ID_Fruta`);

--
-- Indices de la tabla `registrofichar`
--
ALTER TABLE `registrofichar`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `registrotrabajadores`
--
ALTER TABLE `registrotrabajadores`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Cod_Trabajador` (`Cod_Trabajador`);

--
-- Indices de la tabla `registro_informe_perito`
--
ALTER TABLE `registro_informe_perito`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Cod_Perito` (`Cod_Perito`),
  ADD KEY `Id_Fruta` (`Id_Fruta`);

--
-- Indices de la tabla `registro_tarea_cuadrilla`
--
ALTER TABLE `registro_tarea_cuadrilla`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_Cuadrilla` (`ID_Cuadrilla`),
  ADD KEY `ID_Tarea` (`ID_Tarea`),
  ADD KEY `ID_Fruta` (`ID_Fruta`);

--
-- Indices de la tabla `registro_tractor_tractorista`
--
ALTER TABLE `registro_tractor_tractorista`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `tareas`
--
ALTER TABLE `tareas`
  ADD PRIMARY KEY (`Cod_Tarea`);

--
-- Indices de la tabla `tipo_trabajador`
--
ALTER TABLE `tipo_trabajador`
  ADD PRIMARY KEY (`id_Tipo`);

--
-- Indices de la tabla `trabajadores`
--
ALTER TABLE `trabajadores`
  ADD PRIMARY KEY (`Cod_Trabajador`),
  ADD UNIQUE KEY `DNI` (`DNI`),
  ADD KEY `Cuadrilla` (`Cuadrilla`),
  ADD KEY `Tipo` (`Tipo`);

--
-- Indices de la tabla `tractores`
--
ALTER TABLE `tractores`
  ADD PRIMARY KEY (`Cod_Tractor`),
  ADD KEY `herramientas` (`herramientas`);

--
-- Indices de la tabla `tractor_tractorista`
--
ALTER TABLE `tractor_tractorista`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `id_Tractor` (`id_Tractor`),
  ADD KEY `Tractorista` (`Tractorista`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `informes`
--
ALTER TABLE `informes`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `registrofichar`
--
ALTER TABLE `registrofichar`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `registrotrabajadores`
--
ALTER TABLE `registrotrabajadores`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `registro_informe_perito`
--
ALTER TABLE `registro_informe_perito`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `registro_tarea_cuadrilla`
--
ALTER TABLE `registro_tarea_cuadrilla`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `registro_tractor_tractorista`
--
ALTER TABLE `registro_tractor_tractorista`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tipo_trabajador`
--
ALTER TABLE `tipo_trabajador`
  MODIFY `id_Tipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tractor_tractorista`
--
ALTER TABLE `tractor_tractorista`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `informes`
--
ALTER TABLE `informes`
  ADD CONSTRAINT `informes_ibfk_2` FOREIGN KEY (`Id_Fruta`) REFERENCES `fruta` (`Cod_Fruta`),
  ADD CONSTRAINT `informes_ibfk_3` FOREIGN KEY (`Cod_Perito`) REFERENCES `trabajadores` (`Cod_Trabajador`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `registro`
--
ALTER TABLE `registro`
  ADD CONSTRAINT `registro_ibfk_2` FOREIGN KEY (`ID_Tarea`) REFERENCES `tareas` (`Cod_Tarea`),
  ADD CONSTRAINT `registro_ibfk_3` FOREIGN KEY (`ID_Fruta`) REFERENCES `fruta` (`Cod_Fruta`),
  ADD CONSTRAINT `registro_ibfk_4` FOREIGN KEY (`ID_Cuadrilla`) REFERENCES `cuadrilla` (`Cod_Cuadrilla`);

--
-- Filtros para la tabla `trabajadores`
--
ALTER TABLE `trabajadores`
  ADD CONSTRAINT `trabajadores_ibfk_1` FOREIGN KEY (`Cuadrilla`) REFERENCES `cuadrilla` (`Cod_Cuadrilla`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `trabajadores_ibfk_2` FOREIGN KEY (`Tipo`) REFERENCES `tipo_trabajador` (`id_Tipo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tractores`
--
ALTER TABLE `tractores`
  ADD CONSTRAINT `tractores_ibfk_1` FOREIGN KEY (`herramientas`) REFERENCES `herramientas` (`Cod_Herramienta`);

--
-- Filtros para la tabla `tractor_tractorista`
--
ALTER TABLE `tractor_tractorista`
  ADD CONSTRAINT `tractor_tractorista_ibfk_1` FOREIGN KEY (`id_Tractor`) REFERENCES `tractores` (`Cod_Tractor`),
  ADD CONSTRAINT `tractor_tractorista_ibfk_2` FOREIGN KEY (`Tractorista`) REFERENCES `trabajadores` (`Cod_Trabajador`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
