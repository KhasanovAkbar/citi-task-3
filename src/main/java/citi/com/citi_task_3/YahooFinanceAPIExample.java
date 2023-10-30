package citi.com.citi_task_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class YahooFinanceAPIExample {
    public static void main(String[] args) {
        try {
            String apiKey = "653fbc40e128e0.15684005";
            String symbol = "^DJI"; // Dow Jones Industrial Average

            String apiUrl = "https://apidojo-yahoo-finance-v1.p.rapidapi.com/market/get-quotes?region=US&lang=en&symbols=" + symbol;

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com");
            connection.setRequestProperty("x-rapidapi-key", apiKey);

            int responseCode = connection.getResponseCode();

            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();
                System.out.println(response);
            } else {
                System.out.println("Error: Unable to fetch data.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

