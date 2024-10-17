public class GDPPredictionDP {

    public static double yearsToDoubleGDP(double growthRate, double currentGDP, double targetGDP) {
        if (currentGDP >= targetGDP) {
            return 0;
        }
        return 1 + yearsToDoubleGDP(growthRate, currentGDP * (1 + growthRate), targetGDP);
    }

    public static double gdpAfterYearsDP(double initialGDP, double growthRate, int years) {
        double[] gdpResults = new double[years + 1];
        gdpResults[0] = initialGDP;

        for (int i = 1; i <= years; i++) {
            gdpResults[i] = gdpResults[i - 1] * (1 + growthRate);
        }

        return gdpResults[years];
    }

    public static void main(String[] args) {
        double initialGDPPoland = 6000;
        double initialGDPGermany = 12000;
        double growthRatePoland = 0.06;
        double growthRateGermany = 0.012;

        double targetGDPPoland = initialGDPPoland * 2;
        double yearsToDouble = yearsToDoubleGDP(growthRatePoland, initialGDPPoland, targetGDPPoland);
        System.out.printf("Poland's GDP will double in %.2f years.\n", yearsToDouble);

        int years = 20;
        double gdpPolandAfter20Years = gdpAfterYearsDP(initialGDPPoland, growthRatePoland, years);
        double gdpGermanyAfter20Years = gdpAfterYearsDP(initialGDPGermany, growthRateGermany, years);

        System.out.printf("Poland's GDP after 20 years: %.2f dollars.\n", gdpPolandAfter20Years);
        System.out.printf("Germany's GDP after 20 years: %.2f dollars.\n", gdpGermanyAfter20Years);

        if (gdpPolandAfter20Years >= gdpGermanyAfter20Years) {
            System.out.println("Poland's GDP will match or exceed Germany's GDP in 20 years.");
        } else {
            System.out.println("Poland's GDP will not match Germany's GDP in 20 years.");
        }
    }
}
