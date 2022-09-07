package sk.tsystem.coronastudio;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import sk.tsystem.coronastudio.entity.District;
import sk.tsystem.coronastudio.entity.Hospital;
import sk.tsystem.coronastudio.entity.Region;
import sk.tsystem.coronastudio.services.*;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.Format;
import java.util.Scanner;

@Transactional
public class PlaygroundJPA {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    @PersistenceContext
    private EntityManager entityManager;
//    @Autowired
//    CityService cityService;

    @Autowired
    HospitalService hospitalService;

    @Autowired
    RegionService regionService;

    @Autowired
    DistrictService districtService;
//
//
//    @Autowired
//    RegionService regionService;
//
//    @Autowired
//    DistrictHospitalBedService districtHospitalBedService;
//
//
//    @Autowired
//    SlovakiaHospitalBedService slovakiaHospitalBedService;


    private String urlRegion = "https://data.korona.gov.sk/api/regions";
    private String urlDistrict = "https://data.korona.gov.sk/api/districts";
    private String urlRegionHospitalBeds = "https://data.korona.gov.sk/api/hospitals-beds/by-region";
    private String urlCities = "https://data.korona.gov.sk/api/cities";
    private String urlDistrictHospitalBeds = "https://data.korona.gov.sk/api/hospitals-beds/by-district";
    private String urlHospitals = "https://data.korona.gov.sk/api/hospitals";
    private String urlHospitalBeds = "https://data.korona.gov.sk/api/hospitals-beds";
    private String urlSlovakiaHospitalBeds = "https://data.korona.gov.sk/api/hospital-beds/in-slovakia";
    private String urlVacinationContacs = "https://data.korona.gov.sk/api/vaccination/contacts";

    public void regionUpdateAPI() {
        try {
            URL url1 = new URL(urlRegion);
            HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
            conn1.setRequestMethod("GET");
            conn1.connect();
            int responseCode = conn1.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                StringBuilder informacionString = new StringBuilder();
                Scanner scanner = new Scanner(url1.openStream());

                while (scanner.hasNext()) {
                    informacionString.append(scanner.nextLine());
                }
                scanner.close();
                JSONParser parses = new JSONParser();
                JSONArray dataObject = (JSONArray) parses.parse(String.valueOf(informacionString));

                String code, title, abbreviation;
                long id;
                for (int i = 0; i < dataObject.size(); i++) {

                    JSONObject jSonData = (JSONObject) dataObject.get(i);
                    id = (long) jSonData.get("id");
                    code = (String) jSonData.get("code");
                    title = (String) jSonData.get("title");
                    abbreviation = (String) jSonData.get("abbreviation");

                    regionService.addRegion(new Region(id, title, code, abbreviation));
                    System.out.println(dataObject.get(i));
                }
            }
        } catch (Exception e) {

        }
    }

    public void districtUpdateAPI() {
        try {
            URL url2 = new URL(urlRegion);
            HttpURLConnection conn1 = (HttpURLConnection) url2.openConnection();
            conn1.setRequestMethod("GET");
            conn1.connect();
            int responseCode = conn1.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                StringBuilder informacionString = new StringBuilder();
                Scanner scanner = new Scanner(url2.openStream());

                while (scanner.hasNext()) {
                    informacionString.append(scanner.nextLine());
                }
                scanner.close();
                JSONParser parses = new JSONParser();
                JSONArray dataObject = (JSONArray) parses.parse(String.valueOf(informacionString));

                String code, title;
                long id,region_id;
                for (int i = 0; i < dataObject.size(); i++) {

                    JSONObject jSonData = (JSONObject) dataObject.get(i);
                    id = (long) jSonData.get("id");
                    code = (String) jSonData.get("code");
                    title = (String) jSonData.get("title");
                    region_id = (long) jSonData.get("region_id");

                    districtService.addDistricts(new District(id, title, code));

                }
            }
        } catch (Exception e) {

        }
    }


    public void update() {
        regionUpdateAPI();
        districtUpdateAPI();

//            try {
//
//                URL url2 = new URL(urlDistrict);
//                URL url3 = new URL(urlRegionHospitalBeds);
//                URL url4 = new URL(urlCities);
//                URL url5 = new URL(urlDistrictHospitalBeds);
//                URL url6 = new URL(urlHospitals);
//                URL url7 = new URL(urlHospitalBeds);
//                URL url8 = new URL(urlSlovakiaHospitalBeds);
//                URL url9 = new URL(urlVacinationContacs);
//
//
//                HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
//                HttpURLConnection conn3 = (HttpURLConnection) url3.openConnection();
//                HttpURLConnection conn4 = (HttpURLConnection) url4.openConnection();
//                HttpURLConnection conn5 = (HttpURLConnection) url5.openConnection();
//                HttpURLConnection conn6 = (HttpURLConnection) url6.openConnection();
//                HttpURLConnection conn7 = (HttpURLConnection) url7.openConnection();
//                HttpURLConnection conn8 = (HttpURLConnection) url8.openConnection();
//                HttpURLConnection conn9 = (HttpURLConnection) url9.openConnection();
//
//                conn1.setRequestMethod("GET");
//                conn1.connect();
//
//                int responseCode = conn1.getResponseCode();
//
//                if (responseCode != 200) {
//                    throw new RuntimeException("HttpResponseCode: " + responseCode);
//                } else {
//                    StringBuilder informacionString = new StringBuilder();
//                    Scanner scanner = new Scanner(url1.openStream());
//
//                    while (scanner.hasNext()) {
//                        informacionString.append(scanner.nextLine());
//                    }
//                    scanner.close();
//                    JSONParser parses = new JSONParser();
//                    JSONArray dataObject = (JSONArray) parses.parse(String.valueOf(informacionString));
//
//                    String code, title, abbreviation;
//                    long id;
//                    for (int i = 0; i < dataObject.size(); i++) {
//
//                        JSONObject jSonData = (JSONObject) dataObject.get(i);
//                        id = (long) jSonData.get("id");
//                        code = (String) jSonData.get("code");
//                        title = (String) jSonData.get("title");
//                        abbreviation = (String) jSonData.get("abbreviation");
//
//                        regionService.addRegion(new Region(id, title, code, abbreviation));
//                        System.out.println(dataObject.get(i));
//                    }
//
//
////                    System.out.println(dataObject.get(1));
//
//
//                    JSONObject jSonData = (JSONObject) dataObject.get(0);
//
//                    System.out.println(jSonData.get("code"));
//
//
//                }
//            } catch (Exception e) {
//
//            }
        }

        public void play() {
            update();
        }    }

