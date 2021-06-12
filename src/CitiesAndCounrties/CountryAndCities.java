package CitiesAndCounrties;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountryAndCities {
    public List<City> readCityFromCsvFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        Scanner scanner;
        String data;
        boolean isFirstLine = true;
        List<City> empList = new ArrayList<>();
        scanner = new Scanner(reader);
        scanner.useDelimiter(",");
        while (scanner.hasNextLine()) {
            data = scanner.nextLine();
            if (isFirstLine)
                isFirstLine = false;
            else
                empList.add(createCity(data));
        }
        scanner.close();
        return empList;
    }

    public City createCity(String metadata) {
        String[] data = metadata.split(",", -1);
        City city = new City();
        city.setName(data[0]);
        city.setCountry(data[1]);
        city.setCode(data[2]);
        city.setPopulation(Long.parseLong(data[3]));
        city.setSurface_area(Long.parseLong(data[4]));
        city.setContinent(data[5]);
        return city;
    }

    public List<Country> readCountryFromCsvFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        Scanner scanner;
        String data;
        boolean isFirstLine = true;
        List<Country> empList = new ArrayList<>();
        scanner = new Scanner(reader);
        scanner.useDelimiter(",");
        while (scanner.hasNextLine()) {
            data = scanner.nextLine();
            if (isFirstLine)
                isFirstLine = false;
            else
                empList.add(createCountry(data));
        }
        scanner.close();
        return empList;
    }

    public Country createCountry(String metadata) {
        String[] data = metadata.split(",", -1);
        Country country = new Country();
        country.setName(data[0]);
        country.setCode(data[1]);
        return country;
    }

    public List<City> getCitiesWithCode(String code, List<City> cities) {
        List<City> returnedList = new ArrayList<>();
        for (var city : cities) {
            if (city.getCode().equals(code)) {
                returnedList.add(city);
            }
        }
        return returnedList;
    }

}
