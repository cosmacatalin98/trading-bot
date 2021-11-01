package bids;

import auction.BiddingStrategy;
import bidders.Bot;

/**
 * Represents the strategy based on the adversary's.
 *
 * @author Catalin Cosma
 */
public class AdversaryCashPlusOneBid implements BiddingStrategy {

    /**
     * Computes a bid equal to the adversary's remaining
     * cash plus one more unit.
     *
     * @param bot a bot that represents the trading bot.
     * @return    the bid
     */
    @Override
    public int computeBid(Bot bot) {
        return bot.getAdversaryCash() + 1;
    }
}
