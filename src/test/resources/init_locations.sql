IF OBJECT_ID('location_cases', 'U') IS NOT NULL
DROP TABLE location_cases;

CREATE TABLE location_cases
(
    id                   INT PRIMARY KEY,
    area                 VARCHAR(100),
    expected_min_results INT
);

INSERT INTO location_cases
VALUES (1, 'Chavchavadze Ave', 1),
       (2, 'Nutsubidze', 2),
       (3, 'Vaja-Pshavela', 1);
