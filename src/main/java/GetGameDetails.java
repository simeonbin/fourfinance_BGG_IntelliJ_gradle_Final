/**
 * Created by Simeon on 7/24/2017.
 */

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class GetGameDetails {

    // http://localhost:8080/RESTfulExample/json/product/get
    //https://www.boardgamegeek.com/xmlapi/collection/mkgray

    public void GetGameDetailsImpl(String gameObjectId) {
        String boardgameURL = "https://www.boardgamegeek.com/xmlapi/boardgame/";

        try {

            URL url = new URL(boardgameURL + gameObjectId);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/xml");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");

            FileWriter writer = new FileWriter("gamedetails.xml");
            try(PrintWriter printWriter = new PrintWriter(writer)){

                while ((output = br.readLine()) != null) {
                    //        System.out.println(output);

                    printWriter.println(output);
                }
            }
            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        int intGameObjectId = 7865;
        String strGameObjectId = String.valueOf(intGameObjectId);
        GetGameDetails gameDetail = new GetGameDetails();
        gameDetail.GetGameDetailsImpl(strGameObjectId);

    }

}


