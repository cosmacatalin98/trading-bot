package bids;

import auction.BiddingStrategy;
import bidders.Bot;

/**
 * Represents the strategy that always bids one unit.
 *
 * @author Catalin Cosma
 */
public class OneBid implements BiddingStrategy {
    /**
     * Always returns one unit.
     *
     * @param bot a bot that represents the trading bot.
     * @return    the bid
     */
    @Override
    public int computeBid(Bot bot) {
        return 1;
    }
}
