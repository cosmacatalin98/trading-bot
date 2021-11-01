package bids;

import auction.Context;
import bidders.Bot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OneBidTest {

    @Test
    @DisplayName("Testing the returned amount by the one bid strategy")
    public void computeBid_ValidBot_One(){
        Bot bot = new Bot();
        bot.init(10, 20);
        Context context = new Context(new OneBid());
        Assertions.assertEquals(1,context.executeStrategy(bot));
    }

}