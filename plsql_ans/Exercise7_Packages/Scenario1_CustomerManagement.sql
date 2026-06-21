-- Scenario 1: Package grouping customer-related procedures
-- and functions: AddCustomer, UpdateCustomerDetails, GetCustomerBalance.

CREATE OR REPLACE PACKAGE CustomerManagement AS

    PROCEDURE AddCustomer (
        p_customer_id IN NUMBER,
        p_name        IN VARCHAR2,
        p_dob         IN DATE,
        p_balance     IN NUMBER
    );

    PROCEDURE UpdateCustomerDetails (
        p_customer_id IN NUMBER,
        p_name        IN VARCHAR2,
        p_balance     IN NUMBER
    );

    FUNCTION GetCustomerBalance (
        p_customer_id IN NUMBER
    ) RETURN NUMBER;

END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer (
        p_customer_id IN NUMBER,
        p_name        IN VARCHAR2,
        p_dob         IN DATE,
        p_balance     IN NUMBER
    ) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);

        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Customer added: ' || p_name);

    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Error: CustomerID ' || p_customer_id || ' already exists.');
    END AddCustomer;


    PROCEDURE UpdateCustomerDetails (
        p_customer_id IN NUMBER,
        p_name        IN VARCHAR2,
        p_balance     IN NUMBER
    ) IS
    BEGIN
        UPDATE Customers
        SET Name = p_name,
            Balance = p_balance,
            LastModified = SYSDATE
        WHERE CustomerID = p_customer_id;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Error: CustomerID ' || p_customer_id || ' not found.');
        ELSE
            COMMIT;
            DBMS_OUTPUT.PUT_LINE('Customer updated: ' || p_customer_id);
        END IF;
    END UpdateCustomerDetails;


    FUNCTION GetCustomerBalance (
        p_customer_id IN NUMBER
    ) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance
        FROM Customers
        WHERE CustomerID = p_customer_id;

        RETURN v_balance;

    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
    END GetCustomerBalance;

END CustomerManagement;
/

-- Example usage:
-- BEGIN
--     CustomerManagement.AddCustomer(10, 'Mary Jones', DATE '1992-04-01', 2000);
--     CustomerManagement.UpdateCustomerDetails(10, 'Mary Jones-Smith', 2500);
-- END;
-- /
-- SELECT CustomerManagement.GetCustomerBalance(10) FROM dual;
