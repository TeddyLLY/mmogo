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
    action VARCHAR(10) NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- select
SELECT * FROM main.employee;
SELECT * FROM main.employee_log;


--create test trigger
DELIMITER $$
    CREATE TRIGGER employee_audit
    AFTER INSERT ON employee
        FOR EACH ROW
    BEGIN
        DECLARE action VARCHAR(10);

        IF INSERTING THEN
            SET action = 'INSERT';
        ELSEIF UPDATING THEN
            SET action = 'UPDATE';
        ELSE
            SET action = 'DELETE';
        END IF;

        INSERT INTO employee_log (employee_id, action, timestamp)
        VALUES (NEW.id, action, NOW());
    END;
$$
DELIMITER ;

SHOW TRIGGERS LIKE 'employee_audit';


--insert sample data
insert into main.employee (first_name , last_name ) values ("teddy",'lai') ;
commit ;

--test delete
delete from main.employee where 1=1 ;




