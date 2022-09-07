package sk.tsystems.coronastudio.database;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import sk.tsystems.coronastudio.entity.*;
import sk.tsystems.coronastudio.entity.hospitalBeds.SlovakiaHospitalBeds;
import sk.tsystems.coronastudio.service.*;
import sk.tsystems.coronastudio.service.hospitalBedsServices.SlovakiaHospitalBedsService;

import javax.transaction.Transactional;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Transactional
public class PlaygroundJPA {
    @Autowired
    private CitiesService citiesService;

    @Autowired
    private VaccinesService vaccinesService;

    @Autowired
    private RegionsService regionsService;

    @Autowired
    private DistrictsService districtsService;

    @Autowired
    private HospitalsService hospitalsService;

    @Autowired
    private SlovakiaHospitalBedsService slovakiaHospitalBedsService;

    private final String pattern = "yyyy-MM-dd HH:mm:ss";
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    private final String secondPattern = "yyyy-MM-dd";
    private final SimpleDateFormat secondSimpleDateFormat = new SimpleDateFormat(secondPattern);

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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static JSONObject readJsonObjectFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonText = readAll(rd);
            return new JSONObject(jsonText);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void updateVaccineTable() throws IOException, JSONException {
        JSONArray json = readJsonFromUrl("https://data.korona.gov.sk/api/vaccines");
        assert json != null;

        int id;
        String title;
        String manufacturer;


        for (int i = 0; i < json.length(); i++) {
            JSONObject codeObject = (JSONObject) json.get(i);
            id = (int) codeObject.get("id");
            title = (String) codeObject.get("title");
            manufacturer = (String) codeObject.get("manufacturer");


            try {
                vaccinesService.addVaccine(new Vaccines(id, title, manufacturer));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void updateRegionsTable() throws IOException, JSONException {
        JSONArray json = readJsonFromUrl("https://data.korona.gov.sk/api/regions");
        assert json != null;

        int id;
        String title;
        String code;
        String abbreviation;


        for (int i = 0; i < json.length(); i++) {
            JSONObject codeObject = (JSONObject) json.get(i);
            id = (int) codeObject.get("id");
            title = (String) codeObject.get("title");
            code = (String) codeObject.get("code");
            abbreviation = (String) codeObject.get("abbreviation");


            try {
                regionsService.addRegion(new Regions(id, title, code, abbreviation));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void updateDistrictsTable() throws IOException, JSONException {
        JSONArray json = readJsonFromUrl("https://data.korona.gov.sk/api/districts");
        assert json != null;

        int region_id;
        int id;
        String title;
        String code;

        List<Regions> regions = regionsService.getRegions();

        for (int i = 0; i < json.length(); i++) {
            JSONObject codeObject = (JSONObject) json.get(i);
            region_id = (int) codeObject.get("region_id");
            id = (int) codeObject.get("id");
            title = (String) codeObject.get("title");
            code = (String) codeObject.get("code");

            try {
                districtsService.addDistrict(new Districts(id, title, code, regions.get(region_id - 1)));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void updateCitiesTable() throws IOException, JSONException {
        JSONArray json = readJsonFromUrl("https://data.korona.gov.sk/api/cities");
        assert json != null;

        int district_id;
        int id;
        String title;
        String code;

        List<Districts> districts = districtsService.getDistricts();

        for (int i = 0; i < json.length(); i++) {
            JSONObject codeObject = (JSONObject) json.get(i);

            district_id = (int) codeObject.get("district_id");
            id = (int) codeObject.get("id");
            code = (String) codeObject.get("code");
            title = (String) codeObject.get("title");

            try {
                citiesService.addCity(new Cities(id, title, code, districts.get(district_id - 1)));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void updateHospitalsTable() throws IOException, JSONException {
        JSONArray json = readJsonFromUrl("https://data.korona.gov.sk/api/hospitals");
        assert json != null;

        int city_id;
        int id;
        String title;
        String code;

        List<Cities> cities = citiesService.getCities();

        for (int i = 0; i < json.length(); i++) {
            JSONObject codeObject = (JSONObject) json.get(i);

            city_id = (int) codeObject.get("city_id");
            id = (int) codeObject.get("id");
            code = (String) codeObject.get("code");
            title = (String) codeObject.get("title");

            try {
                hospitalsService.addHospital(new Hospitals(id, title, code, cities.get(city_id - 1)));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void updateSlovHosBedsTable() throws IOException, JSONException, ParseException {
        JSONObject page = readJsonObjectFromUrl("https://data.korona.gov.sk/api/hospital-beds/in-slovakia");
        JSONArray json = page.getJSONArray("page");
        assert json != null;

        for (int i = 0; i < json.length(); i++) {
            JSONObject codeObject = (JSONObject) json.get(i);

            Date oldest_reported_at = simpleDateFormat.parse(String.valueOf(codeObject.get("oldest_reported_at")));
            Date newest_reported_at = simpleDateFormat.parse(String.valueOf(codeObject.get("newest_reported_at")));
            Date published_on = secondSimpleDateFormat.parse(String.valueOf(codeObject.get("published_on")));
            long id = ((Number) codeObject.get("id")).longValue();
            int capacity_all = (int) codeObject.get("capacity_all");
            int free_all = (int) codeObject.get("free_all");
            int capacity_covid = (int) codeObject.get("capacity_covid");
            int occupied_jis_covid = (int) codeObject.get("occupied_jis_covid");
            int occupied_oaim_covid = (int) codeObject.get("occupied_oaim_covid");
            int occupied_o2_covid = (int) codeObject.get("occupied_o2_covid");
            int occupied_other_covid = (int) codeObject.get("occupied_other_covid");
            Date updated_at = simpleDateFormat.parse(String.valueOf(codeObject.get("updated_at")));
            ;

            try {
                slovakiaHospitalBedsService.addSlovHosBeds(new SlovakiaHospitalBeds(id, oldest_reported_at, newest_reported_at,
                        published_on, capacity_all, free_all, capacity_covid, occupied_jis_covid,
                        occupied_oaim_covid, occupied_o2_covid, occupied_other_covid, updated_at));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void play() throws JSONException, IOException, ParseException {
        slovakiaHospitalBedsService.reset();
        hospitalsService.reset();
        districtsService.reset();
        citiesService.reset();
        vaccinesService.reset();
        regionsService.reset();

        updateVaccineTable();
        updateRegionsTable();
        updateDistrictsTable();
        updateCitiesTable();
        updateHospitalsTable();
        updateSlovHosBedsTable();
    }
}
