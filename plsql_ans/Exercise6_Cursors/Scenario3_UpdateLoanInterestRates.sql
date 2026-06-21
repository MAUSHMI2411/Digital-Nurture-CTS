-- Scenario 3: Use an explicit cursor to fetch all loans and
-- update their interest rates based on a new policy.
-- New policy: loans under $7,000 get a rate of 5%,
--             loans $7,000 and above get a rate of 6.5%.

DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID, LoanAmount, InterestRate FROM Loans FOR UPDATE OF InterestRate;

    v_new_rate NUMBER;
BEGIN
    FOR loan_rec IN UpdateLoanInterestRates LOOP

        IF loan_rec.LoanAmount < 7000 THEN
            v_new_rate := 5;
        ELSE
            v_new_rate := 6.5;
        END IF;

        UPDATE Loans
        SET InterestRate = v_new_rate
        WHERE CURRENT OF UpdateLoanInterestRates;

        DBMS_OUTPUT.PUT_LINE('LoanID ' || loan_rec.LoanID ||
                              ' updated to interest rate ' || v_new_rate || '%');

    END LOOP;

    COMMIT;
END;
/
