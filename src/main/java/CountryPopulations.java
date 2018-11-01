import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class CountryPopulations {

    public static void main(String[] args) throws Exception {
        System.out.println(getCountries("un", 100090));
    }

    private static int getCountries(String s, int p) throws Exception {
        String baseUrl = "https://jsonmock.hackerrank.com/api/countries/search?name=";
        String requestUrl = baseUrl + s;
        URL url = new URL(requestUrl);
        int count = 0;

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        StringBuilder response = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            response.append(line);
        }

        JSONParser jsonParser = new JSONParser();
        JSONObject baseObject = (JSONObject) jsonParser.parse(response.toString());
        int totalPages = Integer.parseInt(baseObject.get("total_pages").toString());

        rd.close();
        conn.disconnect();

        for (int j = 0; j < totalPages; j++) {
            String pageRequesUrl = requestUrl + "&page=" + (j + 1);
            URL pageURL = new URL(pageRequesUrl);

            HttpURLConnection connection = (HttpURLConnection) pageURL.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuilder pageResponse = new StringBuilder();
            String pageLine;
            while ((pageLine = br.readLine()) != null) {
                pageResponse.append(pageLine);
            }
            System.out.println(pageResponse.toString());

            JSONObject pageObject = (JSONObject) jsonParser.parse(pageResponse.toString());
            JSONArray dataArray = (JSONArray) pageObject.get("data");
            for (int i = 0; i < dataArray.size(); i++) {
                JSONObject countryDetail = (JSONObject) dataArray.get(i);
                if (Integer.parseInt(countryDetail.get("population").toString()) > p)
                    count++;
            }

            br.close();
            connection.disconnect();
        }
        return count;
    }
}
