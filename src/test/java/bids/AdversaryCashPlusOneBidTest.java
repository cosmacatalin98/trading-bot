package bids;

import auction.Context;
import bidders.Bot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

class AdversaryCashPlusOneBidTest {

    Bot bot;
    Random random;

    @BeforeEach
    void setup() {
        bot = new Bot();
        random = new Random();
    }

    @Test
    @DisplayName("Testing the returned amount by the adversary cash plus one bid strategy for a random amount")
    public void computeBid_RandomAdversaryCash_AdversaryPlusOne() {
        int amount = random.nextInt(100);
        bot.setAdversaryCash(amount);
        Context context = new Context(new AdversaryCashPlusOneBid());
        int result = context.executeStrategy(bot);
        Assertions.assertEquals(amount + 1, result);
    }

    @Test
    @DisplayName("Testing the returned amount by the adversary cash plus one bid strategy for no amount of money")
    public void computeBid_ZeroCash_One() {
        bot.setAdversaryCash(0);
        Context context = new Context(new AdversaryCashPlusOneBid());
        int result = context.executeStrategy(bot);
        Assertions.assertEquals(1, result);
    }

}