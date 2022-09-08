package sk.tsystems.coronastudio.database;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import sk.tsystems.coronastudio.entity.*;
import sk.tsystems.coronastudio.entity.hospitalBeds.DistrictHospitalBeds;
import sk.tsystems.coronastudio.entity.hospitalBeds.HospitalBeds;
import sk.tsystems.coronastudio.entity.hospitalBeds.RegionHospitalBeds;
import sk.tsystems.coronastudio.entity.hospitalBeds.SlovakiaHospitalBeds;
import sk.tsystems.coronastudio.entity.hospitalPatients.DistrictHospitalPatients;
import sk.tsystems.coronastudio.entity.hospitalPatients.HospitalPatients;
import sk.tsystems.coronastudio.entity.vaccinations.RegionVaccinations;
import sk.tsystems.coronastudio.entity.vaccinations.SlovakiaVaccinations;
import sk.tsystems.coronastudio.entity.vaccinations.VaccinationContacts;
import sk.tsystems.coronastudio.entity.vaccinations.Vaccinations;
import sk.tsystems.coronastudio.service.*;
import sk.tsystems.coronastudio.service.hospitalBedsServices.DistrictHospitalBedsService;
import sk.tsystems.coronastudio.service.hospitalBedsServices.HospitalBedsService;
import sk.tsystems.coronastudio.service.hospitalBedsServices.RegionHospitalBedsService;
import sk.tsystems.coronastudio.service.hospitalBedsServices.SlovakiaHospitalBedsService;
import sk.tsystems.coronastudio.service.hospitalPatientsServices.DistrictHospitalPatientsService;
import sk.tsystems.coronastudio.service.hospitalPatientsServices.HospitalPatientsService;
import sk.tsystems.coronastudio.service.vaccinationsServices.RegionVaccinationsService;
import sk.tsystems.coronastudio.service.vaccinationsServices.SlovakiaVaccinationsService;
import sk.tsystems.coronastudio.service.vaccinationsServices.VaccinationContactsService;
import sk.tsystems.coronastudio.service.vaccinationsServices.VaccinationsService;

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
    @Autowired
    private RegionHospitalBedsService regionHospitalBedsService;
    @Autowired
    private DistrictHospitalBedsService districtHospitalBedsService;
    @Autowired
    private HospitalBedsService hospitalBedsService;
    @Autowired
    private SlovakiaVaccinationsService slovakiaVaccinationsService;
    @Autowired
    private RegionVaccinationsService regionVaccinationsService;
    @Autowired
    private VaccinationsService vaccinationsService;
    @Autowired
    private VaccinationContactsService vaccinationContactsService;
    @Autowired
    private HospitalPatientsService hospitalPatientsService;
    @Autowired
    private DistrictHospitalPatientsService districtHospitalPatientsService;

    private final String pattern = "yyyy-MM-dd HH:mm:ss";
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    private final String secondPattern = "yyyy-MM-dd";
    private final SimpleDateFormat secondSimpleDateFormat = new SimpleDateFormat(secondPattern);

    private int hospitalID(int hospital_id){
        int hospitalID = 0;
        if(hospital_id >= 206){
            return hospitalID = hospital_id - 79;
        } else if (hospital_id >= 125 && hospital_id <=127) {
            return hospitalID = hospital_id - 1;
        } else return hospitalID = hospital_id;
    }
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

            try {
                slovakiaHospitalBedsService.addSlovHosBeds(new SlovakiaHospitalBeds(id, oldest_reported_at, newest_reported_at,
                        published_on, capacity_all, free_all, capacity_covid, occupied_jis_covid,
                        occupied_oaim_covid, occupied_o2_covid, occupied_other_covid, updated_at));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void updateRegHosBedsTable() throws IOException, JSONException, ParseException {
        JSONObject page = readJsonObjectFromUrl("https://data.korona.gov.sk/api/hospital-beds/by-region");
        JSONArray json = page.getJSONArray("page");
        assert json != null;

        List<Regions> regions = regionsService.getRegions();

        for (int i = 0; i < json.length(); i++) {
            JSONObject codeObject = (JSONObject) json.get(i);

            Date oldest_reported_at = simpleDateFormat.parse(String.valueOf(codeObject.get("oldest_reported_at")));
            Date newest_reported_at = simpleDateFormat.parse(String.valueOf(codeObject.get("newest_reported_at")));
            Date published_on = secondSimpleDateFormat.parse(String.valueOf(codeObject.get("published_on")));
            int region_id = (int) codeObject.get("region_id");
            long id = ((Number) codeObject.get("id")).longValue();
            int capacity_all = (int) codeObject.get("capacity_all");
            int free_all = (int) codeObject.get("free_all");
            int capacity_covid = (int) codeObject.get("capacity_covid");
            int occupied_jis_covid = (int) codeObject.get("occupied_jis_covid");
            int occupied_oaim_covid = (int) codeObject.get("occupied_oaim_covid");
            int occupied_o2_covid = (int) codeObject.get("occupied_o2_covid");
            int occupied_other_covid = (int) codeObject.get("occupied_other_covid");
            Date updated_at = simpleDateFormat.parse(String.valueOf(codeObject.get("updated_at")));

            try {
                regionHospitalBedsService.addRegHosBeds(new RegionHospitalBeds(id, oldest_reported_at, newest_reported_at,
                        published_on, regions.get(region_id - 1), capacity_all, free_all, capacity_covid,
                        occupied_jis_covid, occupied_oaim_covid, occupied_o2_covid, occupied_other_covid, updated_at));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void updateDistHosBedsTable() throws IOException, JSONException, ParseException {
        JSONObject page = readJsonObjectFromUrl("https://data.korona.gov.sk/api/hospital-beds/by-district");
        JSONArray json = page.getJSONArray("page");
        assert json != null;

        List<Districts> districts = districtsService.getDistricts();

        for (int i = 0; i < json.length(); i++) {
            JSONObject codeObject = (JSONObject) json.get(i);

            Date oldest_reported_at = simpleDateFormat.parse(String.valueOf(codeObject.get("oldest_reported_at")));
            Date newest_reported_at = simpleDateFormat.parse(String.valueOf(codeObject.get("newest_reported_at")));
            Date published_on = secondSimpleDateFormat.parse(String.valueOf(codeObject.get("published_on")));
            int district_id = (int) codeObject.get("district_id");
            long id = ((Number) codeObject.get("id")).longValue();
            int capacity_all = (int) codeObject.get("capacity_all");
            int free_all = (int) codeObject.get("free_all");
            int capacity_covid = (int) codeObject.get("capacity_covid");
            int occupied_jis_covid = (int) codeObject.get("occupied_jis_covid");
            int occupied_oaim_covid = (int) codeObject.get("occupied_oaim_covid");
            int occupied_o2_covid = (int) codeObject.get("occupied_o2_covid");
            int occupied_other_covid = (int) codeObject.get("occupied_other_covid");
            Date updated_at = simpleDateFormat.parse(String.valueOf(codeObject.get("updated_at")));

            try {
                districtHospitalBedsService.addDistHosBeds(new DistrictHospitalBeds(id, oldest_reported_at, newest_reported_at,
                        published_on, districts.get(district_id - 1), capacity_all, free_all, capacity_covid, occupied_jis_covid,
                        occupied_oaim_covid, occupied_o2_covid, occupied_other_covid, updated_at));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void updateHosBedsTable() throws IOException, JSONException, ParseException {
        JSONObject page = readJsonObjectFromUrl("https://data.korona.gov.sk/api/hospital-beds");
        JSONArray json = page.getJSONArray("page");
        assert json != null;

        List<Hospitals> hospitals = hospitalsService.getHospitals();

        for (int i = 0; i < json.length(); i++) {
            JSONObject codeObject = (JSONObject) json.get(i);

            Date reported_at = simpleDateFormat.parse(String.valueOf(codeObject.get("reported_at")));
            Date updated_at = simpleDateFormat.parse(String.valueOf(codeObject.get("updated_at")));
            Date published_on = secondSimpleDateFormat.parse(String.valueOf(codeObject.get("published_on")));
            int hospital_id = (int) codeObject.get("hospital_id");
            long id = ((Number) codeObject.get("id")).longValue();
            int capacity_all = (int) codeObject.get("capacity_all");
            int free_all = (int) codeObject.get("free_all");
            int capacity_covid = (int) codeObject.get("capacity_covid");
            int occupied_jis_covid = (int) codeObject.get("occupied_jis_covid");
            int occupied_oaim_covid = (int) codeObject.get("occupied_oaim_covid");
            int occupied_o2_covid = (int) codeObject.get("occupied_o2_covid");
            int occupied_other_covid = (int) codeObject.get("occupied_other_covid");

            try {
                hospitalBedsService.addHosBeds(new HospitalBeds(id, hospitals.get(hospitalID(hospital_id) - 1), reported_at,
                        updated_at, published_on, capacity_all, free_all, capacity_covid, occupied_jis_covid,
                        occupied_oaim_covid, occupied_o2_covid, occupied_other_covid));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void updateSlovakiaVaccinationsTable() throws IOException, JSONException, ParseException {
        JSONObject page = readJsonObjectFromUrl("https://data.korona.gov.sk/api/vaccinations/in-slovakia");
        JSONArray json = page.getJSONArray("page");
        assert json != null;

        for (int i = 0; i < json.length(); i++) {
            JSONObject codeObject = (JSONObject) json.get(i);

            long id = Integer.parseInt(String.valueOf(codeObject.get("id")));
            int dose1_count = (int) codeObject.get("dose1_count");
            int dose2_count = (int) codeObject.get("dose2_count");
            long dose1_sum = ((Number) codeObject.get("dose1_sum")).longValue();
            long dose2_sum = ((Number) codeObject.get("dose2_sum")).longValue();
            Date updated_at = simpleDateFormat.parse(String.valueOf(codeObject.get("updated_at")));
            Date published_on = secondSimpleDateFormat.parse(String.valueOf(codeObject.get("published_on")));

            try {
                slovakiaVaccinationsService.addSlovakiaVaccinations(new SlovakiaVaccinations(id, dose1_count, dose2_count,
                        dose1_sum, dose2_sum, updated_at, published_on));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void updateRegionVaccinationsTable() throws IOException, JSONException, ParseException {
        JSONObject page = readJsonObjectFromUrl("https://data.korona.gov.sk/api/vaccinations/by-region");
        JSONArray json = page.getJSONArray("page");
        assert json != null;


        List<Regions> regions = regionsService.getRegions();

        for (int i = 0; i < json.length(); i++) {
            JSONObject codeObject = (JSONObject) json.get(i);

            int region_id = (int) codeObject.get("region_id");
            long id = Long.parseLong(String.valueOf(codeObject.get("id")));
            int dose1_count = (int) codeObject.get("dose1_count");
            int dose2_count = (int) codeObject.get("dose2_count");
            long dose1_sum = ((Number) codeObject.get("dose1_sum")).longValue();
            long dose2_sum = ((Number) codeObject.get("dose2_sum")).longValue();
            Date updated_at = simpleDateFormat.parse(String.valueOf(codeObject.get("updated_at")));
            Date published_on = secondSimpleDateFormat.parse(String.valueOf(codeObject.get("published_on")));

            try {
                regionVaccinationsService.addRegionVaccinations(new RegionVaccinations(id, dose1_count, dose2_count,
                        dose1_sum, dose2_sum, updated_at, published_on, regions.get(region_id - 1)));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void updateVaccinationsTable() throws IOException, JSONException, ParseException {
        JSONObject page = readJsonObjectFromUrl("https://data.korona.gov.sk/api/vaccinations");
        JSONArray json = page.getJSONArray("page");
        assert json != null;

        List<Vaccines> vaccines = vaccinesService.getVaccines();
        List<Regions> regions = regionsService.getRegions();

        for (int i = 0; i < json.length(); i++) {
            JSONObject codeObject = (JSONObject) json.get(i);

            int region_id = (int) codeObject.get("region_id");
            int vaccine_id = (int) codeObject.get("vaccine_id");
            String id = String.valueOf(codeObject.get("id"));
            int dose1_count = (int) codeObject.get("dose1_count");
            int dose2_count = (int) codeObject.get("dose2_count");
            Date updated_at = simpleDateFormat.parse(String.valueOf(codeObject.get("updated_at")));
            Date published_on = secondSimpleDateFormat.parse(String.valueOf(codeObject.get("published_on")));

            try {
                vaccinationsService.addVaccinations(new Vaccinations(id, dose1_count, dose2_count, updated_at,
                        published_on, vaccines.get(vaccine_id - 2), regions.get(region_id - 1)));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void updateVaccinationContactsTable() throws IOException, JSONException, ParseException {
        JSONObject page = readJsonObjectFromUrl("https://data.korona.gov.sk/api/vaccination/contacts");
        JSONArray json = page.getJSONArray("page");
        assert json != null;

        List<Hospitals> hospitals = hospitalsService.getHospitals();


        for (int i = 0; i < json.length(); i++) {
            JSONObject codeObject = (JSONObject) json.get(i);

            int hospital_id = (int) codeObject.get("hospital_id");
            String substitutes_phones = codeObject.get("substitutes_phones").toString();
            String substitutes_emails = codeObject.get("substitutes_emails").toString();
            String substitutes_link = String.valueOf(codeObject.get("substitutes_link"));
            String substitutes_note = String.valueOf(codeObject.get("substitutes_note"));
            Boolean is_accepting_new_registrations = (Boolean) codeObject.get("is_accepting_new_registrations");
            Date updated_at = simpleDateFormat.parse(String.valueOf(codeObject.get("updated_at")));

            try {
                vaccinationContactsService.addVaccinationContacts(new VaccinationContacts(hospitals.get(hospitalID(hospital_id) - 1),
                        substitutes_phones, substitutes_emails, substitutes_link,
                        substitutes_note, is_accepting_new_registrations, updated_at));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void updateHospitalPatientsTable() throws IOException, JSONException, ParseException {
        JSONObject page = readJsonObjectFromUrl("https://data.korona.gov.sk/api/hospital-patients");
        JSONArray json = page.getJSONArray("page");
        assert json != null;

        List<Hospitals> hospitals = hospitalsService.getHospitals();

        for (int i = 0; i < json.length(); i++) {
            JSONObject codeObject = (JSONObject) json.get(i);

            int hospital_id = (int) codeObject.get("hospital_id");
            long id = ((Number) codeObject.get("id")).longValue();
            Date reported_at = simpleDateFormat.parse(String.valueOf(codeObject.get("reported_at")));
            int ventilated_covid = (int) codeObject.get("ventilated_covid");
            int non_covid = (int) codeObject.get("non_covid");
            int confirmed_covid = (int) codeObject.get("confirmed_covid");
            int suspected_covid = (int) codeObject.get("suspected_covid");
            Date updated_at = simpleDateFormat.parse(String.valueOf(codeObject.get("updated_at")));
            Date published_on = secondSimpleDateFormat.parse(String.valueOf(codeObject.get("published_on")));

            try {
                hospitalPatientsService.addHospitalPatients(new HospitalPatients(id, hospitals.get(hospitalID(hospital_id) - 1),
                        reported_at, ventilated_covid, non_covid, confirmed_covid, suspected_covid, updated_at, published_on));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void updateDistrictHospitalPatientsTable() throws IOException, JSONException, ParseException {
        JSONObject page = readJsonObjectFromUrl("https://data.korona.gov.sk/api/hospital-patients/by-district");
        JSONArray json = page.getJSONArray("page");
        assert json != null;

        List<Districts> districts = districtsService.getDistricts();

        for (int i = 0; i < json.length(); i++) {
            JSONObject codeObject = (JSONObject) json.get(i);
            int district_id = (int) codeObject.get("district_id");
            long id = ((Number) codeObject.get("id")).longValue();
            Date oldest_reported_at = simpleDateFormat.parse(String.valueOf(codeObject.get("oldest_reported_at")));
            Date newest_reported_at = simpleDateFormat.parse(String.valueOf(codeObject.get("newest_reported_at")));
            int ventilated_covid = (int) codeObject.get("ventilated_covid");
            int non_covid = (int) codeObject.get("non_covid");
            int confirmed_covid = (int) codeObject.get("confirmed_covid");
            int suspected_covid = (int) codeObject.get("suspected_covid");
            Date updated_at = simpleDateFormat.parse(String.valueOf(codeObject.get("updated_at")));
            Date published_on = secondSimpleDateFormat.parse(String.valueOf(codeObject.get("published_on")));

            try {
                districtHospitalPatientsService.addDistrictHospitalPatients(new DistrictHospitalPatients(id,
                        oldest_reported_at, newest_reported_at, published_on, districts.get(district_id - 1),
                        ventilated_covid, non_covid, confirmed_covid, suspected_covid, updated_at));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void play() throws JSONException, IOException, ParseException {
//        hospitalPatientsService.reset();
//        districtHospitalPatientsService.reset();
//        hospitalBedsService.reset();
//        vaccinationContactsService.reset();
//        districtHospitalBedsService.reset();
//        vaccinationsService.reset();
//        regionHospitalBedsService.reset();
//        regionVaccinationsService.reset();
//        slovakiaHospitalBedsService.reset();
//        slovakiaVaccinationsService.reset();
//        hospitalsService.reset();
//        citiesService.reset();
//        districtsService.reset();
//        vaccinesService.reset();
//        regionsService.reset();
//
//        updateVaccineTable();
//        updateRegionsTable();
//        updateDistrictsTable();
//        updateCitiesTable();
//        updateHospitalsTable();
//        updateSlovHosBedsTable();
//        updateRegHosBedsTable();
//        updateDistHosBedsTable();
//        updateHosBedsTable();
//        updateSlovakiaVaccinationsTable();
//        updateRegionVaccinationsTable();
//        updateVaccinationsTable();
//        updateVaccinationContactsTable();
//        updateHospitalPatientsTable();
//        updateDistrictHospitalPatientsTable();
    }
}
