package bids;

import auction.BiddingStrategy;
import bidders.Bot;

/**
 * Represents the strategy that always bids zero.
 *
 * @author Catalin Cosma
 */
public class ZeroBid implements BiddingStrategy {

    /**
     * Always returns zero.
     *
     * @param bot a bot that represents the trading bot.
     * @return    the bid
     */
    @Override
    public int computeBid(Bot bot) {
        return 0;
    }
}
