/**
 * Created by Simeon on 7/24/2017.
 */
public class FourFinanceUserGames {

    public static void main(String[] argv) throws InterruptedException  {
        String userName = "mkgray";
        String firefoxProfile = "SimBin";

       // firefoxProfile = argv[0];
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

        WebScraperBGG scrape = new WebScraperBGG();
        scrape.WebScraperBGGImpl(strGameObjectId, firefoxProfile);
    }

}

