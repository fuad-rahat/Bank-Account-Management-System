public class CurrentAccount extends Account {
    private static final double OVERDRAFT_LIMIT = 1000.0;

    public CurrentAccount(int accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public void deposit(double amount) {
        if (!isBlocked) {
            balance += amount;
            System.out.println("Deposited: " + amount + " | New Balance: " + balance);
        } else {
            System.out.println("❌ Account is blocked. Deposit not allowed.");
        }
    }

    @Override
    public boolean withdraw(double amount) {
        if (isBlocked) {
            System.out.println("❌ Account is blocked. Withdrawal not allowed.");
            return false;
        }
        if (balance - amount >= -OVERDRAFT_LIMIT) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " | New Balance: " + balance);
            return true;
        } else {
            System.out.println("❌ Overdraft limit exceeded!");
            return false;
        }
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Current Account:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("Loan Amount: " + loanAmount);
        System.out.println("Account is " + (isBlocked ? "Blocked" : "Active"));
    }
}
