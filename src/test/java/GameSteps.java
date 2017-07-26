/**
 * Created by Simeon on 7/25/2017.
 */

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.CoreMatchers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameSteps {
   // private Game _target;
    private String _actualResult;

    @Given("^I use \"([^\"]*)\" as a username$")
    public void I_use_a_user(String userName) {

        GetUserGameCollection getUGC = new GetUserGameCollection();
        getUGC.GetUserGameCollectionImpl(userName);

        ReadXMLUserGameCollection xmlUGC = new ReadXMLUserGameCollection();
        xmlUGC.ReadXMLUserGameCollectionImpl();

//    int intGameObjectId = objectid of game, based on Random number (1 - 1511) i.e. Game Collection of 'mkgray';
        int intGameObjectId = ReadXMLUserGameCollection.chosenGameObjectId;
        String strGameObjectId = String.valueOf(intGameObjectId);

        GetGameDetails gameDetail = new GetGameDetails();
        gameDetail.GetGameDetailsImpl(strGameObjectId);

        ReadXMLGameDetails xmlGameDetails = new ReadXMLGameDetails();
        xmlGameDetails.ReadXMLGameDetailsImpl();

    }

    @When("^I use \"([^\"]*)\" as a firefoxProfile$")
    public void the_number_is_played(String  firefoxProfile) {

        int intGameObjectId = ReadXMLUserGameCollection.chosenGameObjectId;
        String strGameObjectId = String.valueOf(intGameObjectId);

        WebScraperBGG scrape = new WebScraperBGG();
        scrape.WebScraperBGGImpl(strGameObjectId, firefoxProfile);
    }

    @Then("^I should be told the correct answer for language dependence text is result\"$")
    public void iShouldBeToldTheCorrectAnswerForLanguageDependenceTextIsResult() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String  expectedResult = ReadXMLGameDetails.currentMostVotedLD;
        assertThat(expectedResult, CoreMatchers.is(equalTo(WebScraperBGG.textLanguageDependence)));
    }

   @Then("^I should be told number of Games is number")
    public void iShouldBeToldNumberOfGamesIsNumber() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.printf("Number of Game for mkgray is: %d%n", ReadXMLUserGameCollection.numOfGames);
    }

    @Then("^I should be told chosen random number in Games is number(\\d+) and chosen ObjectId is number(\\d+)\"$")
    public void iShouldBeToldChosenRandomNumberInGamesIsNumberAndChosenObjectIdIsNumber(Integer chosenGameNum, Integer chosenGameObjectId) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        chosenGameNum = ReadXMLUserGameCollection.chosenGameNum;
        chosenGameObjectId = ReadXMLUserGameCollection.chosenGameObjectId;
        System.out.printf(String.format("Chosen Game Num is: %d and Chosen Game ObjectId is: %d%n", chosenGameNum, chosenGameObjectId));
    }

    @Then("^I should be told chosen name of Game is name\"$")
    public void iShouldBeToldChosenNameOfGameIsName() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String nameOfGame = ReadXMLGameDetails.nameOfGame;
        System.out.printf("Name of Chosen Game in User Collection is: %s%n", nameOfGame);
    }


    @Then("^I should be told Most Voted is Level num(\\d+) with Votes num(\\d+) and language dependency ld\"$")
    public void iShouldBeToldMostVotedIsLevelNumWithVotesNumAndLanguageDependencyLd(int keyMax, int valMax) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        keyMax = (Integer) ReadXMLGameDetails.entryWithMaxValue.getKey();
        valMax = (Integer) ReadXMLGameDetails.entryWithMaxValue.getValue();

        System.out.println();
        System.out.println("Most Voted is Level: " + keyMax + ", with votes: " + valMax + ", " +
                ReadXMLGameDetails.strMostVotedLD.get ( keyMax - 1 ) );
        ReadXMLGameDetails.currentMostVotedLD = ReadXMLGameDetails.strMostVotedLD.get ( keyMax - 1 );
        System.out.println();
    }


}
