package bids;

import auction.Context;
import bidders.Bot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TotalBidTest {

    @Test
    @DisplayName("Testing the returned amount by the total bid strategy")
    public void computeBid_ValidBot_TotalRemainingCash(){
        Bot bot = new Bot();
        bot.init(10, 20);
        Context context = new Context(new TotalBid());
        Assertions.assertEquals(20,context.executeStrategy(bot));
    }
}