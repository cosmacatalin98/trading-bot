package auction;

import bidders.Bot;
import bidders.Human;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Represents the main controller of the application that
 * provides the necessary logic for the auction.
 *
 * @author Catalin Cosma
 */
public class Controller {

    // Setup text fields
    @FXML
    private TextField productQuantityField;
    @FXML
    private TextField cashLimitField;
    @FXML
    private TextField remainingProductField;
    @FXML
    private TextField infoField;

    // User text fields
    @FXML
    private TextField acquiredProductField;
    @FXML
    private TextField remainingCashField;
    @FXML
    private TextField amountField;

    // Bot text fields
    @FXML
    private TextField adversaryProductField;
    @FXML
    private TextField adversaryCashField;
    @FXML
    private TextField adversaryBid;

    // Starting amount
    private int productQuantity;
    private int cashLimit;

    // Bidders
    private Human human;
    private Bot bot;

    /**
     * Displays a message in the GUI's Info area.
     *
     * @param message the message to be displayed
     */
    public void displayMessage(String message) {
        infoField.setText(message);
    }

    /**
     * Resets the scene text fields for multiple
     * consecutive auctions.
     */
    public void resetSceneInfo(){
        adversaryBid.setText("");
        amountField.setText("");
    }

    /**
     * Updates the GUI with the current values of each field.
     */
    public void refreshSceneInfo() {
        remainingProductField.setText(((Integer) productQuantity).toString());
        acquiredProductField.setText(((Integer) human.getAcquiredQuantity()).toString());
        remainingCashField.setText(((Integer) human.getRemainingCash()).toString());
        adversaryCashField.setText(((Integer) bot.getRemainingCash()).toString());
        adversaryProductField.setText(((Integer) bot.getAcquiredQuantity()).toString());
    }

    /**
     * Initializes the two bidders with the product quantity and the cash limit.
     */
    public void initializeBidders() {
        // Parsing the user input to integers.
        // We can safely parse the strings to integers since they were
        // checked by the input validators in the start auction method.
        productQuantity = Integer.parseInt(productQuantityField.getText());
        cashLimit = Integer.parseInt(cashLimitField.getText());

        // The first bidder - a human
        human = new Human();
        human.init(cashLimit);

        // The second bidder - a bot
        bot = new Bot();
        bot.init(productQuantity, cashLimit);
    }

    /**
     * Decides the winner/s for each round based on the placed bids by the two parties.
     *
     * @param firstBid  the first bid belonging to the user
     * @param secondBid the second bid belonging to teh bot
     */
    public void displayRoundResult(int firstBid, int secondBid) {
        if (firstBid > secondBid) { // Human wins
            human.setAcquiredQuantity(human.getAcquiredQuantity() + 2);
            displayMessage("YOU win 2 QU !");
        } else if (firstBid < secondBid) { // Bot wins
            bot.setAcquiredQuantity(bot.getAcquiredQuantity() + 2);
            displayMessage("BOT wins 2 QU !");
        } else { // Tie
            human.setAcquiredQuantity(human.getAcquiredQuantity() + 1);
            bot.setAcquiredQuantity(bot.getAcquiredQuantity() + 1);
            displayMessage("TIE - Both bidders win 1 QU !");
        }
    }

    /**
     * Decides the winner(or declares tie) for the auction based
     * on each other's acquired product quantity or remaining cash.
     */
    public void displayAuctionResult() {
        if (human.getAcquiredQuantity() > bot.getAcquiredQuantity()) {
            displayMessage("YOU win !");
        } else if (human.getAcquiredQuantity() < bot.getAcquiredQuantity()) {
            displayMessage("BOT wins !");
        } else if (human.getRemainingCash() > bot.getRemainingCash()) {
            displayMessage("YOU win !");
        } else if (human.getRemainingCash() < bot.getRemainingCash()) {
            displayMessage("BOT wins !");
        } else {
            displayMessage("TIE");
        }
    }

    /**
     * Gets triggered when the user presses the Start Auction button,
     * and it starts the auction process.
     */
    @FXML
    public void startAuction(Event event) {

        // Check for incorrect input
        String productQuantityMessage = InputValidators.checkProductQuantity(productQuantityField.getText());
        String cashLimitValMessage = InputValidators.checkCashLimit(cashLimitField.getText());

        // Don't start the auction unless the input provided by the user is correct
        // and give appropriate input error messages if it's not.
        if (!productQuantityMessage.equals("VALID")) {
            displayMessage(productQuantityMessage);
            productQuantityField.setText("");
        } else if (!cashLimitValMessage.equals("VALID")) {
            displayMessage(cashLimitValMessage);
            cashLimitField.setText("");
        } else {
            initializeBidders();
            resetSceneInfo();
            refreshSceneInfo();
            displayMessage("");
        }

        event.consume();
    }

    /**
     * Gets triggered by the Place bid button and
     * starts the current auction round
     */
    @FXML
    public void placeBid(Event event) {
        // If there is no more product left, then no more bidding can take place
        if (productQuantity == 0) {
            return;
        }
        // Human bid
        int userBid;
        String userBidMessage = InputValidators.checkUserBid(amountField.getText(), human.getRemainingCash());

        // Check the input provided by the user in the GUI
        if (userBidMessage.equals("VALID")) {
            userBid = Integer.parseInt(amountField.getText());
            human.setRemainingCash(human.getRemainingCash() - userBid);
        } else {
            displayMessage(userBidMessage);
            return;
        }

        // Bot bid
        int botBid = bot.placeBid();
        adversaryBid.setText(((Integer) botBid).toString());

        // Inform the bot about each other's bids
        bot.bids(botBid, userBid);

        // Display the round result
        displayRoundResult(userBid, botBid);

        // Decrease the product quantity
        productQuantity = productQuantity - 2;

        // If the quantity has been depleted then the auction stops and the winner is selected or tie is declared
        if (productQuantity == 0) {
            displayAuctionResult();
        }

        // Update the GUI with the latest values
        refreshSceneInfo();

        event.consume();
    }

}
