import java.util.Scanner;

public class BankAccountManagementSystem {
    private Admin admin = new Admin();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        if (!admin.isAdminRegistered()) {
            registerAdmin();
        }

        if (admin.login()) {
            adminMenu();
        } else {
            System.out.println("Admin login failed. Exiting system...");
        }
    }

    private void registerAdmin() {
        System.out.println("No admin registered yet.");
        System.out.print("Enter admin username: ");
        String username = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();
        admin.registerAdmin(username, password);
    }

    private void adminMenu() {
        while (true) {
            System.out.println("\n=== ADMIN MENU ===");
            System.out.println("1. Create Account");
            System.out.println("2. List Accounts");
            System.out.println("3. Money Transfer");
            System.out.println("4. Pay Loan");
            System.out.println("5. Block/Unblock User");
            System.out.println("6. Credit Money");
            System.out.println("7. Debit Money");
            System.out.println("8. Exchange Currency");
            System.out.println("9. Logout");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    listAccounts();
                    break;
                case 3:
                    moneyTransfer();
                    break;
                case 4:
                    payLoan();
                    break;
                case 5:
                    blockUnblockUser();
                    break;
                case 6:
                    creditMoney();
                    break;
                case 7:
                    debitMoney();
                    break;
                case 8:
                    exchangeCurrency();
                    break;
                case 9:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void createAccount() {
        System.out.print("Enter account holder name: ");
        scanner.nextLine();  // Consume newline
        String name = scanner.nextLine();
        System.out.print("Enter initial deposit amount: ");
        double amount = scanner.nextDouble();
        admin.createAccount(name, amount);
    }

    private void listAccounts() {
        admin.showAccounts();
    }

    private void moneyTransfer() {
        System.out.print("Enter source account ID: ");
        int sourceId = scanner.nextInt();
        System.out.print("Enter destination account ID: ");
        int destinationId = scanner.nextInt();
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        admin.transferMoney(sourceId, destinationId, amount);
    }

    private void payLoan() {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        System.out.print("Enter loan repayment amount: ");
        double amount = scanner.nextDouble();
        admin.payLoan(accountId, amount);
    }

    private void blockUnblockUser() {
        System.out.print("Enter account ID to block/unblock: ");
        int accountId = scanner.nextInt();
        admin.blockUnblockUser(accountId);
    }

    private void creditMoney() {
        System.out.print("Enter account ID to credit money: ");
        int accountId = scanner.nextInt();
        System.out.print("Enter amount to credit: ");
        double amount = scanner.nextDouble();
        admin.creditMoney(accountId, amount);
    }

    private void debitMoney() {
        System.out.print("Enter account ID to debit money: ");
        int accountId = scanner.nextInt();
        System.out.print("Enter amount to debit: ");
        double amount = scanner.nextDouble();
        admin.debitMoney(accountId, amount);
    }

    private void exchangeCurrency() {
        System.out.print("Enter amount to exchange: ");
        double amount = scanner.nextDouble();
        System.out.print("Enter exchange rate: ");
        double rate = scanner.nextDouble();
        admin.exchangeCurrency(amount, rate);
    }

    public static void main(String[] args) {
        BankAccountManagementSystem system = new BankAccountManagementSystem();
        system.start();
    }
}
