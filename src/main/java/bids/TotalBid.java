package bids;

import auction.BiddingStrategy;
import bidders.Bot;

/**
 * Represents the strategy that bids all the remaining cash.
 *
 * @author Catalin Cosma
 */
public class TotalBid implements BiddingStrategy {

    /**
     * Bids all the remaining cash.
     *
     * @param bot a bot that represents the trading bot.
     * @return    the bid
     */
    @Override
    public int computeBid(Bot bot) {
        return bot.getRemainingCash();
    }
}
