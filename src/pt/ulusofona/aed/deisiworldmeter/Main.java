package pt.ulusofona.aed.deisiworldmeter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Main {
    /* data storage lists */
    private static ArrayList<Country> listOfCountries = new ArrayList<>();
    private static ArrayList<City> listOfCities = new ArrayList<>();
    private static ArrayList<Population> listOfPopulations = new ArrayList<>();
    private static ArrayList<InvalidInput> listOfInvalidInputs = new ArrayList<>();

    /* methods */
    public static ArrayList getObjects(TipoEntidade type){
        return null;
    }

    public static boolean parseFiles(File folder) {
        if (folder == null || !folder.exists() || !folder.isDirectory()) {
            return false;
        }

        clearData();

        boolean countriesOk = parseCountriesFile(folder);
//        boolean citiesOk = parseCitiesFile(folder);
//        boolean populationsOk = parsePopulationsFile(folder);

        return countriesOk /* && citiesOk && populationsOk */;
    }

    /* auxiliary methods */
    private static boolean isValidCsvFile(File file) {
        /* validate that the file exists, that it's a file and that the format is correct */
        return file != null && file.exists() && file.isFile() && file.getName().endsWith(".csv");
    }

    private static void clearData() {
        /* delete values from all lists */
        listOfCountries.clear();
        listOfCities.clear();
        listOfPopulations.clear();
        listOfInvalidInputs.clear();
    }

    private static boolean parseCountriesFile(File folder) {
        /* get file */
        File file = new File(folder, "paises.csv");

        /* validate file */
        if (!isValidCsvFile(file)) {
            return false;
        }

        /* declare and initialize the variables */
        int correctLines = 0;
        int incorrectLines = 0;
        int firstIncorrectLine = -1;

        try {
            /* get all the lines from file */
            List<String> lines = Files.readAllLines(file.toPath());

            /* loop through each line of the file */
            for (int idx = 1; idx < lines.size(); idx++) { /* start on line 1 to ignore the header */
                /* get line */
                String line = lines.get(idx);
                /* get the number of the line - cause 'idx' is the index of the list and starts at 0 */
                int lineNumber = idx + 1;

                try {
                    /* create country */
                    Country country = getCountry(line);
                    /* add country in countries list */
                    listOfCountries.add(country);

                    /* increment the number of correct lines */
                    correctLines++;

                } catch (Exception e) {
                    /* increment the number of incorrect lines */
                    incorrectLines++;

                    /* save the number of the first incorrect line */
                    if (firstIncorrectLine == -1) {
                        firstIncorrectLine = lineNumber;
                    }
                }
            }

        } catch (IOException e) {
            return false;
        }

        /* add to the list of invalid inputs an invalid input object with the information taken from
         this file */
        listOfInvalidInputs.add(
                new InvalidInput("paises.csv", correctLines, incorrectLines, firstIncorrectLine)
        );

        return true;
    }

    private static Country getCountry(String line) {
        /* save line information - limit -1 is for Java don't ignore empty fields at the end and don't lose even empty fields */
        String[] parts = line.split(",", -1);

        /* validate the expected number of fields obtained */
        if (parts.length != 4) {
            throw new IllegalArgumentException("Número de campos inválido");
        }

        /* save information */
        int id = Integer.parseInt(parts[0].trim());
        String alpha2 = parts[1].trim();
        String alpha3 = parts[2].trim();
        String name = parts[3].trim();

        /* create a country object with the information */
        return new Country(id, alpha2, alpha3, name);
    }

//    private static boolean parseCitiesFile(File folder) { }

//    private static City getCity(String line){ }

//    private static boolean parsePopulationsFile(File folder) { }

//    private static Population getPopulation(String line){ }

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao DEISI World Meter");
    }
}