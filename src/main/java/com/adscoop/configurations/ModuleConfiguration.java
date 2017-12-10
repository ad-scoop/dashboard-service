package com.adscoop.configurations;

import com.adscoop.chains.DashBoardChain;
import com.adscoop.handlers.AddBannerInfoHandler;
import com.adscoop.handlers.CorsHandler;
import com.adscoop.handlers.DashBoardHandler;
import com.adscoop.modules.ServiceCommonConfigModule;
import com.adscoop.services.DashBoardService;
import com.adscoop.services.HandlerService;
import com.google.inject.AbstractModule;

public class ModuleConfiguration extends AbstractModule {
    @Override
    protected void configure() {
        bind(AddBannerInfoHandler.class).asEagerSingleton();
        bind(DashBoardHandler.class).asEagerSingleton();
        bind(DashBoardChain.class).asEagerSingleton();
        bind(ServiceCommonConfigModule.class).asEagerSingleton();
        bind(CorsHandler.class).asEagerSingleton();
        bind(HandlerService.class).asEagerSingleton();
        bind(DashBoardService.class).asEagerSingleton();

    }
}
