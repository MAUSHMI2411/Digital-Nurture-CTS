-- Scenario 1: Apply 1% monthly interest to all savings accounts.

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
    v_interest_rate CONSTANT NUMBER := 0.01; -- 1%
BEGIN
    FOR acc_rec IN (
        SELECT AccountID, Balance
        FROM Accounts
        WHERE AccountType = 'Savings'
    ) LOOP

        UPDATE Accounts
        SET Balance = Balance + (Balance * v_interest_rate),
            LastModified = SYSDATE
        WHERE AccountID = acc_rec.AccountID;

        DBMS_OUTPUT.PUT_LINE('Interest applied to AccountID: ' || acc_rec.AccountID);

    END LOOP;

    COMMIT;
END;
/
