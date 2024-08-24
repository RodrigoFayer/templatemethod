package org.example;

import java.util.Arrays;

public class FacebookAdsReport extends Report{
    private final String key = "facebook_ads";
    public String getData() {
        boolean everyWidgetHasThisKey = Arrays.stream(this.getWidgets()).allMatch(widget -> widget.contains(this.key));

        if (this.getWidgets().length == 0) {
            throw new IllegalArgumentException("No widgets provided");
        }

        if (!everyWidgetHasThisKey) {
            throw new IllegalArgumentException("Not all widgets have the key: " + this.key);
        }

        return "Facebook Ads report data";
    }
}
