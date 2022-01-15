package ca.nait.dmit.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AlbertaCovid19Case {
    // Defining data fields
    private int id;
    private LocalDate dateReported;
    private String ahsZone;
    private String gender;
    private String ageGroup;
    private String caseStatus;
    private String caseType;
}
