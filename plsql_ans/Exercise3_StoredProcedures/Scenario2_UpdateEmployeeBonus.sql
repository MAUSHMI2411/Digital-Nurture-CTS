-- Scenario 2: Add a bonus percentage to the salary of all
-- employees in a given department.

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department      IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) AS
    v_count NUMBER;
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_percentage / 100)
    WHERE Department = p_department;

    v_count := SQL%ROWCOUNT;

    IF v_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No employees found in department: ' || p_department);
    ELSE
        DBMS_OUTPUT.PUT_LINE(v_count || ' employee(s) updated in department: ' || p_department);
    END IF;

    COMMIT;

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO ErrorLog (ProcedureName, ErrorMessage)
        VALUES ('UpdateEmployeeBonus', SQLERRM);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
