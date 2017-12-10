package com.adscoop.handlers;

import com.adscoop.nodes.BannerNodeInfo;
import com.adscoop.services.DashBoardService;
import com.adscoop.services.HandlerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import javax.inject.Inject;

@Slf4j
public class AddBannerInfoHandler implements Handler {

    private HandlerService handlerService;
    private DashBoardService dashBoardService;
    private ObjectMapper _objectMapper;

    @Inject
    public AddBannerInfoHandler(HandlerService _dashboardService, DashBoardService dashBoardService) {
        this.handlerService = _dashboardService;
        this.dashBoardService = dashBoardService;
        this._objectMapper = new ObjectMapper();
    }

    @Override
    public void handle(Context ctx) throws Exception {



        ctx.getRequest().getBody().then(typedData -> {


            BannerNodeInfo bannerNodeInfo = _objectMapper.readValue(typedData.getText(), BannerNodeInfo.class);
            BannerNodeInfo bannerNodeInfo1 = new BannerNodeInfo();

            bannerNodeInfo1.setAccuracy(bannerNodeInfo.getAccuracy());
            bannerNodeInfo1.setAppCodeName(bannerNodeInfo.getAppCodeName());
            bannerNodeInfo1.setAppName(bannerNodeInfo.getAppName());
            bannerNodeInfo1.setAppVersion(bannerNodeInfo.getAppVersion());
            bannerNodeInfo1.setCampagin_name(bannerNodeInfo.getCampagin_name());
            bannerNodeInfo1.setCookieEnabled(bannerNodeInfo.isCookieEnabled());
            bannerNodeInfo1.setHardwareConcurrency(bannerNodeInfo.getHardwareConcurrency());
            bannerNodeInfo1.setLanguage(bannerNodeInfo.getLanguage());
            bannerNodeInfo1.setLatitude(bannerNodeInfo.getLatitude());
            bannerNodeInfo1.setLongitude(bannerNodeInfo.getLongitude());
            handlerService.addBannderNodeInfo(bannerNodeInfo.getId(), bannerNodeInfo1);


            ctx.insert(new DashBoardHandler(dashBoardService));

        });


    }

}
