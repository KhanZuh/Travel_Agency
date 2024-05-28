import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CustomerTest {

    private Customer customer;

    @BeforeEach
    public void setUp(){
        customer = new Customer("John", 200);
    }

    @Test
    public void getName(){
        assertThat(customer.getName()).isEqualTo("John");
    }

    @Test
    public void getWallet(){
        assertThat(customer.getWallet()).isEqualTo(200);
    }

    @Test
    public void canPayWithSufficientFunds(){
        customer.pay(50);
        assertThat(customer.getWallet()).isEqualTo(150);
    }

    @Test
    public void canAffordWithSufficientFunds(){
        assertThat(customer.canAfford(50)).isEqualTo(true);

    }

    @Test
    public void canAffordWithInsufficientFunds(){
        assertThat(customer.canAfford(300)).isEqualTo(false);
    }

}

