-- Scenario 1: Apply a 1% discount to loan interest rates
-- for customers above 60 years old.

DECLARE
    v_age NUMBER;
BEGIN
    FOR cust_rec IN (SELECT CustomerID, DOB FROM Customers) LOOP

        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, cust_rec.DOB) / 12);

        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - (InterestRate * 0.01)
            WHERE CustomerID = cust_rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE('Discount applied for CustomerID: ' || cust_rec.CustomerID);
        END IF;

    END LOOP;

    COMMIT;
END;
/
