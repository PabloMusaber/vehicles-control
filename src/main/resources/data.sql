INSERT INTO vehicles (brand, engine_displacement, license_plate, mileage, model, year_) VALUES
    ('Renault', 1.2, 'AAA 111', 230000, 'Clio', 2006),
    ('Volkswagen', 2.0, 'BBB 222', 75000, 'Golf', 2018),
    ('Toyota', 1.8, 'CCC 333', 45000, 'Corolla', 2020),
    ('Ford', 5.0, 'DDD 444', 60000, 'Mustang', 2019),
    ('Honda', 1.5, 'EEE 555', 95000, 'Civic', 2017),
    ('BMW', 2.0, 'FFF 666', 30000, '3 Series', 2021),
    ('Mazda', 2.0, 'GGG 777', 15000, 'MX-5', 2022),
    ('Scania', 13.0, 'YZR 124', 560000, 'R Series', 2015),
    ('Mercedes-Benz', 12.8, 'XYZ 456', 320000, 'Actros', 2018),
    ('Volvo', 13.5, 'PQR 789', 180000, 'FH', 2020);

INSERT INTO maintenances (cost, date, description, mileage, vehicle_id) VALUES
    (70000.0, '2025-03-01', 'Cambio de aceite', 10000, 1),
    (50000.0, '2024-12-15', 'Cambio de filtros', 9570, 1),
    (15000.0, '2023-01-24', 'Revisión de frenos', 2500, 1),
    (12500.0, '2022-06-15', 'Cambio de aceite y filtros', 180000, 2),
    (22000.0, '2023-01-24', 'Revisión de frenos y pastillas', 205000, 2),
    (45000.0, '2022-03-10', 'Cambio de neumáticos', 420000, 8),
    (35000.0, '2022-07-22', 'Revisión de sistema de frenos', 480000, 8),
    (65000.0, '2022-11-05', 'Mantenimiento del motor', 520000, 8),
    (28000.0, '2023-02-14', 'Cambio de aceite y filtros', 550000, 8),
    (55000.0, '2023-01-15', 'Revisión general', 300000, 3);

INSERT INTO trucks (axes, load_capacity, type, vehicle_id) VALUES
    (4, 25000, 1, 8),
    (6, 32000, 0, 9),
    (5, 40000, 1, 10);

INSERT INTO cars (doors, passangers, trunk_capacity, type, vehicle_id) VALUES
    (3, 5, 50, 1, 1),
    (5, 5, 380, 1, 2),
    (4, 5, 470, 1, 3),
    (2, 4, 130, 1, 4),
    (4, 5, 420, 1, 5),
    (4, 5, 480, 1, 6),
    (2, 2, 130, 1, 7);
