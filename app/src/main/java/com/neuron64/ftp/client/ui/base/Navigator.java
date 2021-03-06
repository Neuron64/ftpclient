package com.neuron64.ftp.client.ui.base;

import android.app.Activity;
import android.content.Intent;

import com.neuron64.ftp.client.ui.base.bus.event.NavigateEvent;
import com.neuron64.ftp.client.ui.directory.DirectoryActivity;
import com.neuron64.ftp.client.ui.file_info.FileActivity;

/**
 * Created by Neuron on 01.10.2017.
 */

public class Navigator {

    public void navigate(Activity activity, NavigateEvent navigateEvent){
        Class<?> clazz = DirectoryActivity.class;
        switch (navigateEvent.code){
            case NavigateEvent.OPEN_DIRECTORY: {
                clazz = DirectoryActivity.class;
                break;
            }
            case NavigateEvent.OPEN_FILE_INFO:{
                clazz = FileActivity.class;
                break;
            }
        }

        Intent intent = new Intent(activity, clazz);
        intent.putExtras(navigateEvent.data);
        activity.startActivity(intent);
    }
}
