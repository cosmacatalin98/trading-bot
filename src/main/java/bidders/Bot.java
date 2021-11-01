package bidders;

import auction.Bidder;
import auction.Context;
import bids.*;

import java.util.ArrayList;

/**
 * Represents the logic used by the trading bot to make decisions.
 *
 * @author Catalin Cosma
 */
public class Bot implements Bidder {

    private int productQuantity;
    private int cashLimit;
    private int acquiredQuantity;
    private int remainingCash;
    private int adversaryCash;
    private ArrayList<Integer> adversaryBiddingHistory;

    /**
     * Initializes the bidder with the production quantity and the allowed cash limit.
     *
     * @param quantity the quantity
     * @param cash     the cash limit
     */
    @Override
    public void init(int quantity, int cash) {
        this.productQuantity = quantity;
        this.cashLimit = cash;
        this.acquiredQuantity = 0;
        this.remainingCash = cash;
        this.adversaryCash = cash;
        this.adversaryBiddingHistory = new ArrayList<>();
    }

    /**
     * Decides what strategy to use in order to compute the next bid.
     *
     * @return the next bid
     */
    @Override
    public int placeBid() {

        // Strategy context
        Context context;
        // Total possible rounds for the auction
        int totalRounds = this.productQuantity / 2;
        // The current round
        int currentRound = this.adversaryBiddingHistory.size() + 1;

        if (this.remainingCash == 0) { // If the bot doesn't have any cash left then the only possible bid is 0.
            context = new Context(new ZeroBid());
        } else if (this.adversaryCash == 0) { // If the adversary has no more cash left there is no point in bidding more than 1 MU.
            context = new Context(new OneBid());
        } else if (currentRound == 1) { // For the first round the bot will start with a proportional bid.
            context = new Context(new ProportionalBid());
        } else if (currentRound == totalRounds) { // For the last round the bot will bid the adversary's amount of cash plus 1.
            context = new Context(new AdversaryCashPlusOneBid());
        } else { // For the normal rounds the bot goes with the average plus one bid.
            context = new Context(new AveragePlusOneBid());
        }

        // Execute the strategy and
        int bid = context.executeStrategy(this);

        // If the amount returned by one of the strategies is greater than
        // the amount of remaining cash then the bot will go with a total bid.
        if (bid > this.getRemainingCash()) {
            context = new Context(new TotalBid());
            bid = context.executeStrategy(this);
        }

        // Subtract the amount of money for the bid.
        this.remainingCash = this.remainingCash - bid;

        return bid;
    }

    /**
     * Shows the bids of the two bidders.
     *
     * @param own   the bid of this bidder
     * @param other the bid of the other bidder
     */
    @Override
    public void bids(int own, int other) {
        this.adversaryBiddingHistory.add(other);
        this.adversaryCash = this.adversaryCash - other;
    }

    // Getters and setters
    public int getProductQuantity() {
        return productQuantity;
    }

    public int getCashLimit() {
        return cashLimit;
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

    public int getAdversaryCash() {
        return adversaryCash;
    }

    public void setAdversaryCash(int adversaryCash) {
        this.adversaryCash = adversaryCash;
    }

    public ArrayList<Integer> getAdversaryBiddingHistory() {
        return adversaryBiddingHistory;
    }

    public void setAdversaryBiddingHistory(ArrayList<Integer> adversaryBiddingHistory) {
        this.adversaryBiddingHistory = adversaryBiddingHistory;
    }
}
