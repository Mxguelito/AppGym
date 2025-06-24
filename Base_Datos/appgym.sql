-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-06-2025 a las 00:26:13
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `appgym`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `dni` int(11) NOT NULL,
  `Usuario_idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `basico`
--

CREATE TABLE `basico` (
  `id_basico` int(11) NOT NULL,
  `precio` int(11) NOT NULL,
  `idObjetivo` int(50) NOT NULL,
  `id_rutina` int(50) NOT NULL,
  `id_cliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `altura` int(11) NOT NULL,
  `peso` int(11) NOT NULL,
  `edad` int(11) NOT NULL,
  `nivel` varchar(45) NOT NULL,
  `idObjetivo` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nombre`, `altura`, `peso`, `edad`, `nivel`, `idObjetivo`) VALUES
(42, 'Naomi F', 163, 57, 25, 'Intermedio', 0),
(45, 'Mariana', 160, 60, 24, 'Intermedio', 0),
(46, 'Gladis', 160, 80, 60, 'Principiante', 0),
(47, 'Nery', 155, 90, 58, 'Principiante', 0),
(59, 'florcita', 156, 56, 25, 'Principiante', 4),
(61, 'Flor', 156, 56, 25, 'Intermedio', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `config`
--

CREATE TABLE `config` (
  `id_config` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `telefono` int(50) NOT NULL,
  `direccion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_plan`
--

CREATE TABLE `detalle_plan` (
  `id_detalle` int(11) NOT NULL,
  `codigo_detalle` int(50) NOT NULL,
  `detalle` varchar(50) NOT NULL,
  `cantidad` int(50) NOT NULL,
  `precio` decimal(10,0) NOT NULL,
  `fecha_Ingreso` date NOT NULL DEFAULT current_timestamp(),
  `id_plan` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_venta`
--

CREATE TABLE `detalle_venta` (
  `id_detalle` int(11) NOT NULL,
  `codigo_producto` varchar(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` double(11,2) NOT NULL,
  `id_venta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `detalle_venta`
--

INSERT INTO `detalle_venta` (`id_detalle`, `codigo_producto`, `cantidad`, `precio`, `id_venta`) VALUES
(1, '5', 3, 5500.00, 1),
(6, '2', 2, 4500.00, 9),
(7, '2', 1, 4500.00, 10),
(8, '7', 10, 2500.00, 11),
(9, '4', 4, 3400.00, 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dieta`
--

CREATE TABLE `dieta` (
  `id_dieta` int(11) NOT NULL,
  `desayuno` varchar(50) NOT NULL,
  `almuerzo` varchar(50) NOT NULL,
  `merienda` varchar(50) NOT NULL,
  `cena` varchar(50) NOT NULL,
  `idObjetivo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenador`
--

CREATE TABLE `entrenador` (
  `id_entrenador` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `telefono` int(11) NOT NULL,
  `especializacion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `entrenador`
--

INSERT INTO `entrenador` (`id_entrenador`, `nombre`, `telefono`, `especializacion`) VALUES
(9, 'Florencia', 1189654323, 'Estetica'),
(11, 'Mariana', 1157342214, 'Habitos'),
(14, 'Victor', 1159657130, 'Musculacion'),
(18, 'Diego', 1123435578, 'Video Juegos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `objetivo`
--

CREATE TABLE `objetivo` (
  `idObjetivo` int(11) NOT NULL,
  `descripcion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `objetivo`
--

INSERT INTO `objetivo` (`idObjetivo`, `descripcion`) VALUES
(1, 'Tonificacion General'),
(2, 'Definicion Muscular'),
(3, 'Hipertrofia'),
(4, 'Adelgazamiento'),
(5, 'Resistencia Cardiovascular');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plan`
--

CREATE TABLE `plan` (
  `id_plan` int(11) NOT NULL,
  `plan` varchar(50) NOT NULL,
  `codigo` varchar(11) NOT NULL,
  `precio` decimal(11,0) NOT NULL,
  `cliente` varchar(50) NOT NULL,
  `entrenador` varchar(50) NOT NULL,
  `fecha_Ingreso` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id_producto` int(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `codigo` varchar(50) NOT NULL,
  `precio` double(11,2) NOT NULL,
  `stock` int(50) NOT NULL,
  `fecha` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id_producto`, `nombre`, `codigo`, `precio`, `stock`, `fecha`) VALUES
(11, 'Powerade', '5', 5500.00, 10, '2025-06-06'),
(15, 'Agua', '7', 2500.00, 20, '2025-06-07'),
(17, 'Barra Proteica', '6', 6000.00, 120, '2025-06-07'),
(18, 'Gatorade', '2', 4500.00, 0, '2025-06-07'),
(19, 'Vaso Proteina', '4', 3400.00, 13, '2025-06-07'),
(21, 'Leche Proteica', '10', 3750.00, 15, '2025-06-12');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutina`
--

CREATE TABLE `rutina` (
  `id_rutina` int(11) NOT NULL,
  `codigo` varchar(50) NOT NULL,
  `ejercicio` varchar(50) NOT NULL,
  `series` varchar(50) NOT NULL,
  `veces_semana` int(50) NOT NULL,
  `entrenador` varchar(50) NOT NULL,
  `idObjetivo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `rutina`
--

INSERT INTO `rutina` (`id_rutina`, `codigo`, `ejercicio`, `series`, `veces_semana`, `entrenador`, `idObjetivo`) VALUES
(9, '3', 'Bíceps', '2x15', 3, 'Victor', 0),
(10, '4', 'Bíceps', '2x15', 3, 'Mariana', 0),
(12, '2', 'Gluteos', '3x15', 3, 'Florencia', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `pass` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre`, `email`, `pass`, `tipo`) VALUES
(1, 'Florencia', 'flor@gmail.com', 'abcd', 'Cliente'),
(2, 'Victor', 'montejo@gmail.com', '1234', 'Entrenador'),
(3, 'Mufasa', 'mufasa@gmail.com', '1234', 'Admin'),
(16, 'Naomi', 'nao@gmail.com', '1234', 'entrenador'),
(17, 'vic', 'migue@gmail.com', '1234', 'Entrenador'),
(18, 'nami', 'na@gmail.com', '1234', 'Admin'),
(19, 'victor', 'vi@gmail.com', '1234', 'Entrenador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `id_venta` int(11) NOT NULL,
  `cliente` varchar(50) DEFAULT NULL,
  `vendedor` varchar(50) DEFAULT NULL,
  `total` double(50,2) DEFAULT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`id_venta`, `cliente`, `vendedor`, `total`, `fecha`) VALUES
(1, 'Mariana', 'Admin', 13500.00, '2025-06-08 08:17:40'),
(2, 'Gladis', 'Admin', 13500.00, '2025-06-08 08:22:33'),
(3, 'Mariana', 'Admin', 13500.00, '2025-06-08 08:32:12'),
(4, 'Mariana', 'Admin', 16500.00, '2025-06-08 09:55:59'),
(5, 'Mariana', 'Admin', 45000.00, '2025-06-08 23:00:30'),
(6, 'Mariana', 'Admin', 9000.00, '2025-06-09 03:02:09'),
(7, 'Naomi F', 'Admin', 22500.00, '2025-06-09 03:08:01'),
(8, 'Mariana', 'Admin', 9000.00, '2025-06-09 03:11:08'),
(9, 'Naomi F', 'Admin', 9000.00, '2025-06-09 03:14:14'),
(10, 'Mariana', 'Admin', 4500.00, '2025-06-10 08:36:40'),
(11, 'Mariana', 'Admin', 25000.00, '2025-06-10 08:40:41'),
(12, 'Mariana', 'Admin', 13600.00, '2025-06-12 22:26:17');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vip`
--

CREATE TABLE `vip` (
  `id_vip` int(11) NOT NULL,
  `precio` int(11) NOT NULL,
  `idObjetivo` int(50) NOT NULL,
  `id_rutina` int(50) NOT NULL,
  `id_dieta` int(50) NOT NULL,
  `id_cliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `vip`
--

INSERT INTO `vip` (`id_vip`, `precio`, `idObjetivo`, `id_rutina`, `id_dieta`, `id_cliente`) VALUES
(14, 10000, 1, 0, 0, 61);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indices de la tabla `basico`
--
ALTER TABLE `basico`
  ADD PRIMARY KEY (`id_basico`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `config`
--
ALTER TABLE `config`
  ADD PRIMARY KEY (`id_config`);

--
-- Indices de la tabla `detalle_plan`
--
ALTER TABLE `detalle_plan`
  ADD PRIMARY KEY (`id_detalle`);

--
-- Indices de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD PRIMARY KEY (`id_detalle`);

--
-- Indices de la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD PRIMARY KEY (`id_dieta`);

--
-- Indices de la tabla `entrenador`
--
ALTER TABLE `entrenador`
  ADD PRIMARY KEY (`id_entrenador`);

--
-- Indices de la tabla `objetivo`
--
ALTER TABLE `objetivo`
  ADD PRIMARY KEY (`idObjetivo`);

--
-- Indices de la tabla `plan`
--
ALTER TABLE `plan`
  ADD PRIMARY KEY (`id_plan`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id_producto`);

--
-- Indices de la tabla `rutina`
--
ALTER TABLE `rutina`
  ADD PRIMARY KEY (`id_rutina`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id_venta`);

--
-- Indices de la tabla `vip`
--
ALTER TABLE `vip`
  ADD PRIMARY KEY (`id_vip`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `basico`
--
ALTER TABLE `basico`
  MODIFY `id_basico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;

--
-- AUTO_INCREMENT de la tabla `config`
--
ALTER TABLE `config`
  MODIFY `id_config` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalle_plan`
--
ALTER TABLE `detalle_plan`
  MODIFY `id_detalle` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  MODIFY `id_detalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `dieta`
--
ALTER TABLE `dieta`
  MODIFY `id_dieta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `entrenador`
--
ALTER TABLE `entrenador`
  MODIFY `id_entrenador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `objetivo`
--
ALTER TABLE `objetivo`
  MODIFY `idObjetivo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `plan`
--
ALTER TABLE `plan`
  MODIFY `id_plan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id_producto` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `rutina`
--
ALTER TABLE `rutina`
  MODIFY `id_rutina` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `vip`
--
ALTER TABLE `vip`
  MODIFY `id_vip` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
