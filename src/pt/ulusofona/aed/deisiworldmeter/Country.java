package pt.ulusofona.aed.deisiworldmeter;

public class Country {
    /* attributes */
    private int id;
    private String alpha2;
    private String alpha3;
    private String name;

    /* default builder */
    public Country(){

    }

    /* builders */
    public Country(int id, String alpha2, String alpha3, String name){
        /* validate null fields */
        if (alpha2 == null) {
            throw new IllegalArgumentException("Alfa2 inválido");
        }

        if (alpha3 == null) {
            throw new IllegalArgumentException("Alfa3 inválido");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }

        /* convert alpha fields to uppercase */
        alpha2 = alpha2.toUpperCase();
        alpha3 = alpha3.toUpperCase();

        /* validate alpha fields in the specified format */
        if (!alpha2.matches("[A-Z]{2}")) {
            throw new IllegalArgumentException("Alfa2 inválido");
        }

        if (!alpha3.matches("[A-Z]{3}")) {
            throw new IllegalArgumentException("Alfa3 inválido");
        }

        if (id <= 0) {
            throw new IllegalArgumentException("Id inválido");
        }

        /* create object */
        this.id = id;
        this.alpha2 = alpha2;
        this.alpha3 = alpha3;
        this.name = name;
    }

    /* getters */
    public int getId(){
        return id;
    }

    public String getAlpha2(){
        return alpha2;
    }

    public String getAlpha3(){
        return alpha3;
    }

    public String getName(){
        return name;
    }

    /* methods */
    @Override
    public String toString() {
        return name + " | " + id + " | " + alpha2 + " | " + alpha3;
    }
}
