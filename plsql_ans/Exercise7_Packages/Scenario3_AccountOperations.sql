-- Scenario 3: Package for account-related operations:
-- OpenAccount, CloseAccount, and a function to get the total
-- balance of a customer across all their accounts.

CREATE OR REPLACE PACKAGE AccountOperations AS

    PROCEDURE OpenAccount (
        p_account_id   IN NUMBER,
        p_customer_id  IN NUMBER,
        p_account_type IN VARCHAR2,
        p_balance      IN NUMBER
    );

    PROCEDURE CloseAccount (
        p_account_id IN NUMBER
    );

    FUNCTION GetTotalBalance (
        p_customer_id IN NUMBER
    ) RETURN NUMBER;

END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount (
        p_account_id   IN NUMBER,
        p_customer_id  IN NUMBER,
        p_account_type IN VARCHAR2,
        p_balance      IN NUMBER
    ) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_account_id, p_customer_id, p_account_type, p_balance, SYSDATE);

        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Account opened: ' || p_account_id);

    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Error: AccountID ' || p_account_id || ' already exists.');
    END OpenAccount;


    PROCEDURE CloseAccount (
        p_account_id IN NUMBER
    ) IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance
        FROM Accounts
        WHERE AccountID = p_account_id;

        IF v_balance != 0 THEN
            DBMS_OUTPUT.PUT_LINE('Cannot close account ' || p_account_id ||
                                  ': balance must be zero before closing.');
            RETURN;
        END IF;

        DELETE FROM Accounts WHERE AccountID = p_account_id;
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Account closed: ' || p_account_id);

    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Error: AccountID ' || p_account_id || ' not found.');
    END CloseAccount;


    FUNCTION GetTotalBalance (
        p_customer_id IN NUMBER
    ) RETURN NUMBER IS
        v_total NUMBER;
    BEGIN
        SELECT NVL(SUM(Balance), 0) INTO v_total
        FROM Accounts
        WHERE CustomerID = p_customer_id;

        RETURN v_total;
    END GetTotalBalance;

END AccountOperations;
/

-- Example usage:
-- BEGIN
--     AccountOperations.OpenAccount(10, 1, 'Savings', 500);
--     AccountOperations.CloseAccount(10);
-- END;
-- /
-- SELECT AccountOperations.GetTotalBalance(1) FROM dual;
