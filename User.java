public class User {
    private static int idCounter = 1;
    private int userId;
    private String username;
    private String password;
    private Account account;

    public User(String username, String password) {
        this.userId = idCounter++;
        this.username = username;
        this.password = password;
        this.account = null; // Initially, no account is created
    }

    public void createAccount(Account account) {
        this.account = account;
        System.out.println("✅ Account created successfully for user: " + username);
    }

    public void deleteAccount() {
        if (account != null) {
            account = null;
            System.out.println("✅ Account deleted successfully for user: " + username);
        } else {
            System.out.println("⚠️ No account to delete for user: " + username);
        }
    }

    public int getId() {
        return userId;
    }

    public Account getAccount() {
        return account;
    }

    public void editAccountHolderName(String newName) {
        if (account != null) {
            account.setAccountHolderName(newName);
            System.out.println("✅ Account holder name updated to: " + newName);
        } else {
            System.out.println("⚠️ No account exists to update.");
        }
    }

    public void blockAccount() {
        if (account != null) {
            account.lockAccount(); // Lock the account
            System.out.println("✅ Account blocked successfully for user: " + username);
        } else {
            System.out.println("⚠️ No account to block for user: " + username);
        }
    }

    public void unblockAccount() {
        if (account != null) {
            account.unlockAccount(); // Unlock the account
            System.out.println("✅ Account unblocked successfully for user: " + username);
        } else {
            System.out.println("⚠️ No account to unblock for user: " + username);
        }
    }

    public void displayUserDetails() {
        System.out.println("\nUser ID: " + userId);
        System.out.println("Username: " + username);
        if (account != null) {
            account.displayAccountDetails();
        } else {
            System.out.println("No account associated with this user.");
        }
    }
}
