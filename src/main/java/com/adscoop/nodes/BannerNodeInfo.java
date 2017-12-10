package com.adscoop.nodes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@NodeEntity(label = "BannerNodeInfos")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BannerNodeInfo extends AbstratEntity {


    private BigDecimal longitude;

    private BigDecimal latitude;

    private String appVersion;
    private String appName;
    private String appCodeName;

    private String accuracy;

    private String campagin_name;

    private String userAgent;
    private int hardwareConcurrency;
    private boolean cookieEnabled;
    private String language;
    private String platform;


    @Relationship(type = "HAS_INFO", direction = Relationship.INCOMING)
    Set<Banner> banner;


    public BannerNodeInfo() {
        this.banner = new HashSet<>();

    }


    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppCodeName() {
        return appCodeName;
    }

    public void setAppCodeName(String appCodeName) {
        this.appCodeName = appCodeName;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public String getCampagin_name() {
        return campagin_name;
    }

    public void setCampagin_name(String campagin_name) {
        this.campagin_name = campagin_name;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public int getHardwareConcurrency() {
        return hardwareConcurrency;
    }

    public void setHardwareConcurrency(int hardwareConcurrency) {
        this.hardwareConcurrency = hardwareConcurrency;
    }

    public boolean isCookieEnabled() {
        return cookieEnabled;
    }

    public void setCookieEnabled(boolean cookieEnabled) {
        this.cookieEnabled = cookieEnabled;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }


}
