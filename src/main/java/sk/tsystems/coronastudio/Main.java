package sk.tsystems.coronastudio;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Main {
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonText = readAll(rd);
            return new JSONArray(jsonText);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) throws IOException, JSONException {
        JSONArray json = readJsonFromUrl("https://data.korona.gov.sk/api/cities");
        assert json != null;
        System.out.println(json.toString());
    }
}
