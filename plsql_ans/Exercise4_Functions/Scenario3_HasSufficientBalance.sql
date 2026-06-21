-- Scenario 3: Return TRUE if an account has at least the
-- specified amount available, FALSE otherwise.
-- (PL/SQL BOOLEAN cannot be selected directly from SQL,
--  so this function is intended for use inside PL/SQL blocks.)

CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_account_id IN NUMBER,
    p_amount     IN NUMBER
) RETURN BOOLEAN
AS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_account_id;

    IF v_balance >= p_amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END;
/

-- Example usage inside a PL/SQL block:
-- BEGIN
--     IF HasSufficientBalance(1, 500) THEN
--         DBMS_OUTPUT.PUT_LINE('Sufficient balance.');
--     ELSE
--         DBMS_OUTPUT.PUT_LINE('Insufficient balance.');
--     END IF;
-- END;
-- /
