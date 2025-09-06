-- Seleccionar la BD
USE empleados;

-- Insertar cargos
INSERT INTO Cargos (Cargo) VALUES
('Administrador'),
('Vendedor'),
('Contador'),
('RRHH'),
('Soporte Técnico');

-- Insertar empleados
INSERT INTO Empleados (Nombre, Apellidos, Telefono, Rut, Direccion) VALUES
('Juan', 'Pérez Soto', '987654321', '12345678-9', 'Av. Siempre Viva 123'),
('María', 'Gómez Díaz', '912345678', '87654321-0', 'Calle Falsa 456'),
('Carlos', 'López Muñoz', '956789012', '11222333-4', 'Pasaje 789'),
('Ana', 'Torres Silva', '934567890', '22334455-6', 'Villa Central 12'),
('Pedro', 'Ramírez Rojas', '976543210', '33445566-7', 'Los Robles 89');

-- Insertar logins (cada uno ligado a un empleado)
INSERT INTO Login (ID_Empleado, CorreoUsuario, Contraseña) VALUES
(1, 'juan.perez@empresa.com', 'passJuan123'),
(2, 'maria.gomez@empresa.com', 'passMaria456'),
(3, 'carlos.lopez@empresa.com', 'passCarlos789'),
(4, 'ana.torres@empresa.com', 'passAna321'),
(5, 'pedro.ramirez@empresa.com', 'passPedro654');

-- Relacionar empleados con cargos
INSERT INTO Empleado_Cargos (ID_Empleado, ID_Cargo) VALUES
(1, 1), -- Juan -> Administrador
(2, 2), -- María -> Vendedor
(3, 3), -- Carlos -> Contador
(4, 4), -- Ana -> RRHH
(5, 5); -- Pedro -> Soporte Técnico

-- Insertar asistencias (1 registro por día por empleado)
INSERT INTO Asistencia (ID_Empleado, Fecha, Hora_Entrada, Hora_Salida) VALUES
(1, '2025-09-01', '08:30:00', '17:00:00'),
(2, '2025-09-01', '09:00:00', '17:30:00'),
(3, '2025-09-01', '08:45:00', '17:15:00'),
(4, '2025-09-01', '08:00:00', '16:30:00'),
(5, '2025-09-01', '09:15:00', '18:00:00');


DELIMITER $$

CREATE PROCEDURE EmpleadosTarde (
    IN fechaX DATE,
    IN horaLimite TIME
)
BEGIN
    SELECT e.Nombre, e.Apellidos, a.Fecha, a.Hora_Entrada
    FROM Empleados e
    JOIN Asistencia a ON e.ID = a.ID_Empleado
    WHERE a.Fecha = fechaX
      AND a.Hora_Entrada > horaLimite;
END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE EmpleadosSalidaAntes (
    IN fechaX DATE,
    IN horaLimite TIME
)
BEGIN
    SELECT e.Nombre, e.Apellidos, a.Fecha, a.Hora_Salida
    FROM Empleados e
    JOIN Asistencia a ON e.ID = a.ID_Empleado
    WHERE a.Fecha = fechaX
      AND a.Hora_Entrada > horaLimite;
END$$

DELIMITER ;
