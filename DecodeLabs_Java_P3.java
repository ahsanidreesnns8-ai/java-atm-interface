import java.util.Scanner;
class BankAccount
{
    private double balance;

    public void deposit(double amount)
    {
        if (amount > 0)
        {
            balance += amount;
            System.out.println("Deposit Successful.");
            System.out.println("Current Balance: " + balance);
        }
        else
        {
            System.out.println("Please enter amount greater than '0' to deposit");
        }
    }

    public void  withdraw(double amount)
    {
        if(amount <= 0)
        {
            System.out.println("Please enter an amount greater than 0.");
        }
        else if(amount <= balance)
        {
            balance -= amount;
            System.out.println("Withdrawal Successful.");
            System.out.println("Current Balance: " + balance);
        }
        else
        {
            System.out.println("Insufficient Balance.");
        }
    }

    public void getBalance()
    {
        System.out.println("Current Balance: " + balance);
    }
}

class ATM
{
    private BankAccount account = new BankAccount();
    private Scanner sc = new Scanner(System.in);

    public void menu()
    {
        while (true)
        {
            System.out.println(
                    "----- ATM MENU -----\n" +
                            "1. Deposit\n" +
                            "2. Withdraw\n" +
                            "3. Check Balance\n" +
                            "4. Exit");
            System.out.println("Enter your choice(1-4): ");
            if (sc.hasNextInt())
            {
                int choice = sc.nextInt();
                switch (choice)
                {
                    case 1:
                    {
                        System.out.println("Enter the amount you want to deposit: ");
                        if(sc.hasNextDouble())
                        {
                            double depositamount = sc.nextDouble();
                            account.deposit(depositamount);
                            break;
                        }
                        else
                        {
                            System.out.println("Please enter a valid amount.");
                            sc.next();
                            break;
                        }
                    }
                    case 2:
                    {
                        System.out.println("Enter the amount you want to withdraw: ");
                        if (sc.hasNextDouble())
                        {
                            double withdrawamount = sc.nextDouble();
                            account.withdraw(withdrawamount);
                            break;
                        }
                        else
                        {
                            System.out.println("Please enter a valid amount.");
                            sc.next();
                            break;
                        }
                    }
                    case 3:
                    {
                        account.getBalance();
                        break;
                    }
                    case 4:
                    {
                        System.out.println("Thank you for using our ATM.");
                        sc.close();
                        return;
                    }
                    default:
                    {
                        System.out.println("Please enter choice between 1 and 4");
                    }
                }
            }
            else
            {
                System.out.println("Please enter a valid number.");
                sc.next();
            }
        }
    }
}


public class DecodeLabs_Java_P3
{
    public static void main(String[] args)
    {
        System.out.println("=============================");
        System.out.println("        Welcome To ATM       ");
        System.out.println("=============================");
        System.out.println("\n");
        ATM atm = new ATM();
        atm.menu();
    }
}
