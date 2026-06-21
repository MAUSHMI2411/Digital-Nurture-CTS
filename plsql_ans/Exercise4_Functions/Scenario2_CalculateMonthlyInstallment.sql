-- Scenario 2: Compute the monthly installment for a loan given
-- the loan amount, annual interest rate (%), and duration in years.
-- Uses the standard amortization formula:
--   M = P * r * (1+r)^n / ((1+r)^n - 1)
-- where r is the monthly interest rate and n is the number of months.

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loan_amount    IN NUMBER,
    p_interest_rate  IN NUMBER,  -- annual percentage, e.g. 5 for 5%
    p_duration_years IN NUMBER
) RETURN NUMBER
AS
    v_monthly_rate NUMBER;
    v_num_payments NUMBER;
    v_installment  NUMBER;
BEGIN
    v_monthly_rate := (p_interest_rate / 100) / 12;
    v_num_payments := p_duration_years * 12;

    IF v_monthly_rate = 0 THEN
        -- Zero-interest loan: simple division
        v_installment := p_loan_amount / v_num_payments;
    ELSE
        v_installment := p_loan_amount * v_monthly_rate * POWER(1 + v_monthly_rate, v_num_payments)
                          / (POWER(1 + v_monthly_rate, v_num_payments) - 1);
    END IF;

    RETURN ROUND(v_installment, 2);
END;
/

-- Example usage:
-- SELECT CalculateMonthlyInstallment(5000, 5, 5) AS MonthlyInstallment FROM dual;
