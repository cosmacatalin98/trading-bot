package bids;

import auction.BiddingStrategy;
import bidders.Bot;

import java.util.Random;

/**
 * Represents the strategy based on the proportion between
 * the product quantity and the cash limit
 *
 * @author Catalin Cosma
 */
public class ProportionalBid implements BiddingStrategy {

    /**
     * Computes a bid equal to the proportion between the product quantity
     * and the cash limit plus a random number rom 0 to half of the proportional
     * amount to avoid predictability.
     *
     * @param bot a bot that represents the trading bot.
     * @return    the bid
     */
    @Override
    public int computeBid(Bot bot) {
        // Create a new random instance
        Random random = new Random();

        // Compute the proportion (cash limit / product quantity) and multiply by
        // 2 since there are 2 quantity units auction every round
        int proportion = bot.getCashLimit() / bot.getProductQuantity() * 2;

        // If the proportion is lower than 2 (ex: cash limit < product quantity)
        // then return 1.
        if (proportion < 2) {
            return 1;
        } else {
            return proportion + random.nextInt(proportion / 2);
        }
    }
}
