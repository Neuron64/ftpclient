package com.neuron64.ftp.data.repository;

import com.neuron64.ftp.data.database.RealmService;
import com.neuron64.ftp.data.mapper.Mapper;
import com.neuron64.ftp.domain.model.UserConnection;
import com.neuron64.ftp.domain.repository.ConnectionRepository;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Action;

/**
 * Created by Neuron on 03.09.2017.
 */

public class ConnectionDataRepository implements ConnectionRepository {

    private final Mapper<UserConnection, com.neuron64.ftp.data.model.local.UserConnection> connectionMapper;
    private final RealmService realmService;

    @Inject
    public ConnectionDataRepository(Mapper<UserConnection, com.neuron64.ftp.data.model.local.UserConnection> connectionMapper, RealmService realmService){
        this.connectionMapper = connectionMapper;
        this.realmService = realmService;
    }

    @Override
    public Single<List<UserConnection>> getAllConnection() {
        return Single.fromCallable(realmService::getAllUserConnection)
                .toObservable()
                .flatMap(Observable::fromIterable)
                .map(connectionMapper::map)
                .toList();
    }

    @Override
    public Single<UserConnection> saveOrUpdateConnection(String id, String title, String host, String username, String password, Integer port, Date date) {
        com.neuron64.ftp.data.model.local.UserConnection userConnection = new com.neuron64.ftp.data.model.local.UserConnection(id, title, host, username, password, port);
        return Completable.fromAction(() -> realmService.insertOrUpdateConnection(userConnection))
                .andThen(Single.just(userConnection)
                .map(connectionMapper::map));
    }

    @Override
    public Completable deleteConnection(String id) {
        return Completable.fromAction(() -> realmService.deleteConnection(id));
    }
}
