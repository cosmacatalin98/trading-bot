package bids;

import auction.Context;
import bidders.Bot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProportionalBidTest {

    Bot bot;

    @BeforeEach
    void setup() {
        bot = new Bot();
    }

    @Test
    @DisplayName("Testing the returned amount by the proportional bid strategy for a valid proportional ratio")
    public void computeBid_ValidProportionRatio_ProportionalValue() {
        bot.init(10, 40);
        Context context = new Context(new ProportionalBid());
        int result = context.executeStrategy(bot);
        Assertions.assertTrue(result <= 12 && result >= 8);
    }

    @Test
    @DisplayName("Testing the returned amount by the proportional bid strategy for an invalid proportional ratio")
    public void computeBid_InvalidProportionRatio_One() {
        bot.init(40, 10);
        Context context = new Context(new ProportionalBid());
        Assertions.assertEquals(1, context.executeStrategy(bot));
    }
}