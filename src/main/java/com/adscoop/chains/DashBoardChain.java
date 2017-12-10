package com.adscoop.chains;

import com.adscoop.handlers.AddBannerInfoHandler;
import com.adscoop.handlers.CorsHandler;
import com.adscoop.handlers.DashBoardHandler;
import ratpack.func.Action;
import ratpack.handling.Chain;
import ratpack.handling.Handler;
import ratpack.registry.Registry;
import ratpack.server.ServerConfig;


public class DashBoardChain implements Action<Chain> {

    @Override
    public void execute(Chain chain) throws Exception {
        chain.all(CorsHandler.class).post("campagin/:name/:id", AddBannerInfoHandler.class).get("bannerinfo/:name", DashBoardHandler.class);
    }
}
