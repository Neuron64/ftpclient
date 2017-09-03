package com.neuron64.ftp.data.database;

import android.support.annotation.NonNull;

import com.neuron64.ftp.data.model.local.UserConnection;

import java.util.List;

import io.reactivex.Observable;
import io.realm.Realm;

/**
 * Created by Neuron on 03.09.2017.
 */

public final class RealmService {

    public static Observable<List<UserConnection>> getAllUserConnection(){
        return Observable.fromCallable(() -> Realm.getDefaultInstance().where(UserConnection.class).findAll());
    }
}
