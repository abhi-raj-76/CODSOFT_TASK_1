import java.util.Scanner;

class Bank
{
    private double amount;
    public Bank()
    {
        this.amount = 5000;
    }
    public void Withdraw()
    {

    }
    public void Deposit(){}
    public void Balance(){}
}
class User
{

    private int pin;
    private String name;

    public User()
    {
        this.pin = 1010;
        this.name = "raj";
    }

    boolean isPinCorrect(int pin)
    {
        if(this.pin == pin)
        {return true;}
        return false;
    }
    public String getName()
    {return name;}
    public void connectBank(int choice,Scanner sc)
    {
        Bank b1 = new Bank();
        switch (choice) 
        {
            case 1:
                System.err.println("Enter your amount: ");
                b1.Withdraw();   
                break;
            case 2:
                b1.Deposit();
                break;
            case 3:
                b1.Balance();
                break;
        }
                    
    }
}
public class MainATM
{
    public static void main(String[] args)
    {
        final int pin;

        Scanner sc = new Scanner(System.in);

        System.out.println("CODSOFT ATM");
        System.out.println("Enter your PIN:");
        pin = sc.nextInt();
        User u1 = new User();
        boolean validPin = u1.isPinCorrect(pin);
        if(validPin == true)
        {
            while(true)
            {
                System.out.println("Hello, "+u1.getName());
                System.out.println("1: Withdraw");
                System.out.println("2: Deposit");
                System.out.println("3: Balance");
                System.out.println("4: Change PIN");
                System.out.println("5: Exit");
                int choice = sc.nextInt();
                if(choice!= 5){u1.connectBank(choice,sc);}
                else if(choice == 4)
                {

                }
                else{System.exit(-1);}
            }
        }
        sc.close();
    }
}