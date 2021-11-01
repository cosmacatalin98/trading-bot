package bids;

import auction.BiddingStrategy;
import bidders.Bot;

/**
 * Represents the strategy based on the adversary's average
 * bidding history.
 *
 * @author Catalin Cosma
 */
public class AveragePlusOneBid implements BiddingStrategy {
    /**
     * Computes a bid equal to the adversary's average bidding history
     * plus one more unit.
     *
     * @param bot a bot that represents the trading bot.
     * @return    the bid
     */
    @Override
    public int computeBid(Bot bot) {
        // Compute average
        int average = 0;
        for (Integer i : bot.getAdversaryBiddingHistory()) {
            average = average + i;
        }
        try {
            average = Math.round((float) average / bot.getAdversaryBiddingHistory().size()) + 1;
        } catch (Exception e) {
            return 1;
        }
        return average;
    }
}
