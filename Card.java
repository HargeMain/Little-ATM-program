import java.util.Random;

public class Card {
    private String provider;
    private double amount;
    private String cardNumber;
    private int internNumber;
    private int pin;
    private String cardUserName;
    private Random r=new Random();


    public Card(String provider, double amount, String cardUserName) {
        this.provider = provider;
        this.amount = amount;
        this.cardNumber = "CB"+r.nextInt(5000);
        this.internNumber = r.nextInt(100,999);
        this.pin=r.nextInt(1000,9999);
        this.cardUserName=cardUserName;
    }

    public Card() {
    }

    public String getCardUserName() {
        return cardUserName;
    }

    public void setCardUserName(String cardUserName) {
        this.cardUserName = cardUserName;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public double getAmount() {
        return amount;
    }
    public void removeAmount(double amount){
        this.amount-=amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getInternNumber() {
        return internNumber;
    }

    public void setInternNumber(int internNumber) {
        this.internNumber = internNumber;
    }

    public int getPin() {
        return pin;
    }

    public String toString() {
        return "Card{" +
                "provider='" + provider + '\'' +
                ", amount=" + amount +
                ", cardNumber='" + cardNumber + '\'' +
                ", internNumber=" + internNumber +
                '}';
    }

    public static String choiseACardProvider(String provider){
        return switch (provider.toLowerCase()){
            case "mastercard"->"Mastercard";
            case "visa"->"Visa";
            case "american express"->"American Express";
            default -> {
               yield "Unsupported card";

            }
        };
    }
}
