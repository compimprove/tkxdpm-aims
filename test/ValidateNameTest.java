import controller.PlaceOrderController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidateNameTest {
    private PlaceOrderController placeOrderController;

    @BeforeEach
    void setUp() throws Exception {
        placeOrderController = new PlaceOrderController();
    }

    @ParameterizedTest
    @CsvSource({
            "nguyenlm,true",
            "nguyen01234,false",
            "$#nguyen,false",
    })
    public void test(String name, boolean expected) {
        boolean isValidate = placeOrderController.validateName(name);
        assertEquals(expected, isValidate);
    }

    @Test
    public void testNull() {
        boolean isValidate = placeOrderController.validateName(null);
        assertEquals(false, isValidate);
    }

}
