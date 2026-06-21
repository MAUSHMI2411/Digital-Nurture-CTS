-- Scenario 2: Increase an employee's salary by a given percentage.
-- Logs an error if the employee ID does not exist.

CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_employee_id IN NUMBER,
    p_percentage  IN NUMBER
) AS
    v_current_salary NUMBER;
BEGIN
    SELECT Salary INTO v_current_salary
    FROM Employees
    WHERE EmployeeID = p_employee_id;

    UPDATE Employees
    SET Salary = Salary + (Salary * p_percentage / 100)
    WHERE EmployeeID = p_employee_id;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Salary updated for EmployeeID: ' || p_employee_id);

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        INSERT INTO ErrorLog (ProcedureName, ErrorMessage)
        VALUES ('UpdateSalary', 'EmployeeID ' || p_employee_id || ' does not exist.');
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Error: EmployeeID ' || p_employee_id || ' not found.');

    WHEN OTHERS THEN
        INSERT INTO ErrorLog (ProcedureName, ErrorMessage)
        VALUES ('UpdateSalary', SQLERRM);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
