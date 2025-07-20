import java.util.Scanner;

class Bank
{

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
            }
        }
        sc.close();
    }
}