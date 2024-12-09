public class SavingsAccount extends Account {
    private static final double MIN_BALANCE = 500.0;

    public SavingsAccount(int accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public void deposit(double amount) {
        if (isBlocked) {
            System.out.println("❌ Account is blocked. Deposit not allowed.");
            return;
        }
        balance += amount;
        addTransaction("Deposited: " + amount + " | New Balance: " + balance);
        System.out.println("✅ Deposited: " + amount + " | New Balance: " + balance);
    }

    @Override
    public boolean withdraw(double amount) {
        if (isBlocked) {
            System.out.println("❌ Account is blocked. Withdrawal not allowed.");
            return false;
        }
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            addTransaction("Withdrawn: " + amount + " | New Balance: " + balance);
            System.out.println("✅ Withdrawn: " + amount + " | New Balance: " + balance);
            return true;
        } else {
            System.out.println("❌ Insufficient balance. Minimum balance required: " + MIN_BALANCE);
            return false;
        }
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Savings Account:");
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Loan Amount: " + loanAmount);
    }

    public void applyForLoan(double amount) {
        if (amount <= balance * 2) {
            loanAmount += amount;
            addTransaction("Loan applied: " + amount + " | Total Loan: " + loanAmount);
            System.out.println("✅ Loan applied: " + amount);
        } else {
            System.out.println("❌ Loan amount exceeds allowed limit.");
        }
    }

    public void repayLoan(double amount) {
        if (loanAmount >= amount) {
            loanAmount -= amount;
            addTransaction("Loan repaid: " + amount + " | Remaining Loan: " + loanAmount);
            System.out.println("✅ Loan repaid: " + amount + " | Remaining Loan: " + loanAmount);
        } else {
            System.out.println("❌ Repayment amount exceeds remaining loan.");
        }
    }
}
