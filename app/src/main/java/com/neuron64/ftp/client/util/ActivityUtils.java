package com.neuron64.ftp.client.util;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import static com.neuron64.ftp.client.util.Preconditions.checkNotNull;

/**
 * Created by Neuron on 03.09.2017.
 */

public class ActivityUtils {

    public static void addFragmentToActivity (@NonNull FragmentManager fragmentManager,
                                              @NonNull Fragment fragment, int frameId) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        fragmentManager.beginTransaction()
                .add(frameId, fragment)
                .commit();
    }

}
