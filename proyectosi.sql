-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-12-2022 a las 06:13:03
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectosi`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiantes`
--

CREATE TABLE `estudiantes` (
  `codigo` int(11) NOT NULL,
  `nombres` varchar(20) NOT NULL,
  `apellidos` varchar(20) NOT NULL,
  `semestre` varchar(20) NOT NULL,
  `identificacion` varchar(20) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `user` varchar(30) NOT NULL,
  `clave` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupo`
--

CREATE TABLE `grupo` (
  `id_Grupo` int(20) NOT NULL,
  `nick` varchar(20) NOT NULL,
  `participante_1` varchar(20) DEFAULT NULL,
  `participante_2` varchar(20) DEFAULT NULL,
  `participante_3` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `grupo`
--

INSERT INTO `grupo` (`id_Grupo`, `nick`, `participante_1`, `participante_2`, `participante_3`) VALUES
(2000, 'Hola', 'Shina M', 'Esteban Martinez', 'Oscar Fuentes'),
(2001, 'Bienvenido', 'Pedro Morales', 'Andres Garcia', NULL),
(2003, 'Haunt', 'Jhon Jairo', 'Steven Leal', 'Shina Mashiro'),
(2004, 'Benz', 'Jhon Jairo', 'Shina Mashiro', 'xd'),
(2008, 'LosZ', 'Steven Leal', 'Shina Mashiro', 'Jhon Jairo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesores`
--

CREATE TABLE `profesores` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `identificacion` varchar(20) NOT NULL,
  `cargo` varchar(30) NOT NULL,
  `correo` varchar(40) DEFAULT NULL,
  `user` varchar(30) NOT NULL,
  `clave` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `profesores`
--

INSERT INTO `profesores` (`codigo`, `nombre`, `identificacion`, `cargo`, `correo`, `user`, `clave`) VALUES
(33, 'Jimmy Jimenez', '1043635986', 'Admin', '', 'JimmyJimenez_33', '12'),
(36, 'Esteban Martinez', '3308199', 'Profesor', 'jimmy.jimenez@unicolombo.edu.co', 'Esteban Martinez_36', '23'),
(43, 'Shina Mashiro', '123456789', 'Estudiante', 'jimmy.jimenez@unicolombo.edu.co', 'Shina Mashiro_43', '44'),
(58, 'Jhon Jairo', '1048440943', 'Estudiante', 'jhon.arango@unicolombo.edu.co', 'Jhon Jairo_58', '4'),
(59, 'Steven Leal', '12345', 'Estudiante', NULL, 'Steven Leal_59', '66'),
(66, 'df', '123457', 'Profesor', 'gf', 'df_60', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyectos`
--

CREATE TABLE `proyectos` (
  `codigo` int(200) NOT NULL,
  `acronimo` varchar(20) NOT NULL,
  `lider_proyecto` varchar(30) NOT NULL,
  `id_profesor` varchar(14) NOT NULL,
  `objetivo` varchar(30) NOT NULL,
  `fecha` varchar(30) NOT NULL,
  `id_grupo` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `proyectos`
--

INSERT INTO `proyectos` (`codigo`, `acronimo`, `lider_proyecto`, `id_profesor`, `objetivo`, `fecha`, `id_grupo`) VALUES
(20221, 'Sistema Solar ', 'Esteban Martinez', '3308199', 'Estudiar el sistema', '19/12/2022 10:03', 2000),
(20222, 'Logistica', 'Esteban Martinez', '3308199', 'Optimizacion de procesos de lo', '17/11/2022 07:44', 2001);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `grupo`
--
ALTER TABLE `grupo`
  ADD PRIMARY KEY (`id_Grupo`),
  ADD UNIQUE KEY `id_Grupo` (`id_Grupo`);

--
-- Indices de la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `identificacion` (`identificacion`),
  ADD KEY `identificacion_2` (`identificacion`),
  ADD KEY `identificacion_3` (`identificacion`);

--
-- Indices de la tabla `proyectos`
--
ALTER TABLE `proyectos`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `Grupo` (`id_grupo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `grupo`
--
ALTER TABLE `grupo`
  MODIFY `id_Grupo` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2009;

--
-- AUTO_INCREMENT de la tabla `profesores`
--
ALTER TABLE `profesores`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;

--
-- AUTO_INCREMENT de la tabla `proyectos`
--
ALTER TABLE `proyectos`
  MODIFY `codigo` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20224;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
