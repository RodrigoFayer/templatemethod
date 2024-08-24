package org.example;

import java.time.LocalDateTime;

public abstract class Report {
    private String title;
    private LocalDateTime endDate;
    private LocalDateTime startDate;

    private String[] widgets;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public String[] getWidgets() {
        return widgets;
    }

    public void setWidgets(String[] widgets) {
        this.widgets = widgets;
    }

    public abstract String getData();

    public String generateReport() {
        return "Title: " + title + "\n" +
                "Start Date: " + startDate + "\n" +
                "End Date: " + endDate + "\n" +
                "Widgets: " + String.join(", ", this.getWidgets()) + "\n" +
                "Data: " + getData();
    }
}
