package burger;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class ExchangeRate {
    static double rate = 1.0;
    public static double getRate(String currencyCode) throws Exception {
        try {
            // JSON url
            String theUrl = "https://openexchangerates.org/api/latest.json?app_id=ab4be49530ea47dbb13218e04a6d9b7c";

            URL url = new URL(theUrl);
            // reading stream
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            // let's parse the file
            JSONParser jsparser = new JSONParser();
            JSONObject myObject = (JSONObject) jsparser.parse(br);
            JSONObject rates = (JSONObject) myObject.get("rates");
            if (rates.get(currencyCode) == null) {
                System.out.println("bad");
            }
            rate = (double) rates.get(currencyCode);
        }
        // in case something happens (no country for example)
        catch (Exception e) {
            System.out.println("bad country");
            e.printStackTrace();
        }
        return rate;
    }

    public static void main(String[] args) {
        try {
            System.out.println(getRate("rr"));
        }
        catch (Exception e) {
            System.out.println("dfgohdifjgsgbdfhjskn");
        }
    }
}
