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
//    @Override
//    public void book(Customer customer) {
//        if (customer.canAfford(price)) {
//            if (hasCapacity()) {
//                customers.add(customer);
//                customer.pay(price);
//            } else {
//                System.out.println("Invalid attempt");
//            }
//        } else {
//            System.out.println("Invalid attempt");
//        }
//}
    @Override
    public void book(Customer customer) {
        if (hasCapacity() && customer.canAfford(price)) {
            customers.add(customer);
            customer.pay(price);
        }
    }

    @Override
    public void cancel(Customer customer) {
        if (customers.remove(customer)) {
            customer.pay(-price); // refunding the amount
        }
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean hasCapacity() {
        return customers.size() < capacity;
    }

    @Override
    public boolean hasBooking(Customer customer) {
        return  customer == null;

    }


    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }


}
