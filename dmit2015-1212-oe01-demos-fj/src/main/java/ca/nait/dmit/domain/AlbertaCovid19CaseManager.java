package ca.nait.dmit.domain;

import lombok.Getter;

import javax.swing.text.DateFormatter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AlbertaCovid19CaseManager {

    @Getter
    private List<AlbertaCovid19Case> albertaCovid19CaseList = new ArrayList<>();

    // Generate Constructor (ALT + INS)
    public AlbertaCovid19CaseManager() throws IOException {
        // Open the file for reading using Java API
        try(var reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/data/covid-19-alberta-statistics-data.csv")))) {
            String lineText;
            // Delimiter character
            // Declare a delimeter that looks for a comma inside a value
            // final is like const in C#, it cannot change
            final var DELIMETER = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

            // We can skip the first line since its contains header columns
            reader.readLine();

            // Dates can be written in different ways
            var dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            while ((lineText = reader.readLine()) != null) {
                // Create an object for each row in the file
                AlbertaCovid19Case currentCase = new AlbertaCovid19Case();
                // The -1 limit allows for any number of fields and not discard empty fields
                String[] values = lineText.split(DELIMETER, -1);
                // The order of the data is important
                // 0 - Id
                // 1 - Date reported
                // 2 - Alberta Health Services Zone
                // 3 - Gender
                // 4 - Age Group
                // 5 - Case status
                // 6 - Case type

                // .replaceAll removes the "", which was giving an error when testing for the count / size
                currentCase.setId(Integer.parseInt(values[0].replaceAll("\"", "")));
                currentCase.setDateReported(LocalDate.parse(values[1].replaceAll("\"", ""), dateTimeFormatter));
                currentCase.setAhsZone(values[2].replaceAll("\"", ""));
                currentCase.setGender(values[3].replaceAll("\"", ""));
                currentCase.setAgeGroup(values[4].replaceAll("\"", ""));
                currentCase.setCaseStatus(values[5].replaceAll("\"", ""));
                currentCase.setCaseType(values[6].replaceAll("\"", ""));

                // Add the object to the list
                albertaCovid19CaseList.add(currentCase);
            }
        }
    }

    public List<String> findDistinctAhsZone() {
        return albertaCovid19CaseList
                .stream()
                .map(AlbertaCovid19Case::getAhsZone)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
