import java.util.ArrayList;

public interface Bookable {

        void book(Customer customer);

        void cancel(Customer customer);

        int getPrice();

        boolean hasCapacity();

        boolean hasBooking(Customer customer);

        ArrayList<Customer> getCustomers();

    }
