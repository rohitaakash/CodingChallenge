import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonGetFormat {

	public static void main(String[] args) throws IOException {
		
		String[] titles = getMovieTitles("black");
		
		for(String s: titles) {
			System.out.println(s);
		}

	}

	public static String[] getMovieTitles(String substr) throws IOException {

		String requestUrl = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr;
		URL url = new URL(requestUrl);
		StringBuilder response = new StringBuilder();	

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		
		while ((line = rd.readLine()) != null) {
			response.append(line);
		}

		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObject = jsonParser.parse(response.toString()).getAsJsonObject();
		
		JsonArray jsonArray =  jsonObject.get("data").getAsJsonArray();
		
		String[] res = new String[jsonArray.size()];
		for(int i=0; i < jsonArray.size(); i++) {
			JsonObject jObject = (JsonObject) jsonArray.get(i);
			String title = jObject.get("Title").getAsString();
			res[i] = title;
		}
		
		rd.close();
		return res;

	}
}
