package nfs.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser {

    public InputParser() {}

    public ArrayList<String> parseInput(String inputLine) {
        return new ArrayList<String>(Arrays.asList(inputLine.split(" ")));
    }
}
