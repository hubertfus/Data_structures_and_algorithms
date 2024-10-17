public class GDPPredictionDAC {

    public static double yearsToDoubleGDP(double growthRate) {
        return yearsToDoubleGDPHelper(1, growthRate, 0);
    }

    private static double yearsToDoubleGDPHelper(double currentGDP, double growthRate, double years) {
        if (currentGDP >= 2) {
            return years;
        }
        return yearsToDoubleGDPHelper(currentGDP * (1 + growthRate), growthRate, years + 1);
    }

    public static double gdpAfterYearsRecursive(double initialGDP, double growthRate, int years) {
        if (years == 0) {
            return initialGDP;
        }
        return gdpAfterYearsRecursive(initialGDP, growthRate, years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        double initialGDPPoland = 6000;
        double initialGDPGermany = 12000;
        double growthRatePoland = 0.06;
        double growthRateGermany = 0.012;

        double yearsToDouble = yearsToDoubleGDP(growthRatePoland);
        System.out.printf("Poland's GDP will double in %.0f years.\n", yearsToDouble);

        int years = 20;
        double gdpPolandAfter20Years = gdpAfterYearsRecursive(initialGDPPoland, growthRatePoland, years);
        double gdpGermanyAfter20Years = gdpAfterYearsRecursive(initialGDPGermany, growthRateGermany, years);

        System.out.printf("Poland's GDP after 20 years: %.2f dollars.\n", gdpPolandAfter20Years);
        System.out.printf("Germany's GDP after 20 years: %.2f dollars.\n", gdpGermanyAfter20Years);

        if (gdpPolandAfter20Years >= gdpGermanyAfter20Years) {
            System.out.println("Poland's GDP will match or exceed Germany's GDP in 20 years.");
        } else {
            System.out.println("Poland's GDP will not match Germany's GDP in 20 years.");
        }
    }
}
