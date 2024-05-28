import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TravelAgentTest {

    Bookable bookable;
    Customer customer;
    Train train;
    TravelAgent travelAgent;

    @BeforeEach
    public void setUp(){
        bookable = new Train(100, 500);
        customer = new Customer("John", 200);
        travelAgent = new TravelAgent();
    }

    @Test
    void testMakeBooking_CustomerCanAffordAndHasCapacity_BookingSuccessful() {
        travelAgent.makeBooking(bookable, customer);
        assertThat(bookable.getCustomers().size()).isEqualTo(1);
    }
}
