import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        String atmControl;
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("$ATM$\n1.Create user\n2.Continue to log\n3.Exit");
            atmControl=s.nextLine();
            //function to clear the console
            System.out.print("\033[H\033[2J");
            switch (Integer.parseInt(atmControl)) {
                case 1 -> {
                    System.out.println("Write new user name");
                    atm.createUser(s.nextLine());
                }
                case 2 -> {
                    System.out.print("Enter the pin: ");
                    try {
                        User logedIn = atm.LoginTOAtm(Integer.parseInt(s.nextLine()));
                        if (logedIn.getName().equals("Nobody")) {
                            System.out.println("Returning");
                        } else {
                            String control;
                            do {

                                System.out.println("WELCOME TO ATM");
                                System.out.println("1.Withdraw\t2.Deposit\n3.Check the account status\n4.Exit");
                                control = s.nextLine();
                                switch (Integer.parseInt(control)) {
                                    case 1 -> {
                                        System.out.println("Write the sum you want to withdraw from your account");
                                        try {
                                            atm.withdraw(Double.parseDouble(s.nextLine()), logedIn);
                                        } catch (NumberFormatException e) {
                                            System.out.println("Wrong input");
                                        }
                                    }
                                    case 2 -> {
                                        System.out.println("Write the sum you want to deposit to your account");
                                        try {
                                            atm.deposit(Double.parseDouble(s.nextLine()), logedIn);
                                        } catch (NumberFormatException e) {
                                            System.out.println("Wrong input");
                                        }
                                    }
                                  case 3 -> {
                                     System.out.println(logedIn);
                                  }
                                    case 4 -> {
                                    }


                                }
                            } while (Integer.parseInt(control)!=4);

                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong number");
                    }

                }
                case 3->{
                }
            }
        }while(Integer.parseInt(atmControl)!=3);
    }
}