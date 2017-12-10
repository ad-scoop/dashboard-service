package com.adscoop.nodes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NodeEntity( label = "Banner")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Banner extends AbstratEntity {


    public Banner() {
        this.bannerNodeInfos = new HashSet<>();
    }


    private Integer width;

    private Integer height;
    private Integer clicks;
    private String picture;
    private String website_owner_token;
    private String position_h;
    private String position_v;



    @Relationship(type = "HAS_INFO")
    Set<BannerNodeInfo> bannerNodeInfos;

    private List<Long> bannerSpaceIds = new ArrayList<>();


    public Set<BannerNodeInfo> getBannerNodeInfos() {
        return bannerNodeInfos;
    }

    public void setBannerNodeInfos(Set<BannerNodeInfo> bannerNodeInfos) {
        this.bannerNodeInfos = bannerNodeInfos;
    }

    public void addBannerInfo(BannerNodeInfo bannerNodeInfo ) {
        this.bannerNodeInfos.add(bannerNodeInfo);
        bannerNodeInfo.banner.add(this);
    }


    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getWebsite_owner_token() {
        return website_owner_token;
    }

    public void setWebsite_owner_token(String website_owner_token) {
        this.website_owner_token = website_owner_token;
    }

    public String getPosition_h() {
        return position_h;
    }

    public void setPosition_h(String position_h) {
        this.position_h = position_h;
    }

    public String getPosition_v() {
        return position_v;
    }

    public void setPosition_v(String position_v) {
        this.position_v = position_v;
    }

    public List<Long> getBannerSpaceIds() {
        return bannerSpaceIds;
    }

    public void setBannerSpaceIds(List<Long> bannerSpaceIds) {
        this.bannerSpaceIds = bannerSpaceIds;
    }
}
