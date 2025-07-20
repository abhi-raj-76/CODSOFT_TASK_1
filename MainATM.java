import java.util.Scanner;

class Bank
{
    private double amount;
    public Bank()
    {
        this.amount = 5000;
    }
    public double Withdraw(double amount)
    {
        if(this.amount >= amount)
        {
            this.amount -= amount;
            return this.amount;
        }
        return -1.0;
    }
    public double Deposit(double amount)
    {
        this.amount += amount;
        return this.amount;
    }
    public double Balance(){return this.amount;}
}
class User
{

    private int pin;
    private String name;
    private double amount;
    private double bal;

    public User()
    {
        this.pin = 1010;
        this.name = "raj";
    }
    public User(int pin){this.pin = pin;}

    boolean isPinCorrect(int pin)
    {
        if(this.pin == pin)
        {return true;}
        return false;
    }
    public void setPin(int pin){this.pin = pin;System.err.println("PIN updated");}
    public String getName()
    {return name;}
    public void getAmountFromUser(Scanner sc)
    {
        System.err.print("Enter your amount: ");
        this.amount = sc.nextDouble();
        return;
    }
    public void connectBank(int choice,Scanner sc)
    {
        Bank b1 = new Bank();
        switch (choice) 
        {
            case 1:
                getAmountFromUser(sc);
                this.bal = b1.Withdraw(this.amount);
                if(this.bal == -1.0){System.err.println("Insufficient Balance:");}
                System.err.println("Your Current Balance after Withdrawing "+this.bal);   
                break;
            case 2:
                getAmountFromUser(sc);
                this.bal = b1.Deposit(this.amount);
                System.err.println("Your Current Balance after Depositing "+this.bal);
                break;
            case 3:
                this.bal = b1.Balance();
                System.err.println("Your current Balance: "+this.bal);
                break;
        }
        return;             
    }
}
public class MainATM
{
    static int pin;
    static int limit = 2;
    public static void getPin(Scanner sc)
    { 
        System.out.println("----------CODSOFT ATM----------");
        System.out.println("Enter your PIN:");
        pin = sc.nextInt();
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        getPin(sc);
        User u1 = new User();
        boolean validPin = u1.isPinCorrect(pin);
        if(validPin == true)
        {
            while(true)
            {
                System.out.println("Hello, "+u1.getName());
                System.out.println("        1: Withdraw");
                System.out.println("        2: Deposit");
                System.out.println("        3: Balance");
                System.out.println("        4: Change PIN");
                System.out.println("        5: Exit");
                int choice = sc.nextInt();
                if(choice!= 5 && choice!= 4){u1.connectBank(choice,sc);}
                else if(choice == 4)
                {
                    System.out.print("Enter your new PIN: ");
                    pin = sc.nextInt();
                    u1.setPin(pin);
                }
                else{System.exit(-1);}
            }
        }
        else if(limit != 0)
        {
            System.err.println("PIN incorrect,Only "+limit+" attempts Remaining, Try again!!!");
            limit--;
            main(args);
        }
        else System.exit(-1);
        sc.close();
    }
}