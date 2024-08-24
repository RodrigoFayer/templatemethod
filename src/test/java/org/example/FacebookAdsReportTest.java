package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FacebookAdsReportTest {
    @Test
    void shouldReturnFacebookAdsReportData() {
        FacebookAdsReport facebookAdsReport = new FacebookAdsReport();
        facebookAdsReport.setTitle("Facebook Ads Report");
        facebookAdsReport.setStartDate(LocalDateTime.now());
        facebookAdsReport.setEndDate(LocalDateTime.now().plusDays(1));
        facebookAdsReport.setWidgets(new String[]{"facebook_ads_widget1", "facebook_ads_widget2"});

        assertEquals("Facebook Ads report data", facebookAdsReport.getData());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenNoWidgetsProvided() {
        FacebookAdsReport facebookAdsReport = new FacebookAdsReport();
        facebookAdsReport.setTitle("Facebook Ads Report");
        facebookAdsReport.setStartDate(LocalDateTime.now());
        facebookAdsReport.setEndDate(LocalDateTime.now().plusDays(1));
        facebookAdsReport.setWidgets(new String[]{});

        IllegalArgumentException exception = org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, facebookAdsReport::getData);
        assertEquals("No widgets provided", exception.getMessage());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenNotAllWidgetsHaveTheKey() {
        FacebookAdsReport facebookAdsReport = new FacebookAdsReport();
        facebookAdsReport.setTitle("Facebook Ads Report");
        facebookAdsReport.setStartDate(LocalDateTime.now());
        facebookAdsReport.setEndDate(LocalDateTime.now().plusDays(1));
        facebookAdsReport.setWidgets(new String[]{"google_ads_widget1", "facebook_ads_widget2"});

        IllegalArgumentException exception = org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, facebookAdsReport::getData);
        assertEquals("Not all widgets have the key: facebook_ads", exception.getMessage());
    }

    @Test
    void shouldGenerateReport() {
        FacebookAdsReport facebookAdsReport = new FacebookAdsReport();
        facebookAdsReport.setTitle("Facebook Ads Report");
        facebookAdsReport.setStartDate(LocalDateTime.now());
        facebookAdsReport.setEndDate(LocalDateTime.now().plusDays(1));
        facebookAdsReport.setWidgets(new String[]{"facebook_ads_widget1", "facebook_ads_widget2"});

        String expected = "Title: Facebook Ads Report\n" +
                "Start Date: " + facebookAdsReport.getStartDate() + "\n" +
                "End Date: " + facebookAdsReport.getEndDate() + "\n" +
                "Widgets: facebook_ads_widget1, facebook_ads_widget2\n" +
                "Data: Facebook Ads report data";

        assertEquals(expected, facebookAdsReport.generateReport());
    }
}