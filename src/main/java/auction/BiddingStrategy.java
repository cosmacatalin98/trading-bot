package auction;

import bidders.Bot;

/**
 * Represents the bidding strategy used by the bot.
 * @author Catalin Cosma
 */
public interface BiddingStrategy {

    /**
     * Computes the amount for the bid.
     *
     * @param bot a bot that represents the trading bot.
     * @return    the amount used to place the bid
     */
    int computeBid(Bot bot);
}
