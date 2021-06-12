package CitiesAndCounrties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {


    public static void main(String[] arg) throws IOException {
        String filePath = "F:\\AI iti\\Java\\city.csv";
        String filePath2 = "F:\\AI iti\\Java\\country.csv";
        CountryAndCities countryandcities = new CountryAndCities();
        List<City> cities = new ArrayList<>();
        List<Country> countries = new ArrayList<>();
        try {
            cities = countryandcities.readCityFromCsvFile(filePath);
            countries = countryandcities.readCountryFromCsvFile(filePath2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Map<String, List<City>> mappedCities = new HashMap<>();
        List<City> cityList = countryandcities.getCitiesWithCode(countries.get(4).getCode(),
                cities);
        cityList.sort(Comparator.comparing(City::getPopulation).reversed());
        mappedCities.put(countries.get(4).getCode(), cityList);
        for (var city : mappedCities.get(countries.get(4).getCode())) {
            System.out.println(city.getPopulation()
                    + ": " + city.getName()
                    + ": " + city.getCountry()
                    + ": " + city.getCode()
                    + ": " + city.getContinent()
                    + ":" + city.getSurface_area());
        }
    }
}
