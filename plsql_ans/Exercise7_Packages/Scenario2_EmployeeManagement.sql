-- Scenario 2: Package to manage employee data: HireEmployee,
-- UpdateEmployeeDetails, and a function to calculate annual salary.

CREATE OR REPLACE PACKAGE EmployeeManagement AS

    PROCEDURE HireEmployee (
        p_employee_id IN NUMBER,
        p_name        IN VARCHAR2,
        p_position    IN VARCHAR2,
        p_salary      IN NUMBER,
        p_department  IN VARCHAR2
    );

    PROCEDURE UpdateEmployeeDetails (
        p_employee_id IN NUMBER,
        p_position    IN VARCHAR2,
        p_salary      IN NUMBER,
        p_department  IN VARCHAR2
    );

    FUNCTION CalculateAnnualSalary (
        p_employee_id IN NUMBER
    ) RETURN NUMBER;

END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee (
        p_employee_id IN NUMBER,
        p_name        IN VARCHAR2,
        p_position    IN VARCHAR2,
        p_salary      IN NUMBER,
        p_department  IN VARCHAR2
    ) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_employee_id, p_name, p_position, p_salary, p_department, SYSDATE);

        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Employee hired: ' || p_name);

    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Error: EmployeeID ' || p_employee_id || ' already exists.');
    END HireEmployee;


    PROCEDURE UpdateEmployeeDetails (
        p_employee_id IN NUMBER,
        p_position    IN VARCHAR2,
        p_salary      IN NUMBER,
        p_department  IN VARCHAR2
    ) IS
    BEGIN
        UPDATE Employees
        SET Position = p_position,
            Salary = p_salary,
            Department = p_department
        WHERE EmployeeID = p_employee_id;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Error: EmployeeID ' || p_employee_id || ' not found.');
        ELSE
            COMMIT;
            DBMS_OUTPUT.PUT_LINE('Employee updated: ' || p_employee_id);
        END IF;
    END UpdateEmployeeDetails;


    FUNCTION CalculateAnnualSalary (
        p_employee_id IN NUMBER
    ) RETURN NUMBER IS
        v_monthly_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_monthly_salary
        FROM Employees
        WHERE EmployeeID = p_employee_id;

        RETURN v_monthly_salary * 12;

    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
    END CalculateAnnualSalary;

END EmployeeManagement;
/

-- Example usage:
-- BEGIN
--     EmployeeManagement.HireEmployee(3, 'Sara Lee', 'Analyst', 55000, 'Finance');
--     EmployeeManagement.UpdateEmployeeDetails(3, 'Senior Analyst', 60000, 'Finance');
-- END;
-- /
-- SELECT EmployeeManagement.CalculateAnnualSalary(3) FROM dual;
