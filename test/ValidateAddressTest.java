import controller.PlaceOrderController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidateAddressTest {
    private PlaceOrderController placeOrderController;

    @BeforeEach
    void setUp() throws Exception {
        placeOrderController = new PlaceOrderController();
    }

    @ParameterizedTest
    @CsvSource({
            "hanoi,true",
            "so 15 Hai Ba Trung Hanoi,true",
            "$ # hanoi,false",
    })
    public void test(String address, boolean expected) {
        boolean isValidate = placeOrderController.validateAddress(address);
        assertEquals(expected, isValidate);
    }

    @Test
    public void testNull() {
        boolean isValidate = placeOrderController.validateAddress(null);
        assertEquals(false, isValidate);
    }

}
