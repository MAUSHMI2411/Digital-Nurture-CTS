-- Scenario 1: Automatically set LastModified to SYSDATE whenever
-- a customer's record is updated.

CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/
