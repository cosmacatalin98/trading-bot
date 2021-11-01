package bidders;

/**
 * Represents the human bidder that uses the GUI to
 * place bids and compete against the bot.
 *
 * @author Catalin Cosma
 */
public class Human {

    private int acquiredQuantity;
    private int remainingCash;

    /**
     * Initializes the human bidder with the cash limit
     *
     * @param cash the cash limit
     */
    public void init(int cash) {
        this.acquiredQuantity = 0;
        this.remainingCash = cash;
    }

    public int getAcquiredQuantity() {
        return acquiredQuantity;
    }

    public void setAcquiredQuantity(int acquiredQuantity) {
        this.acquiredQuantity = acquiredQuantity;
    }

    public int getRemainingCash() {
        return remainingCash;
    }

    public void setRemainingCash(int remainingCash) {
        this.remainingCash = remainingCash;
    }

}
