public class Customer {
    private String name;
    private int wallet;

    //    Constructor
    public Customer(String name, int wallet) {
        this.name = name;
        this.wallet = wallet;
    }

//    Getters and setters

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getWallet(){
        return this.wallet;
    }

    public void setWallet(int wallet){
        this.wallet = wallet;
    }

    public void pay(int amount){
        if (wallet >= amount) {
            wallet -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient Funds");
        }
    }

    public boolean canAfford(int amount){
        return wallet >= amount;
    }

}
