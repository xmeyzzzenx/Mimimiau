-- Eliminar la base de datos si existe para evitar conflictos
DROP DATABASE IF EXISTS mimimiau;

-- Crear la base de datos
CREATE DATABASE mimimiau;

-- Seleccionar la base de datos
USE mimimiau;

-- Eliminar la tabla 'partidas' si existe
DROP TABLE IF EXISTS partidas;

-- Crear la tabla 'partidas'
CREATE TABLE IF NOT EXISTS partidas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_jugador VARCHAR(50) NOT NULL,
    fecha_partida DATE NOT NULL,
    hora_inicio TIME NOT NULL,
    hora_fin TIME NOT NULL,
    duracion VARCHAR(8) NOT NULL,
    puntos INT NOT NULL,
    monedas INT NOT NULL
);
