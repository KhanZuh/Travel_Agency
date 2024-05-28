import java.util.ArrayList;

public class Train implements Bookable {

    private int price;
    private int capacity;
    private ArrayList<Customer> customers;

    //    Constructors
    public Train(int price, int capacity) {
        this.price = price;
        this.capacity = capacity;
        this.customers = new ArrayList<>();
    }

//    Other methods
}
