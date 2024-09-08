INSERT INTO Clientes (Nombre, Apellido, Telefono, Correo) VALUES
('Juan', 'Pérez', '123456789', 'juan.perez@example.com'),
('Ana', 'Gómez', '987654321', 'ana.gomez@example.com'),
('Carlos', 'Rodríguez', '456789123', 'carlos.rodriguez@example.com'),
('Laura', 'Martínez', '321654987', 'laura.martinez@example.com'),
('Pedro', 'Sánchez', '654321987', 'pedro.sanchez@example.com'),
('María', 'Fernández', '789456123', 'maria.fernandez@example.com'),
('José', 'Hernández', '987321456', 'jose.hernandez@example.com'),
('Sofía', 'García', '741852963', 'sofia.garcia@example.com'),
('Luis', 'Mora', '852963741', 'luis.mora@example.com'),
('Carmen', 'Salazar', '963852741', 'carmen.salazar@example.com');

INSERT INTO Empleados (Nombre, Apellido, Cargo, Telefono) VALUES
('María', 'López', 'Camarera', '321654987'),
('Pedro', 'Martínez', 'Chef', '654321987'),
('Laura', 'Fernández', 'Recepcionista', '789456123'),
('Andrés', 'Castro', 'Cocinero', '456123789'),
('Elena', 'Paredes', 'Camarera', '321987654'),
('Roberto', 'Gómez', 'Ayudante de Cocina', '987654321'),
('Claudia', 'Vásquez', 'Cajera', '741963852'),
('David', 'Hidalgo', 'Jefe de Sala', '852741963'),
('Paola', 'Rodríguez', 'Cocinero', '963741852'),
('Ricardo', 'Pérez', 'Camarero', '159753468');

INSERT INTO Menus (Nombre, Descripcion, Precio) VALUES
('Hamburguesa', 'Hamburguesa con queso y bacon', 12.50),
('Ensalada', 'Ensalada mixta con aderezo', 8.75),
('Pasta', 'Pasta con salsa de tomate', 14.00),
('Pizza Margherita', 'Pizza con mozzarella y albahaca', 11.00),
('Sopa del Día', 'Sopa casera del día', 6.50),
('Tacos', 'Tacos de carne con salsa picante', 9.00),
('Paella', 'Paella mixta con mariscos y pollo', 18.00),
('Sushi', 'Sushi variado', 15.00),
('Café', 'Café expreso', 3.00),
('Tarta de Chocolate', 'Tarta de chocolate con crema', 5.50);

INSERT INTO Pedidos (Clientes_id, Empleados_id, FechaPedido, precio) VALUES
(1, 1, '2024-09-07 19:30:00', 25.00),
(2, 3, '2024-09-07 20:00:00', 22.75),
(3, 2, '2024-09-07 21:00:00', 30.00),
(4, 1, '2024-09-08 12:30:00', 18.00),
(5, 2, '2024-09-08 13:00:00', 14.50),
(6, 3, '2024-09-08 14:00:00', 26.00),
(7, 1, '2024-09-08 19:00:00', 21.75),
(8, 2, '2024-09-08 19:30:00', 23.00),
(9, 3, '2024-09-08 20:00:00', 29.50);

INSERT INTO Detalles_Pedidos (Pedidos_id, Menus_id, Cantidad, PrecioUnitario) VALUES
(1, 1, 1, 12.50),
(1, 2, 1, 8.75),
(2, 3, 1, 14.00),
(2, 6, 1, 9.00),
(3, 4, 1, 11.00),
(3, 7, 1, 18.00),
(4, 5, 2, 6.50),
(4, 8, 1, 15.00),
(5, 9, 2, 3.00),
(5, 10, 1, 5.50),
(6, 2, 1, 8.75),
(6, 3, 1, 14.00),
(7, 1, 2, 12.50),
(7, 5, 1, 6.50),
(8, 4, 1, 11.00),
(8, 6, 2, 9.00),
(9, 7, 1, 18.00),
(9, 10, 1, 5.50);

