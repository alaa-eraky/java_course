package CitiesAndCounrties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {


    public static void main(String[] arg) throws IOException {
        String filePath = "src/CitiesAndCountries/city.csv";
        String filePath2 = "src/CitiesAndCountries/country.csv";
        CountryAndCities countryandcities = new CountryAndCities();
        List<City> cities = new ArrayList<>();
        List<Country> countries = new ArrayList<>();
        try {
            cities = countryandcities.readCityFromCsvFile(filePath);
            countries = countryandcities.readCountryFromCsvFile(filePath2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (var country : countries) {
            Map<String, List<City>> mappedCities = new HashMap<>();
            List<City> cityList = countryandcities.getCitiesWithCode(country.getCode(), cities);
            cityList.sort(Comparator.comparing(City::getPopulation));
            mappedCities.put(country.getCode(), cityList);
            for (var city : mappedCities.get(country.getCode())) {
                System.out.println(city.getPopulation()
                        + ": " + city.getName()
                        + ": " + city.getCountry()
                        + ": " + city.getCode()
                        + ": " + city.getContinent()
                        + ":" + city.getSurface_area());
            }
            Optional<City> highestPopCity = cityList.stream().max(Comparator.comparing(City::getPopulation));
            System.out.println("Maximum population city in the country is : " + highestPopCity.get().getName());
            System.out.println("===========================================================");
        }
       
    }}