package com.adscoop.services;

import com.adscoop.handlers.DashBoardHandler;
import ratpack.handling.Context;
import ratpack.handling.internal.DefaultContext;
import ratpack.server.RatpackServer;
import ratpack.service.Service;
import ratpack.service.StartEvent;
import rx.RxReactiveStreams;
import rx.Scheduler;

public class SchedulerService implements Service {


    @Override
    public void onStart(StartEvent event) throws Exception {
      DashBoardHandler dashBoardHandler = event.getRegistry().get(DashBoardHandler.class);


    }
}
