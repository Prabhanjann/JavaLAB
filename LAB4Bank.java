import java.util.Scanner;

class Account {
    public String customerName;
    public String accountNumber;
    public double balance;

    public Account(String customerName, String accountNumber) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Details:");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + getBalance());
    }
}

class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String customerName, String accountNumber, double interestRate) {
        super(customerName, accountNumber);
        this.interestRate = interestRate;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            double newBalance = getBalance() - amount;
            setBalance(newBalance);
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void computeAndDepositInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
        System.out.println("Interest computed and deposited: " + interest);
    }

    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }

    private void setBalance(double balance) {
            super.balance = balance;
    }
}

class CurrentAccount extends Account {
    private static final double MINIMUM_BALANCE = 500.0;
    private static final double SERVICE_CHARGE = 50.0;

    public CurrentAccount(String customerName, String accountNumber) {
        super(customerName, accountNumber);
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            double newBalance = getBalance() - amount;
            setBalance(newBalance);
            System.out.println("Withdrew: " + amount);
            checkMinimumBalance();
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    private void checkMinimumBalance() {
        if (getBalance() < MINIMUM_BALANCE) {
            double newBalance = getBalance() - SERVICE_CHARGE;
            setBalance(newBalance);
            System.out.println("Service charge imposed: " + SERVICE_CHARGE);
        }
    }

    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
    }

    private void setBalance(double balance) {
           super.balance = balance;
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account;

        System.out.println("Choose account type: 1 for Savings, 2 for Current");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        if (choice == 1) {
            System.out.print("Enter interest rate: ");
            double interestRate = scanner.nextDouble();
            account = new SavingsAccount(name, accountNumber, interestRate);
        } else {
            account = new CurrentAccount(name, accountNumber);
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            if (account instanceof SavingsAccount) {
                System.out.println("4. Compute and Deposit Interest");
            }
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 3:
                    System.out.println("Current Balance: " + account.getBalance());
                    break;
                case 4:
                    if (account instanceof SavingsAccount) {
                        ((SavingsAccount) account).computeAndDepositInterest();
                    } else {
                        System.out.println("This option is not available for Current Accounts.");
                    }
                    break;
                case 5:
                    account.displayAccountDetails();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
