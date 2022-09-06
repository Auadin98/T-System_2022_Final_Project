package sk.tsystem.coronastudio;







import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import sk.tsystem.coronastudio.services.*;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@Transactional
public class PlaygroundJPA {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    CityService cityService;

    @Autowired
    HospitalService hospitalService;

    @Autowired
    DistrictService districtService;


    @Autowired
    RegionService regionService;

    @Autowired
    DistrictHospitalBedService districtHospitalBedService;


    @Autowired
    SlovakiaHospitalBedService slovakiaHospitalBedService;

    public static void main(String[] args) {
        try {
            URL url= new URL("https://data.korona.gov.sk/api/hospitals");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            if(responseCode !=200){
                throw new RuntimeException("HttpResponseCode: "+responseCode );}
            else {
                StringBuilder informacionString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while   (scanner.hasNext()){
                    informacionString.append(scanner.nextLine());
                }
                scanner.close();
                System.out.println(informacionString);

                JSONParser parses = new JSONParser();
                JSONArray dataObject = (JSONArray) parses.parse(String.valueOf(informacionString));

                System.out.println(dataObject.get(0));

                JSONObject countryData =(JSONObject) dataObject.get(0);

                System.out.println(countryData.get("location_type"));
            }
        }catch (Exception e){

        }
    }

//    private static String readAll(Reader rd) throws IOException {
//        StringBuilder sb = new StringBuilder();
//        int cp;
//        while ((cp = rd.read()) != -1) {
//            sb.append((char) cp);
//        }
//        return sb.toString();
//    }

//    public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
//        InputStream is = new URL(url).openStream();
//        try {
//            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
//            String jsonText = readAll(rd);
//            return new JSONArray(jsonText);
//        } catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }
//
//    public static void main(String[] args) throws IOException, JSONException {
//        JSONArray json = readJsonFromUrl("https://data.korona.gov.sk/api/cities");
//        assert json != null;
//        System.out.println(json.toString());
//    }



}

