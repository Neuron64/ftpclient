package com.neuron64.ftp.client.ui.base.bus.event;

import android.os.Bundle;

public class FragmentEvent {

    public static final int CREATE_CONNECTION = 0;
    public static final int SHOW_CONNECTIONS = 1;

    public final int code;
    public final Bundle data;

    private FragmentEvent(Bundle data, int code){
        this.data = data;
        this.code = code;
    }

    public static FragmentEvent exposeCreateConnection(Bundle data){
        return new FragmentEvent(data, CREATE_CONNECTION);
    }

    public static FragmentEvent exposeShowConnection(Bundle data){
        return new FragmentEvent(data, SHOW_CONNECTIONS);
    }
}
