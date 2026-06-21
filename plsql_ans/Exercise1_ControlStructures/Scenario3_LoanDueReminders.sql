-- Scenario 3: Print a reminder for each customer whose loan
-- is due within the next 30 days.

BEGIN
    FOR loan_rec IN (
        SELECT l.LoanID, l.CustomerID, l.EndDate, c.Name
        FROM Loans l
        JOIN Customers c ON c.CustomerID = l.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP

        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan ' || loan_rec.LoanID ||
            ' for customer ' || loan_rec.Name ||
            ' is due on ' || TO_CHAR(loan_rec.EndDate, 'DD-MON-YYYY')
        );

    END LOOP;
END;
/
