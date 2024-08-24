package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GoogleAdsReportTest {
    @Test
    void shouldReturnGoogleAdsReportData() {
        GoogleAdsReport googleAdsReport = new GoogleAdsReport();
        googleAdsReport.setTitle("Google Ads Report");
        googleAdsReport.setStartDate(LocalDateTime.now());
        googleAdsReport.setEndDate(LocalDateTime.now().plusDays(1));
        googleAdsReport.setWidgets(new String[]{"google_ads_widget1", "google_ads_widget2"});

        assertEquals("Google Ads report data", googleAdsReport.getData());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenNoWidgetsProvided() {
        GoogleAdsReport googleAdsReport = new GoogleAdsReport();
        googleAdsReport.setTitle("Google Ads Report");
        googleAdsReport.setStartDate(LocalDateTime.now());
        googleAdsReport.setEndDate(LocalDateTime.now().plusDays(1));
        googleAdsReport.setWidgets(new String[]{});

        IllegalArgumentException exception = org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, googleAdsReport::getData);
        assertEquals("No widgets provided", exception.getMessage());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenNotAllWidgetsHaveTheKey() {
        GoogleAdsReport googleAdsReport = new GoogleAdsReport();
        googleAdsReport.setTitle("Google Ads Report");
        googleAdsReport.setStartDate(LocalDateTime.now());
        googleAdsReport.setEndDate(LocalDateTime.now().plusDays(1));
        googleAdsReport.setWidgets(new String[]{"google_ads_widget1", "facebook_ads_widget2"});

        IllegalArgumentException exception = org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, googleAdsReport::getData);
        assertEquals("Not all widgets have the key: google_ads", exception.getMessage());
    }

    @Test
    void shouldGenerateReport() {
        GoogleAdsReport googleAdsReport = new GoogleAdsReport();
        googleAdsReport.setTitle("Google Ads Report");
        googleAdsReport.setStartDate(LocalDateTime.now());
        googleAdsReport.setEndDate(LocalDateTime.now().plusDays(1));
        googleAdsReport.setWidgets(new String[]{"google_ads_widget1", "google_ads_widget2"});

        String expected = "Title: Google Ads Report\n" +
                "Start Date: " + googleAdsReport.getStartDate() + "\n" +
                "End Date: " + googleAdsReport.getEndDate() + "\n" +
                "Widgets: google_ads_widget1, google_ads_widget2\n" +
                "Data: Google Ads report data";

        assertEquals(expected, googleAdsReport.generateReport());
    }
}