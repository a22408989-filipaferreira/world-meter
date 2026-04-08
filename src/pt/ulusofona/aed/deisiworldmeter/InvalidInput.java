package pt.ulusofona.aed.deisiworldmeter;

public class InvalidInput {
    /* attributes */
    private String fileName;
    private int numCorrectLines;
    private int numIncorrectLines;
    private int firstIncorrectLine;

    /* default builder */
    public InvalidInput(){

    }

    /* builders */
    public InvalidInput(String fileName, int numCorrectLines, int numIncorrectLines, int firstIncorrectLine){
        /* create object */
        this.fileName = fileName;
        this.numCorrectLines = numCorrectLines;
        this.numIncorrectLines = numIncorrectLines;
        this.firstIncorrectLine = firstIncorrectLine;
    }

    /* getters */
    public String getFileName() {
        return fileName;
    }

    public int getNumCorrectLines(){
        return numCorrectLines;
    }

    public int getNumIncorrectLines(){
        return numIncorrectLines;
    }

    public int getFirstIncorrectLine(){
        return firstIncorrectLine;
    }

    /* methods */
    @Override
    public String toString() {
        return fileName + ".csv | " + numCorrectLines + " | " +
                numIncorrectLines + " | " + firstIncorrectLine;
    }
}
