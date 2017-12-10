package com.adscoop.handlers;


import com.adscoop.nodes.BannerNodeInfo;
import com.adscoop.services.DashBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.exec.Promise;
import ratpack.exec.util.ParallelBatch;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.jackson.Jackson;
import ratpack.rx.RxRatpack;
import ratpack.sse.ServerSentEvents;
import ratpack.stream.TransformablePublisher;
import rx.Observable;

import javax.inject.Inject;
import java.util.Objects;

public class DashBoardHandler implements Handler {

    private static Logger logger = LoggerFactory.getLogger(DashBoardHandler.class);
    private String name;

    private String bannerId;

    private DashBoardService dashBoardService;
    private Observable<BannerNodeInfo> bannerNodeInfo;

    @Inject
    public DashBoardHandler(DashBoardService dashBoardService) {
        this.dashBoardService = dashBoardService;
    }

    public Observable<BannerNodeInfo> getBannerNodeInfo() {
        return bannerNodeInfo;
    }

    public void setBannerNodeInfo(Observable<BannerNodeInfo> bannerNodeInfo) {
        this.bannerNodeInfo = bannerNodeInfo;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        logger.debug("DashBoard Handler start");

        RxRatpack.observe(this.dashBoardService.bannerObservable(ctx.getPathTokens().get("name"))).subscribe(banners -> {

            TransformablePublisher infoTransformablePublisher = ParallelBatch.of(Promise.value(banners)).publisher();
            ctx.render(ServerSentEvents.serverSentEvents(infoTransformablePublisher, tEvent -> tEvent.id(Objects::toString).data(t -> Jackson.getObjectWriter(ctx).writeValueAsString(t))));

            logger.debug("has sent"+ banners.iterator().next().getBanners().get(0).getBannerNodeInfos().iterator().next().getAccuracy());

        });


    }

}
