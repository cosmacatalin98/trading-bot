package bids;

import auction.Context;
import bidders.Bot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ZeroBidTest {

    @Test
    @DisplayName("Testing the returned amount by the zero bid strategy")
    public void computeBid_ValidBot_Zero(){
        Bot bot = new Bot();
        bot.init(10, 20);
        Context context = new Context(new ZeroBid());
        Assertions.assertEquals(0,context.executeStrategy(bot));
    }

}