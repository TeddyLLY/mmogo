--create test table
CREATE TABLE employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100),
    hire_date DATE,
    salary DECIMAL(10, 2),
    department VARCHAR(50)
);

CREATE TABLE employee_log (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    action VARCHAR(10) NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- select
SELECT * FROM test.employee;
SELECT * FROM employee_log;



--create test trigger
DELIMITER $$
    CREATE TRIGGER employee_audit
    AFTER INSERT ON employee
        FOR EACH ROW
    BEGIN
        DECLARE action VARCHAR(10);
            SET action = 'INSERT';

    INSERT INTO employee_log (employee_id, first_name ,action, timestamp)
    VALUES (NEW.id, New.first_name ,action, NOW());
    END;
$$
DELIMITER ;


SHOW TRIGGERS LIKE '%employee%';

DROP TRIGGER IF EXISTS employee_audit;



--test
INSERT INTO employee (first_name, last_name, email, hire_date, salary, department)
VALUES ('Teddy', 'Lai', 'teddy@example.com', '2023-10-04', 50000.00, 'HR');


delete from employee where first_name like '%Teddy%' ;







