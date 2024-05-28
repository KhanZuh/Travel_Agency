public class BedAndBreakfast implements Bookable {
    private int price;
    private Customer customer;


    public BedAndBreakfast(int price, Customer customer) {
        this.price = price;
        this.customer = customer;
    }

//    Other Methods
    @Override
    public void book(Customer customer) {
        if (hasCapacity() && customer.canAfford(price)) {
            this.customer = customer;
            customer.pay(price);
        }
    }

    @Override
    public void cancel(Customer customer) {
        if (this.customer != null && this.customer.equals(customer)) {
            this.customer.pay(-price); // refunding the amount
            this.customer = null;
        }
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean hasCapacity() {
        return customer == null;
    }


    @Override
    public boolean hasBooking(Customer customer) {
        return false;

    }



}
