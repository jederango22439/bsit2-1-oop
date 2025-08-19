public class BankAccount {
static String bankName = "Liceo Bank";
static int totalAccounts = 0;
static double interestRate = 0.03;

private String accountNumber;
private String accountHolderName;
private double balance;

public static String generateAccountNumber() {
totalAccounts++;
return String.format("ACC%03d", totalAccounts);
}

public BankAccount(String accountHolderName, double initialBalance) {
this.accountHolderName = accountHolderName;
this.balance = initialBalance;
this.accountNumber = generateAccountNumber();
}

public void deposit(double amount) {
balance += amount;
System.out.println(accountHolderName + " deposited $" + amount + ". New balance: $" + balance);
}

public void withdraw(double amount) {
if (balance >= amount) {
balance -= amount;
System.out.println(accountHolderName + " withdrew $" + amount + ". New balance: $" + balance);
} else {
System.out.println("Insufficient funds for " + accountHolderName);
}
}

public double calculateInterest() {
return balance * interestRate;
}

public void displayAccountInfo() {
System.out.println("Account Created: " + accountNumber + " for " + accountHolderName + " with initial balance: $" + balance);
}

public String getAccountHolderName() {
return accountHolderName;
}
}



public class BankingDemo {
public static void main(String[] args) {
System.out.println("Bank Name: " + BankAccount.bankName);
System.out.println("Interest Rate: " + (BankAccount.interestRate * 100) + "%\n");

BankAccount acc1 = new BankAccount("John Doe", 1000);
BankAccount acc2 = new BankAccount("Jane Smith", 2500);
BankAccount acc3 = new BankAccount("Bob Johnson", 500);

acc1.displayAccountInfo();
acc2.displayAccountInfo();
acc3.displayAccountInfo();

System.out.println("\n=== Account Operations ===");
acc1.deposit(500);
acc2.withdraw(300);

System.out.println("\n=== Interest Calculation ===");
System.out.println(acc1.getAccountHolderName() + "'s interest: $" + acc1.calculateInterest());
System.out.println(acc2.getAccountHolderName() + "'s interest: $" + acc2.calculateInterest());
System.out.println(acc3.getAccountHolderName() + "'s interest: $" + acc3.calculateInterest());

System.out.println("\nTotal Accounts Created: " + BankAccount.totalAccounts);
}
}
