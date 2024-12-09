public abstract class Account {
    protected int accountNumber;
    protected String accountHolderName;
    protected double balance;
    protected boolean isBlocked;
    protected double loanAmount;
    protected String[] transactionHistory;
    protected int transactionCount;

    public Account(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.isBlocked = false;
        this.loanAmount = 0.0;
        this.transactionHistory = new String[10];
        this.transactionCount = 0;
        addTransaction("Account created with balance: " + balance);
    }

    public abstract void deposit(double amount);
    public abstract boolean withdraw(double amount);
    public abstract void displayAccountDetails();

    public boolean isBlocked() {
        return this.isBlocked;
    }

    public void lockAccount() {
        this.isBlocked = true;
        System.out.println("⚠️ Account has been locked.");
    }

    public void unlockAccount() {
        this.isBlocked = false;
        System.out.println("✅ Account has been unlocked.");
    }

    public void addTransaction(String transaction) {
        if (this.transactionCount < this.transactionHistory.length) {
            this.transactionHistory[this.transactionCount++] = transaction;
        } else {
            System.arraycopy(this.transactionHistory, 1, this.transactionHistory, 0, this.transactionHistory.length - 1);
            this.transactionHistory[this.transactionHistory.length - 1] = transaction;
        }
    }

    public void printTransactionHistory() {
        System.out.println("📰 Transaction History for Account: " + this.accountNumber);
        if (this.transactionCount == 0) {
            System.out.println("No transactions yet.");
        } else {
            for (int i = 0; i < this.transactionCount; i++) {
                System.out.println((i + 1) + ". " + this.transactionHistory[i]);
            }
        }
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setAccountHolderName(String name) {
        this.accountHolderName = name;
        System.out.println("✅ Account holder name updated.");
    }
}
