package lib;

public class TaxFunction {

    private static final int BASIC_NONTAXABLE_INCOME = 54000000;
    private static final int MARRIED_ALLOWANCE = 4500000;
    private static final int CHILD_ALLOWANCE = 1500000;
    private static final int MAX_CHILDREN = 3;

    public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
        if (numberOfMonthWorking > 12) {
            System.err.println("More than 12 months working per year");
        }

        numberOfChildren = Math.min(numberOfChildren, MAX_CHILDREN);

        int annualIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;
        int nonTaxableIncome = BASIC_NONTAXABLE_INCOME;

        if (isMarried) {
            nonTaxableIncome += MARRIED_ALLOWANCE + (CHILD_ALLOWANCE * numberOfChildren);
        }

        int taxableIncome = annualIncome - deductible - nonTaxableIncome;
        int tax = (int) Math.round(0.05 * taxableIncome);

        return Math.max(tax, 0);
    }
}
