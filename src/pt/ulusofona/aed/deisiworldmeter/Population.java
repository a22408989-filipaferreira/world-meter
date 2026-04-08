package pt.ulusofona.aed.deisiworldmeter;

public class Population {
    /* attributes */
    private int id;
    private int year;
    private int malePopulation;
    private int femalePopulation;
    private double density;

    /* default builder */
    public Population(){

    }

    /* builders */
    public Population(int id, int year, int malePopulation, int femalePopulation, double density){
        /* validate fields in the specified format */
        if (id <= 0) {
            throw new IllegalArgumentException("Id inválido");
        }

        if (year < 1950 || year > 2100) {
            throw new IllegalArgumentException("Ano inválido");
        }

        if (malePopulation < 0 || femalePopulation < 0) {
            throw new IllegalArgumentException("População inválida");
        }

        if (density < 0) {
            throw new IllegalArgumentException("Densidade inválida");
        }

        /* create object */
        this.id = id;
        this.year = year;
        this.malePopulation = malePopulation;
        this.femalePopulation = femalePopulation;
        this.density = density;
    }

    /* getters */
    public int getId() {
        return id;
    }

    public int getYear(){
        return year;
    }

    public int getMalePopulation() {
        return malePopulation;
    }

    public int getFemalePopulation() {
        return femalePopulation;
    }

    public double getDensity() {
        return density;
    }

    /* methods */
}
