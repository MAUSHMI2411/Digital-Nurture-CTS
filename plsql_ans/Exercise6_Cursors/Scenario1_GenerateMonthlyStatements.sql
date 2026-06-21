-- Scenario 1: Use an explicit cursor to retrieve all transactions
-- for the current month and print a statement for each customer.

DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT c.Name, a.AccountID, t.TransactionDate, t.Amount, t.TransactionType
        FROM Transactions t
        JOIN Accounts a   ON a.AccountID = t.AccountID
        JOIN Customers c  ON c.CustomerID = a.CustomerID
        WHERE TRUNC(t.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM')
        ORDER BY c.Name, t.TransactionDate;

    v_customer Customers.Name%TYPE;
BEGIN
    FOR stmt_rec IN GenerateMonthlyStatements LOOP

        DBMS_OUTPUT.PUT_LINE(
            'Statement - Customer: ' || stmt_rec.Name ||
            ' | Account: ' || stmt_rec.AccountID ||
            ' | Date: ' || TO_CHAR(stmt_rec.TransactionDate, 'DD-MON-YYYY') ||
            ' | Type: ' || stmt_rec.TransactionType ||
            ' | Amount: ' || stmt_rec.Amount
        );

    END LOOP;
END;
/
