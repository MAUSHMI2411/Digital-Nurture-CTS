-- Scenario 3: Insert a new customer. If the CustomerID already
-- exists, handle the exception and log an error instead of failing.

CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_customer_id IN NUMBER,
    p_name        IN VARCHAR2,
    p_dob         IN DATE,
    p_balance     IN NUMBER
) AS
    v_dummy NUMBER;
    duplicate_customer EXCEPTION;
BEGIN
    SELECT COUNT(*) INTO v_dummy
    FROM Customers
    WHERE CustomerID = p_customer_id;

    IF v_dummy > 0 THEN
        RAISE duplicate_customer;
    END IF;

    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Customer added: ' || p_name);

EXCEPTION
    WHEN duplicate_customer THEN
        INSERT INTO ErrorLog (ProcedureName, ErrorMessage)
        VALUES ('AddNewCustomer', 'Duplicate CustomerID: ' || p_customer_id);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Error: CustomerID ' || p_customer_id || ' already exists.');

    WHEN DUP_VAL_ON_INDEX THEN
        INSERT INTO ErrorLog (ProcedureName, ErrorMessage)
        VALUES ('AddNewCustomer', 'Duplicate key on CustomerID: ' || p_customer_id);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Error: CustomerID ' || p_customer_id || ' violates primary key.');

    WHEN OTHERS THEN
        INSERT INTO ErrorLog (ProcedureName, ErrorMessage)
        VALUES ('AddNewCustomer', SQLERRM);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
