-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-04-2023 a las 08:09:30
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

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
-- Estructura de tabla para la tabla `estudiante`
--

CREATE TABLE `estudiante` (
  `codigo` int(11) NOT NULL,
  `carrera` varchar(40) DEFAULT NULL,
  `semestre` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `estudiante`
--

INSERT INTO `estudiante` (`codigo`, `carrera`, `semestre`) VALUES
(20222, 'Sistema', '4'),
(20225, 'DSF', 'SFSD');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupo`
--

CREATE TABLE `grupo` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `grupo`
--

INSERT INTO `grupo` (`codigo`, `nombre`) VALUES
(2000, 'Otakus');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupo_persona`
--

CREATE TABLE `grupo_persona` (
  `codigo_grupo` int(11) NOT NULL,
  `codigo_persona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `identificacion` varchar(20) DEFAULT NULL,
  `tipo_persona` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `clave` varchar(20) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  `estado` varchar(20) NOT NULL DEFAULT 'Activo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`codigo`, `nombre`, `apellido`, `identificacion`, `tipo_persona`, `email`, `clave`, `telefono`, `estado`) VALUES
(20221, 'Jimmy', 'Jimenez Bravo', '1043635986', 'Administrador', 'jimmy.jimenez@unicolombo.edu.co', 'facil', '3016634773', 'Activo'),
(20222, 'Shina', 'Mashiro', '1070000', 'Estudiante', 'shina.m@gmail.com', '12345', '1111111', 'Activo'),
(20223, 'Eren', 'Yeager', '222222', 'Profesor', 'Atack.Titan@.com,', '2222', '303', 'Activo'),
(20224, 'Elena', 'Yea', '3333', 'Profesor', 'Atack.Titan@.com,', '222332', '303', 'Inactivo'),
(20225, 'D', 'D', 'SS', 'Estudiante', 'S', 'S', 'S', 'Inactivo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

CREATE TABLE `profesor` (
  `codigo` int(11) NOT NULL,
  `departamento` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`codigo`, `departamento`) VALUES
(20223, 'Informatica'),
(20224, 'Turismo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyectos`
--

CREATE TABLE `proyectos` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_inicio` varchar(30) DEFAULT NULL,
  `likes` int(11) DEFAULT NULL,
  `codigo_grupo` int(11) DEFAULT NULL,
  `codigo_lider_proyecto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proyectos`
--

INSERT INTO `proyectos` (`codigo`, `nombre`, `descripcion`, `fecha_inicio`, `likes`, `codigo_grupo`, `codigo_lider_proyecto`) VALUES
(2005, 'El arte de Leer', 'Cuanto puede ayudar a una persona el leer', '29/04/2023 05:12', 0, 2000, 20222),
(2006, 'MS - Reconocimiento de voz', 'Creación de un sistema de reconocimiento de voz para personas con discapacidad auditiva', '30/04/2023 12:19', 0, 2000, 20222);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `grupo`
--
ALTER TABLE `grupo`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `grupo_persona`
--
ALTER TABLE `grupo_persona`
  ADD PRIMARY KEY (`codigo_grupo`,`codigo_persona`),
  ADD KEY `codigo_persona` (`codigo_persona`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `proyectos`
--
ALTER TABLE `proyectos`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `codigo_grupo` (`codigo_grupo`),
  ADD KEY `codigo_lider_proyecto` (`codigo_lider_proyecto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `grupo`
--
ALTER TABLE `grupo`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2002;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20226;

--
-- AUTO_INCREMENT de la tabla `proyectos`
--
ALTER TABLE `proyectos`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2007;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD CONSTRAINT `estudiante_ibfk_1` FOREIGN KEY (`codigo`) REFERENCES `persona` (`codigo`) ON DELETE CASCADE;

--
-- Filtros para la tabla `grupo_persona`
--
ALTER TABLE `grupo_persona`
  ADD CONSTRAINT `grupo_persona_ibfk_1` FOREIGN KEY (`codigo_grupo`) REFERENCES `grupo` (`codigo`) ON DELETE CASCADE,
  ADD CONSTRAINT `grupo_persona_ibfk_2` FOREIGN KEY (`codigo_persona`) REFERENCES `persona` (`codigo`) ON DELETE CASCADE;

--
-- Filtros para la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD CONSTRAINT `profesor_ibfk_1` FOREIGN KEY (`codigo`) REFERENCES `persona` (`codigo`) ON DELETE CASCADE;

--
-- Filtros para la tabla `proyectos`
--
ALTER TABLE `proyectos`
  ADD CONSTRAINT `proyectos_ibfk_1` FOREIGN KEY (`codigo_grupo`) REFERENCES `grupo` (`codigo`),
  ADD CONSTRAINT `proyectos_ibfk_2` FOREIGN KEY (`codigo_lider_proyecto`) REFERENCES `persona` (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
