import java.util.Scanner;

public class Admin {
    private String adminUsername;
    private String adminPassword;
    private Account[] accounts;
    private int accountCounter;

    public Admin() {
        this.accounts = new Account[10];  // Fixed size of 10 accounts
        this.accountCounter = 0;
        this.adminUsername = null;
        this.adminPassword = null;
    }

    // Method to check if the admin is registered
    public boolean isAdminRegistered() {
        return adminUsername != null && adminPassword != null;
    }

    // Method to register an admin
    public void registerAdmin(String username, String password) {
        this.adminUsername = username;
        this.adminPassword = password;
        System.out.println("✅ Admin registered successfully.");
    }

    // Method to login
    public boolean login() {
        if (!isAdminRegistered()) {
            System.out.println("⚠️ Admin not registered! Please register first.");
            return false;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter admin username: ");
        String username = scanner.nextLine();

        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            return true;
        } else {
            System.out.println("Admin login failed. Exiting system...");
            return false;
        }
    }

    // Admin actions
    public void createAccount(String name, double balance) {
        if (accountCounter < accounts.length) {
            Account newAccount = new SavingsAccount(accountCounter + 1, name, balance);  // Account numbering starts from 1
            accounts[accountCounter++] = newAccount;
            System.out.println("✅ Account created with ID: " + newAccount.getAccountNumber());
        } else {
            System.out.println("⚠️ No space for more accounts.");
        }
    }

    public void showAccounts() {
        if (accountCounter == 0) {
            System.out.println("No accounts available.");
        } else {
            for (int i = 0; i < accountCounter; i++) {
                accounts[i].displayAccountDetails();
            }
        }
    }

    public void blockUnblockUser(int accountId) {
        if (accountId <= 0 || accountId > accountCounter) {
            System.out.println("⚠️ Invalid account ID.");
            return;
        }
        Account account = accounts[accountId - 1];
        if (account.isBlocked()) {
            account.unlockAccount();
        } else {
            account.lockAccount();
        }
    }

    public void creditMoney(int accountId, double amount) {
        if (accountId <= 0 || accountId > accountCounter) {
            System.out.println("⚠️ Invalid account ID.");
            return;
        }
        Account account = accounts[accountId - 1];
        account.deposit(amount);
    }

    public void debitMoney(int accountId, double amount) {
        if (accountId <= 0 || accountId > accountCounter) {
            System.out.println("⚠️ Invalid account ID.");
            return;
        }
        Account account = accounts[accountId - 1];
        account.withdraw(amount);
    }

    public void payLoan(int accountId, double amount) {
        if (accountId <= 0 || accountId > accountCounter) {
            System.out.println("⚠️ Invalid account ID.");
            return;
        }
        Account account = accounts[accountId - 1];
        if (account instanceof SavingsAccount) {
            ((SavingsAccount) account).repayLoan(amount);
        } else {
            System.out.println("❌ This account is not eligible for loan repayment.");
        }
    }

    public void transferMoney(int sourceId, int destinationId, double amount) {
        if (sourceId <= 0 || sourceId > accountCounter || destinationId <= 0 || destinationId > accountCounter) {
            System.out.println("⚠️ Invalid account IDs.");
            return;
        }
        Account source = accounts[sourceId - 1];
        Account destination = accounts[destinationId - 1];

        if (source.withdraw(amount)) {
            destination.deposit(amount);
            System.out.println("✅ Transfer successful.");
        }
    }

    // Method to exchange currency (if needed, can be expanded)
    public void exchangeCurrency(double amount, double rate) {
        double exchangedAmount = amount * rate;
        System.out.println("✅ Exchanged " + amount + " at rate " + rate + " = " + exchangedAmount);
    }
}
