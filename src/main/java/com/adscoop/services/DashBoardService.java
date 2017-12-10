package com.adscoop.services;

import com.adscoop.nodes.Banner;

import com.adscoop.nodes.Campagin;
import org.neo4j.ogm.cypher.ComparisonOperator;
import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.session.Session;
import ratpack.exec.Promise;
import rx.Observable;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;

public class DashBoardService {

    private Session session;

    @Inject
    public DashBoardService(Session session) {
        this.session = session;
    }

    public Promise<Iterable<Campagin>> bannerObservable(String name) {

    return     Promise.async( downstream -> {
          Collection<Campagin> banners =     session.loadAll(Campagin.class, new Filter("name", ComparisonOperator.EQUALS, name), 3);

          Iterable<Campagin>  iterable = new ArrayList<>(banners);
          downstream.success(iterable);
        });




    }


}
