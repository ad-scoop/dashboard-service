package com.adscoop;

import com.adscoop.chains.DashBoardChain;
import com.adscoop.configurations.ModuleConfiguration;
import com.adscoop.modules.Config;
import com.adscoop.modules.ServiceCommonConfigModule;
import ratpack.guice.Guice;
import ratpack.rx.RxRatpack;
import ratpack.server.BaseDir;
import ratpack.server.RatpackServer;

public class StartDashBoard {

    public static void main(String...args) throws Exception {
        RxRatpack.initialize();
        RatpackServer.start(ratpackServerSpec -> ratpackServerSpec.serverConfig(serverConfigBuilder -> serverConfigBuilder.baseDir(BaseDir.find()
        ).yaml("ratpack.yaml").require("/db", Config.class).props("ratpack.properties").env().sysProps().build()).registry(Guice.registry(bindingsSpec -> bindingsSpec.module(ModuleConfiguration.class).module(ServiceCommonConfigModule.class))).handlers(chain ->
        chain.prefix("dashboard", DashBoardChain.class)));
    }

}
