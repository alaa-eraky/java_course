package Pyramid;

public class Pyramid {
    private double height;
    private String site;
    private String pharaoh;
    private String modern_name;

    public Pyramid() {
    }

    public Pyramid(double height, String site, String pharaoh, String modern_name) {
        this.height = height;
        this.site = site;
        this.pharaoh = pharaoh;
        this.modern_name = modern_name;
    }

    @Override
    public String toString() {
        return "\nPharaoh=" + getPharaoh() +
                " ::Modern_Name=" + getModern_name()
                + " ::Site=" + getSite() + " ::Height=" + getHeight();
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getPharaoh() {
        return pharaoh;
    }

    public void setPharaoh(String pharaoh) {
        this.pharaoh = pharaoh;
    }

    public String getModern_name() {
        return modern_name;
    }

    public void setModern_name(String modern_name) {
        this.modern_name = modern_name;
    }
}