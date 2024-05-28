import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BedAndBreakfastTest {
    private BedAndBreakfast bedAndBreakfast;
    private Customer customer1;
    private Customer customer2;

    @BeforeEach
    public void setUp() {
        bedAndBreakfast = new BedAndBreakfast(40, customer1);
        bedAndBreakfast = new BedAndBreakfast(40, customer2);
        customer1 = new Customer("Alice", 100);
        customer2 = new Customer("Bob", 30);
    }

    @Test
    public void testBookSuccessfully() {
        bedAndBreakfast.book(customer1);
        assertThat(bedAndBreakfast.hasCapacity()).isFalse();
        assertThat(customer1.getWallet()).isEqualTo(60);
    }

    @Test
    public void testBookWithoutCapacity() {
        bedAndBreakfast.book(customer1);
        bedAndBreakfast.book(customer2); // Should fail
        assertThat(bedAndBreakfast.hasCapacity()).isFalse();
        assertThat(customer2.getWallet()).isEqualTo(30); // No change
    }

    @Test
    public void testBookWithoutEnoughMoney() {
        bedAndBreakfast.book(customer2); // Should fail
        assertThat(bedAndBreakfast.hasCapacity()).isTrue();
        assertThat(customer2.getWallet()).isEqualTo(30); // No change
    }

}
