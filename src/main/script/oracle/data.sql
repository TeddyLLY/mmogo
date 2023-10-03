-- 创建 employee 表
CREATE TABLE employee (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    first_name VARCHAR2(50) NOT NULL,
    last_name VARCHAR2(50) NOT NULL,
    email VARCHAR2(100),
    hire_date DATE,
    salary NUMBER(10, 2),
    department VARCHAR2(50)
);

-- 创建 employee_log 表
CREATE TABLE employee_log (
    log_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    employee_id NUMBER NOT NULL,
    action VARCHAR2(10) NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
