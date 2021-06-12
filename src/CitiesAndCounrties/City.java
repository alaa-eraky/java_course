package CitiesAndCounrties;

public class City {
    private String name;
    private String country;
    private String code;
    private long population;
    private long surface_area;
    private String continent;

    public City() {
    }

    public City(String name, String country, String code, long population, long surface_area, String continent) {
        this.name = name;
        this.country = country;
        this.code = code;
        this.population = population;
        this.surface_area = surface_area;
        this.continent = continent;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public long getSurface_area() {
        return surface_area;
    }

    public void setSurface_area(long surface_area) {
        this.surface_area = surface_area;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
