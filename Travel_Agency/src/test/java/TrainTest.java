import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TrainTest {

    private Train train;
    private Customer customer1;
    private Customer customer2;


    @BeforeEach
    void setUp() {
        train = new Train(100, 10); // price: 100, capacity: 10
        customer1 = new Customer("John", 200); // customer1 has 200 units of money
        customer2 = new Customer("Jane Doe", 50); // customer2 has 50 units of money

    }

    @Test
    void testBookSuccessful() {
        train.book(customer1);
        assertThat(train.hasCapacity()).isTrue();
        assertThat(customer1.getWallet()).isEqualTo(100);
    }

    // split these tests into two (above)

    @Test
    void testBookNoCapacity() {
        Train smallTrain = new Train(100, 1); // capacity: 1
        smallTrain.book(customer1);
        Customer anotherCustomer = new Customer("John", 200);
        smallTrain.book(anotherCustomer);
        assertThat(smallTrain.hasCapacity()).isFalse();
        assertThat(anotherCustomer.getWallet()).isEqualTo(200);

    }

    @Test
    void testBookCannotAfford() {
        Customer customer2 = new Customer("Jane doe", 50); // customer has only 50 units of money
        train.book(customer2);
        assertThat(train.hasCapacity()).isTrue();
        assertThat(customer2.getWallet()).isEqualTo(50);
    }

    @Test
    void testGetPrice() {
        assertThat(train.getPrice()).isEqualTo(100);
    }



}