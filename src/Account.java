import java.util.Scanner;

public class Account {

    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    // Class Consturctor
    Account (String cname, String cid) {
        customerName = cname;
        customerID = cid;
    }

    //fxn for depositing money
    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    //fxn for withdrawing money
    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    //fxn for displaying previous transaction
    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Desposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occured");
        }
    }

    // fxn for calculating interest of current year funds after x years
    void calculateInterest(int years) {
        double interestRate = .0185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is  " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years, your balance will be: " + newBalance);
    }

    // fxn for displaying main menu
    void showMenu() {
        char option = '\0';
        Scanner scnr = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + " :)");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a Deposit");
        System.out.println("C. Make a Withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate Interest");
        System.out.println("F. Exit ");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scnr.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
                case 'A':
                    System.out.println("----------------");
                    System.out.println("Balance = $" + balance);
                    System.out.println("----------------");
                    System.out.println();
                    break;

                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = scnr.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;

                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = scnr.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;

                case 'D':
                    System.out.println("----------------");
                    getPreviousTransaction();
                    System.out.println("----------------");
                    System.out.println();
                    break;

                case 'E':
                    System.out.println("Enter how many years of accured interest: ");
                    int years = scnr.nextInt();
                    calculateInterest(years);
                    break;

                case 'F':
                    System.out.println("----------------");
                    break;

                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, E, F ");
                    break;
            }
        } while (option != 'F');
        System.out.println("Thank you for banking with us!");


    }

}























