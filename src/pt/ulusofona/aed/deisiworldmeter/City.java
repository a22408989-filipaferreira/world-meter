package pt.ulusofona.aed.deisiworldmeter;

public class City {
    /* attributes */
    private String alpha2;
    private String name;
    private int region;
    private int population;
    private double latitude;
    private double longitude;

    /* default builder */
    public City(){

    }

    /* builders */
    public City(String alpha2, String name, int region, int population, double latitude, double longitude){
        /* validate null fields */
        if (alpha2 == null) {
            throw new IllegalArgumentException("Alfa2 inválido");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }

        /* convert alpha field to uppercase */
        alpha2 = alpha2.toUpperCase();

        /* validate field in the specified format */
        if (!alpha2.matches("[A-Z]{2}")) {
            throw new IllegalArgumentException("Alfa2 inválido");
        }

        if (region < 0) {
            throw new IllegalArgumentException("Região inválida");
        }

        if (population < 0) {
            throw new IllegalArgumentException("População inválida");
        }

        if (latitude < -90 || latitude > 90){
            throw new IllegalArgumentException("Latitude inválida");
        }

        if (longitude < -180 || longitude > 180){
            throw new IllegalArgumentException("Longitude inválida");
        }

        /* create object */
        this.alpha2 = alpha2;
        this.name = name;
        this.region = region;
        this.population = population;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /* getters */
    public String getAlpha2(){
        return alpha2;
    }

    public String getName(){
        return name;
    }

    public int getRegion(){
        return region;
    }

    public int getPopulation(){
        return population;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    /* methods */
    @Override
    public String toString() {
        return name + " | " + alpha2 + " | " + region + " | " + population + " | (" + latitude + ", " + longitude + ")";
    }
}