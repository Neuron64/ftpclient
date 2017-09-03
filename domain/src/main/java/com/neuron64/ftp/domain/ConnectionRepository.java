package com.neuron64.ftp.domain;

import com.neuron64.ftp.domain.model.UserConnection;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Neuron on 03.09.2017.
 */

public interface ConnectionRepository {

    Single<List<UserConnection>> getAllConnection();

}
