package io.sunshower.webtests;

public class Location {
    final String url;
    public Location(String url) {
        this.url = url;
    }
    
    public String getUrl() {
        return url;
    }

    public String html(String index) {
        return String.format("%s/%s.html", url, index);
    }
}
