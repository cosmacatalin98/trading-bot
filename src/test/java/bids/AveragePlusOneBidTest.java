package bids;

import auction.Context;
import bidders.Bot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

class AveragePlusOneBidTest {

    Bot bot;
    Random random;
    int average;
    ArrayList<Integer> adversaryBiddingHistory;

    @BeforeEach
    void setup() {
        bot = new Bot();
        random = new Random();
        average = 0;
        bot.init(10, 40);
        adversaryBiddingHistory = new ArrayList<>();
    }

    @Test
    @DisplayName("Testing the returned amount by the average plus one bid strategy for random bidding history")
    public void computeBid_RandomBidHistory_AveragePlusOne() {
        for (int i = 0; i < 10; i++) {
            adversaryBiddingHistory.add(random.nextInt(100));
        }
        bot.setAdversaryBiddingHistory(adversaryBiddingHistory);
        for (Integer i : adversaryBiddingHistory) {
            average = average + i;
        }
        average = Math.round((float) average / adversaryBiddingHistory.size()) + 1;
        Context context = new Context(new AveragePlusOneBid());
        int result = context.executeStrategy(bot);
        Assertions.assertEquals(average, result);
    }

    @Test
    @DisplayName("Testing the returned amount by the average plus one bid strategy for only one entry in the bidding history")
    public void computeBid_OneEntryBidHistory_AveragePlusOne() {
        adversaryBiddingHistory.add(random.nextInt(100));
        bot.setAdversaryBiddingHistory(adversaryBiddingHistory);
        for (Integer i : adversaryBiddingHistory) {
            average = average + i;
        }
        average = Math.round((float) average / adversaryBiddingHistory.size()) + 1;
        Context context = new Context(new AveragePlusOneBid());
        int result = context.executeStrategy(bot);
        Assertions.assertEquals(average, result);
    }

    @Test
    @DisplayName("Testing the returned amount by the average plus one bid strategy with no adversary bid history")
    public void computeBid_NoBidHistory_One() {
        bot.setAdversaryBiddingHistory(adversaryBiddingHistory);
        Context context = new Context(new AveragePlusOneBid());
        int result = context.executeStrategy(bot);
        Assertions.assertEquals(1, result);
    }


}