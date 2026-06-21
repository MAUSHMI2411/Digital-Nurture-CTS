-- Scenario 2: Use an explicit cursor to deduct an annual
-- maintenance fee from the balance of every account.

DECLARE
    CURSOR ApplyAnnualFee IS
        SELECT AccountID, Balance FROM Accounts FOR UPDATE OF Balance;

    v_fee CONSTANT NUMBER := 25; -- flat annual maintenance fee
BEGIN
    FOR acc_rec IN ApplyAnnualFee LOOP

        UPDATE Accounts
        SET Balance = Balance - v_fee,
            LastModified = SYSDATE
        WHERE CURRENT OF ApplyAnnualFee;

        DBMS_OUTPUT.PUT_LINE('Annual fee of ' || v_fee ||
                              ' deducted from AccountID: ' || acc_rec.AccountID);

    END LOOP;

    COMMIT;
END;
/
