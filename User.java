import java.util.Scanner;

public class User {
    private String name;

    private Card card;

    public User(String name) {
        this.name = name;
        this.card=createCard();
    }

    public Card getCard() {
        return card;
    }

    public String getName() {
        return name;
    }

    public  Card createCard(){
        Scanner s=new Scanner(System.in);
        while(true){
            System.out.println("Enter a card provider\nMastercard\nVisa\nAmerican express");
            String provider=Card.choiseACardProvider(s.nextLine());
            if(provider.equals("Unsupported card")){
                System.out.println("Your card is not supported\nWill you try again?Y/N");
                if(s.nextLine().toLowerCase().equals("y")){
                    continue;
                }
                break;
            }
            System.out.println("Nice choise your start amount is 100$ spend it wissily!");
            return new Card(provider,100,this.getName());
        }

       return new Card("none",0,"nobody");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", card=" + card +
                '}';
    }
}
