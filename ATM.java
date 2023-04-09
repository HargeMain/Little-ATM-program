import javax.net.ssl.SSLContext;
import java.util.ArrayList;

public class ATM implements PayMethod {


    private ArrayList<User> users;

    public ATM() {
        this.users=new ArrayList<>();
    }
    public User LoginTOAtm(int pin){
        User u=searchByPin(pin);
        if(u.getName().equals("Nobody")){
            System.out.println("Wrong pin try again");
            return u;
        }else{
            System.out.println("Succefully login in");
            return u;
        }

    }

    @Override
    public void deposit(double money,User loginUser) {
    loginUser.getCard().setAmount(money);
    System.out.println("Amount of "+money+"$ succefully added");

    }

    @Override
    public void withdraw(double money,User loginUser) {
        if(loginUser.getCard().getAmount()<money){
            System.out.println("You dont have enough funds in your account");
        }else{
            loginUser.getCard().removeAmount(money);
            System.out.println("Amount succefully withdraw");
        }

    }
    public void createUser(String name){
        User u=new User(name);
        System.out.println(u);
        if(checkCard(u)){
            System.out.println("The user "+u.getName()+" was succefully created\nPin is "+u.getCard().getPin());
            users.add(u);
        }


    }

    private boolean checkCard(User user){
        if(users.contains(user)){
            System.out.println("This user already exist");
            return false;
        }else{
            users.add(user);
            return true;
        }

    }

    private User searchByPin(int pin){
        for(User i:users){
            if(i.getCard().getPin()==pin){
                return i;
            }
        }
        return new User("Nobody");
    }
}
