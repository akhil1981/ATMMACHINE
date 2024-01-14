import java.util.Scanner;

class BankAccount{
    private double balance;
    public BankAccount (double initialbalance){
        this.balance = initialbalance;
    }
    public double getBalance(){
        return balance;

    }
    public void deposit (double amount){
        if (amount > 0){
            balance += amount;
            System.out.println("Deposit successful New balance:" + balance);
        }
        else {
            System.out.println("Invalid amount for deposit.");
        }

    }
    public void withdraw(double amount){
        if (amount > 0 && amount <=balance){
            balance -= amount;
            System.out.println("Withdrawl successful. New balance:" + balance);
        }
        else {
            System.out.println("Insufficient funds or invalid amonut for withdrawl.");
        }
    }
}
class ATM {
    private BankAccount account;
    private Scanner scanner;
    public ATM (BankAccount account){
        this.account = account;
        this.scanner = new Scanner(System.in);
    }
    public void ShowMoney(){
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void run(){
        int choice;
        do{
            ShowMoney();
            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            switch(choice){
                case 1:
             Balance();
                break;
                case 2:
               deposit();
                break;
                case 3:
                withdraw();
                break;
                case 4:
                System.out.println("Thank you for using the ATM!");
                break;
                default:
                System.out.println("Invalid choice. please select a valid option.");
            }
        }while(choice != 4);

    }
    private void Balance(){
        System.out.println("your current balance is:" + account.getBalance());
    }
    private void deposit(){
        System.out.println("Enter the amount to deposit:");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }
    private void withdraw(){
        System.out.println("Enter the amount withdraw:");
        double amonut = scanner.nextDouble();
        account.withdraw(amonut);
    }
}
public class ATMmachine {
    public static void main(String[] args) {
        System.out.println("Welcome ti the ATM!");
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter you four Digit PIN:");
        int enteredpin = Sc.nextInt();

        BankAccount userAccount  = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}