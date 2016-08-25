package gov.samhsa.c2s.phr.service.dto;


import java.util.List;
import java.util.Map;

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
        this.currentPage = 	(int) pageResults.get("currentPage");
        this.itemsPerPage = 	(int) pageResults.get("itemsPerPage");
        this.totalPages = 	(int) pageResults.get("totalPages");
        this.totalItems = 	(long) pageResults.get("totalItems");
    }

    public List<PatientDto> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<PatientDto> patientList) {
        this.patientList = patientList;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
