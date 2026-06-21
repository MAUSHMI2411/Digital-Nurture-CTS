-- Scenario 1: Transfer funds between two accounts safely.
-- Rolls back and logs an error if anything goes wrong
-- (e.g., insufficient funds).

CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_from_account IN NUMBER,
    p_to_account   IN NUMBER,
    p_amount       IN NUMBER
) AS
    v_from_balance NUMBER;
    insufficient_funds EXCEPTION;
BEGIN
    SELECT Balance INTO v_from_balance
    FROM Accounts
    WHERE AccountID = p_from_account
    FOR UPDATE;

    IF v_from_balance < p_amount THEN
        RAISE insufficient_funds;
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_amount, LastModified = SYSDATE
    WHERE AccountID = p_from_account;

    UPDATE Accounts
    SET Balance = Balance + p_amount, LastModified = SYSDATE
    WHERE AccountID = p_to_account;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Transfer successful: ' || p_amount ||
                          ' moved from account ' || p_from_account ||
                          ' to account ' || p_to_account);

EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        INSERT INTO ErrorLog (ProcedureName, ErrorMessage)
        VALUES ('SafeTransferFunds', 'Insufficient funds in account ' || p_from_account);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: insufficient funds.');

    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        INSERT INTO ErrorLog (ProcedureName, ErrorMessage)
        VALUES ('SafeTransferFunds', 'Account not found: ' || p_from_account || ' or ' || p_to_account);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: account not found.');

    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO ErrorLog (ProcedureName, ErrorMessage)
        VALUES ('SafeTransferFunds', SQLERRM);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END;
/
