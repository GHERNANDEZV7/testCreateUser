--
-- Estructura de tabla para la tabla `phones`
--

CREATE TABLE `phones` (
  `id_phones` varchar(100) NOT NULL,
  `id_usuario` varchar(100) NOT NULL,
  `number` varchar(50) ,
  `city_code` int(11) ,
  `country_code` int(11) 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `is_usuario` varchar(50) NOT NULL,
  `nombre` varchar(100) ,
  `email` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `date_created` date NOT NULL,
  `date_modified` date NOT NULL,
  `last_login` date NOT NULL,
  `is_active` BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `phones`
--
ALTER TABLE `phones`
  ADD PRIMARY KEY (`id_phones`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`is_usuario`),
  ADD UNIQUE KEY `Unique_Email` (`email`);
COMMIT;
