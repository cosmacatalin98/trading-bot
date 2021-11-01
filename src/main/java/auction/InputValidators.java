package auction;

/**
 * Represents a collection of functions that are used
 * to validate the input provided by the use in the GUI.
 *
 * @author Catalin Cosma
 */
public class InputValidators {

    /**
     * Checks for incorrect input in the Product quantity field using the rule :
     * Input must be an integer greater than or equal to 2 and divisible by 2.
     * since every round 2 quantity units are auctioned
     *
     * @param userInput the input provided by the user
     * @return          a corresponding message regarding the input
     */
    public static String checkProductQuantity(String userInput) {
        try {
            int productQuantityInt = Integer.parseInt(userInput);

            if (productQuantityInt % 2 != 0) {
                return "Product quantity must be an even number !";
            }

            if (productQuantityInt < 2) {
                return "Product quantity must greater than or equal to 2 !";
            }
        } catch (NumberFormatException e) {
            return "Enter a valid positive integer !";
        } catch (Exception e) {
            return "Input error !";
        }
        return "VALID";
    }

    /**
     * Checks for incorrect input in the Cash limit field using the rule :
     * Input must be an integer greater than or equal to 2.
     *
     * @param userInput the input provided by the user
     * @return          a corresponding message regarding the input
     */
    public static String checkCashLimit(String userInput) {
        try {
            int cashLimitInt = Integer.parseInt(userInput);

            if (cashLimitInt < 2) {
                return "Cash limit must greater than or equal to 2!";
            }
        } catch (NumberFormatException e) {
            return "Enter a valid positive integer !";
        } catch (Exception e) {
            return "Input error !";
        }
        return "VALID";
    }

    /**
     * Checks for incorrect input in the Bid field using the rule :
     * The input must be a positive integer that's lower or at least equal to the amount
     * of remaining cash.
     *
     * @param userInput          the input provided by the user
     * @param remainingCashLimit the user's remaining cash
     * @return                   a corresponding message regarding the input
     */
    public static String checkUserBid(String userInput, int remainingCashLimit) {
        try {
            int userBidInt = Integer.parseInt(userInput);

            if (userBidInt < 0) {
                return "Enter a positive number !";
            }
            if (userBidInt > remainingCashLimit) {
                return "The bid must be lower than or at least equal to the amount of remaining cash !";
            }
        } catch (NumberFormatException e) {
            return "Enter a valid positive integer !";
        } catch (Exception e) {
            return "Input error !";
        }
        return "VALID";
    }

}
