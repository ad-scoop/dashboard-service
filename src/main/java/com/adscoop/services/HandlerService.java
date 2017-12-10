package com.adscoop.services;

import com.adscoop.nodes.Banner;
import com.adscoop.nodes.BannerNodeInfo;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.neo4j.ogm.session.Session;

import java.util.Collections;

@Slf4j
public class HandlerService {


    private Session session;
    private BannerNodeInfo bannerNodeInfo;

    @Inject
    public HandlerService(Session session) {
        this.session = session;
    }


    public void addBannderNodeInfo(long bannerId, BannerNodeInfo bannerNodeInfo) {


        Banner banner = session.queryForObject(Banner.class, "MATCH (b:Banner) WHERE id(b)={id} RETURN b AS Banner", Collections.singletonMap("id", bannerId));


        int clicks = banner.getClicks();
        clicks = clicks + 1;
        banner.setClicks(clicks);
        banner.addBannerInfo(bannerNodeInfo);

        session.save(banner);
        session.clear();


    }


}
