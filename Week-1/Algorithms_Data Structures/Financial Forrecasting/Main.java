class Main {

    // T.C. -> O(n) && S.C. -> O(n)
    // public static double futureValue(double presentVal, double rate, int years) {
    //     if (years == 0)
    //         return presentVal;
    //     return futureValue(presentVal, rate, years - 1) * (1 + rate);
    // }

    // Optimization using tabulation or iteration
    // T.C. -> O(n) && S.C. -> O(1)
    public static double futureValueItr(double pv, double rate, int years) {
        double result = pv;
        for (int i = 0; i < years; i++) {
            result *= (1 + rate);
        }
        return result;
    }


    public static void main(String[] args) {
        double presentValue = 10000;
        double growthRate = 0.05; // 5%
        int years = 5;

        double futureVal = futureValueItr(presentValue, growthRate, years);
        System.out.println("Future Value after " + years + " years: " + futureVal);
    }
}
