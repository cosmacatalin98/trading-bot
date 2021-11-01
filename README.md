# Trading bot
## Task
GENERAL INFO | QU = quantity units MU = monetary units

EXPLANATION | A product x QU will be auctioned under 2 parties.
The parties have each y MU for auction. They then offer an arbitrary number simultaneously of its MU on
the first 2 QU of the product. After that, the bids will be visible to both.
The 2 QU of the product is awarded to who has offered the most MU; if both bid the same, then both get 1
QU. Both bidders must pay their amount - including the defeated. A bid of 0 MU is allowed. Bidding on each
2 QU is repeated until the supply of x QU is fully auctioned.

THESIS | Each bidder aims to get a larger amount than its competitor.
In an auction, the program that is able to get more QU than the other wins. In case of a tie, the program that
retains more MU wins.

TASK | Your task is to write a program that can participate in this auction and competes with one of our programs.
Please explain its strategy.

## Solution

The task was regarded as a whole project designed to be used by a user who can start an auction and bid against the trading bot. 

<p align="center">
  <img src="https://github.com/cosmacatalin98/trading-bot/blob/master/trading_bot_gui.png?raw=true"/>
</p>

The project was designed using the MVC design pattern where the Model represents the logic used by the trading bot, the View represents the GUI presented to the user and the Controller represents the link between the Model and the View.

## Implementation
### Technologies 

IDEA : IntelliJ IDEA

Programming language : Java 11

Project build system : Maven

GUI library : JavaFX

Test framework : JUnit 

### Strategy
The trading logic for the bot can be found in the Bot class in the placeBid( ) method. The strategy design pattern was used to implement different ways of computing the value of the bid.

There are six ways of computing the bid :

1. ZeroBid – Returns 0 MU. It is used when the bot has no more money

2. Onebid – Returns 1 MU. It is used when the adversary has no more money so there is no point in bidding more than 1 MU.

3. ProportionalBid – Returns a proportional amount of MU based on the formula : ( cash limit / product quantity) * 2 + R, where R is a random number between 0 and (( cash limit / product quantity) / 2) . It is used only in the first round of the auction so the starting amount is not completely random. The R added to the proportion is used to avoid predictability in multiple consecutive auctions.

4. AdversaryCashPlusOneBid – Returns the amount of adversary cash plus one MU. It is used only in the last round in order to guarantee the win and only if the adversary still has more than 0 MU.

5. AveragePlusOneBid – Returns the average amount based on the adversary's bidding history plus 1 MU in an attempt to outbid them. It is used for the majority of the normal rounds.

6. TotalBid – Returns the total amount of MU owned by the bot. It is used if all the above strategies return a higher number of money than the amount owned in the current round.  


