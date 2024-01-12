import java.util.*;

class banksys {
    String username;
    String userid;
    String password;
    int accountno;
    float amount = 100000;
    String Transactionhistory = "";

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the name :");
        this.username = sc.nextLine();
        System.out.println("\nEnter the userid: ");
        this.userid = sc.nextLine();
        System.out.println("\nEnter the password : ");
        this.password = sc.nextLine();

        System.out.println("\nYou have registered successfully.");

    }

    public boolean login() {
        boolean islogin = false;
        Scanner sc = new Scanner(System.in);

        while (islogin == false) {
            System.out.println("Enetr the userid : ");
            String uid = sc.nextLine();

            if (uid.equals(userid)) {
                System.out.println("Enetr the Password : ");
                String upassword = sc.nextLine();

                if (upassword.equals(password)) {
                    System.out.println("Login Successful..");
                    islogin = true;
                } else {
                    System.out.println("Please ! Enter Correct Password");
                }

            } else {
                System.out.println("Userid not Found");
            }

        }
        return islogin;
    }

    public void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the amount you want to deposit :");
        int damount = sc.nextInt();
        if (damount > 100000) {
            System.out.println("sorry....limit exceed");

        } else {
            amount = amount + damount;
            System.out.println(damount + " deposited succesfully");
            String str = "Amount " + damount + " Deposited\n";
            Transactionhistory = Transactionhistory.concat(str);
        }
    }

    public void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n Enter the Amount which you want to withdraw : ");
        int wamount = sc.nextInt();
        if (wamount >= amount) {
            System.out.println("sorry....you have not sufficient amount to withdraw");

        } else {
            amount = amount - wamount;
            System.out.println(wamount + " withdrawed succesfully");
            String str = "Amount " + wamount + " withdrawed\n";
            Transactionhistory = Transactionhistory.concat(str);
        }
    }

    public void transfer() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nenter the userid in which you want to transfer:");
        String another_user_name = sc.nextLine();

        System.out.println("\n Enter the Amount which you want to transfer : ");
        int tamount = sc.nextInt();

        if (tamount > 50000) {
            System.out.println("sorry....transaction limit exceed");

        } else {
            amount = amount - tamount;
            System.out.println(tamount + " transfer succesfully in " + another_user_name);
            String str = "Amount " + tamount + " transfered to" + another_user_name + "\n";
            Transactionhistory = Transactionhistory.concat(str);

        }
    }

    public void checkbalance() {
        System.out.println("Your Account balance is " + amount);
    }

    public void tran_history() {
        System.out.println(Transactionhistory);

    }
}

public class ATMsys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to ATM System....");

        System.out.println("1------Register \n2------Exit");
        System.out.println("Enter your choice : ");
        int choice = sc.nextInt();

        banksys b = new banksys();

        switch (choice) {
            case 1:
                b.register();
                System.out.println("1------login\n2------Exit");
                System.out.println("Enter your choice : ");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        b.login();
                        boolean finish = false;
                        while (finish == false) {
                            System.out.println(
                                    "1----- Withdraw \n2------Deposit \n3------Transfer \n4------Check balance \n5------Trancation History \n6-----finish Transcation");
                            System.out.println("Enter your choice : ");
                            int ch2 = sc.nextInt();
                            switch (ch2) {
                                case 1:
                                    b.withdraw();
                                    break;
                                case 2:
                                    b.deposit();
                                    break;
                                case 3:
                                    b.transfer();
                                    break;
                                case 4:
                                    b.checkbalance();
                                    break;
                                case 5:
                                    b.tran_history();
                                    break;
                                case 6:
                                    finish = true;
                                    break;
                                default:
                                    System.out.println("Invalid choice");

                            }
                        }

                        break;
                    case 2:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice");

                }
                break;
            case 2:
                System.exit(0);
            default:
                System.out.println("Invalid choice");

        }

    }
}
