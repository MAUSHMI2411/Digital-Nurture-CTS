-- Scenario 2: Set IsVIP to TRUE for customers with balance over $10,000.

BEGIN
    FOR cust_rec IN (SELECT CustomerID, Balance FROM Customers) LOOP

        IF cust_rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'Y'
            WHERE CustomerID = cust_rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE('CustomerID ' || cust_rec.CustomerID || ' promoted to VIP');
        ELSE
            UPDATE Customers
            SET IsVIP = 'N'
            WHERE CustomerID = cust_rec.CustomerID;
        END IF;

    END LOOP;

    COMMIT;
END;
/
