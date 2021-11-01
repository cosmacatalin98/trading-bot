package auction;

import bidders.Bot;

/**
 * Represents the context for executing the suitable strategy.
 *
 * @author Catalin Cosma
 */
public class Context {

    /**
     * The strategy used to compute the bid amount.
     */
    private BiddingStrategy biddingStrategy;

    /**
     * Creates a new context with the specified strategy.
     *
     * @param biddingStrategy the strategy
     */
    public Context(BiddingStrategy biddingStrategy) {
        this.biddingStrategy = biddingStrategy;
    }

    /**
     * Executes the specified strategy by the context
     * based on the information stored in the bot object.
     *
     * @param bot the bot object holding the information
     * @return    the amount used to place the bid
     */
    public int executeStrategy(Bot bot) {
        return this.biddingStrategy.computeBid(bot);
    }

}
