package auction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorsTest {

    // Product quantity tests
    @Test
    @DisplayName("Product quantity - Testing the produced error message with an odd integer as input ")
    void checkProductQuantity_OddInteger_ErrorMessage() {
        String input = "23";
        String result = InputValidators.checkProductQuantity(input);
        Assertions.assertEquals("Product quantity must be an even number !", result);
    }

    @Test
    @DisplayName("Product quantity - Testing the produced error message for a numerical value lesser than 2")
    void checkProductQuantity_NegativeInteger_ErrorMessage() {
        String input = "-12";
        String result = InputValidators.checkProductQuantity(input);
        Assertions.assertEquals("Product quantity must greater than or equal to 2 !", result);
    }

    @Test
    @DisplayName("Product quantity - Testing the produced error message for a non-numerical input")
    void checkProductQuantity_TextInput_ErrorMessage() {
        String input = "Some non-numerical text !@#";
        String result = InputValidators.checkProductQuantity(input);
        Assertions.assertEquals("Enter a valid positive integer !", result);
    }

    @Test
    @DisplayName("Product quantity - Testing the produced message for a valid input ")
    void checkProductQuantity_ValidInput_ValidMessage() {
        String input = "6";
        String result = InputValidators.checkProductQuantity(input);
        Assertions.assertEquals("VALID", result);
    }

    // Cash limit tests
    @Test
    @DisplayName("Cash limit - Testing the produced error message for a numerical value lesser than 2")
    void checkCashLimit_NegativeInteger_ErrorMessage() {
        String input = "-12";
        String result = InputValidators.checkCashLimit(input);
        Assertions.assertEquals("Cash limit must greater than or equal to 2!", result);
    }

    @Test
    @DisplayName("Cash limit - Testing the produced error message for a non-numerical input")
    void checkCashLimit_TextInput_ErrorMessage() {
        String input = "Some non-numerical text !@#";
        String result = InputValidators.checkProductQuantity(input);
        Assertions.assertEquals("Enter a valid positive integer !", result);
    }

    @Test
    @DisplayName("Cash limit - Testing the produced message for a valid input ")
    void checkCashLimit_ValidInput_ValidMessage() {
        String input = "20";
        String result = InputValidators.checkProductQuantity(input);
        Assertions.assertEquals("VALID", result);
    }

    // User bid
    @Test
    @DisplayName("User bid - Testing the produced error message for a non-numerical input")
    void checkUserBid_TextInput_ErrorMessage() {
        String input = "Some non-numerical text !@#";
        int remainingCash = 10;
        String result = InputValidators.checkUserBid(input, remainingCash);
        Assertions.assertEquals("Enter a valid positive integer !", result);
    }

    @Test
    @DisplayName("User bid - Testing the produced error message for a negative integer")
    void checkUserBid_NegativeInteger_ErrorMessage() {
        String input = "-12";
        int remainingCash = 10;
        String result = InputValidators.checkUserBid(input, remainingCash);
        Assertions.assertEquals("Enter a positive number !", result);
    }

    @Test
    @DisplayName("User bid - Testing the produced error message for an amount greater that the remaining cash")
    void checkUserBid_InsufficientRemainingCash_ErrorMessage() {
        String input = "11";
        int remainingCash = 10;
        String result = InputValidators.checkUserBid(input, remainingCash);
        Assertions.assertEquals("The bid must be lower than or at least equal to the amount of remaining cash !", result);
    }

    @Test
    @DisplayName("User bid - Testing the produced message for a valid input ")
    void checkUserBid_ValidInput_ValidMessage() {
        String input = "5";
        int remainingCash = 10;
        String result = InputValidators.checkUserBid(input, remainingCash);
        Assertions.assertEquals("VALID", result);
    }

}