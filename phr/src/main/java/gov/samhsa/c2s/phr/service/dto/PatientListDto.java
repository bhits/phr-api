package gov.samhsa.c2s.phr.service.dto;


import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class PatientListDto {
    private List<PatientDto> patientList;

    private long totalItems;

    private int totalPages;

    private int itemsPerPage;

    private int currentPage;

    public PatientListDto() {
    }

    public PatientListDto(List<PatientDto> patientList) {
        this.patientList = patientList;
    }

    @SuppressWarnings("unchecked")
    public PatientListDto(Map<String, Object> pageResults) {
        this.patientList = (List<PatientDto>) pageResults.get("results");
        this.currentPage = (int) pageResults.get("currentPage");
        this.itemsPerPage = (int) pageResults.get("itemsPerPage");
        this.totalPages = (int) pageResults.get("totalPages");
        this.totalItems = (long) pageResults.get("totalItems");
    }
}
