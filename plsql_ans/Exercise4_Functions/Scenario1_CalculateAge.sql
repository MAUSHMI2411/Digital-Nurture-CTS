-- Scenario 1: Return a customer's age in years given their date of birth.

CREATE OR REPLACE FUNCTION CalculateAge (
    p_dob IN DATE
) RETURN NUMBER
AS
    v_age NUMBER;
BEGIN
    v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN v_age;
END;
/

-- Example usage:
-- SELECT Name, CalculateAge(DOB) AS Age FROM Customers;
