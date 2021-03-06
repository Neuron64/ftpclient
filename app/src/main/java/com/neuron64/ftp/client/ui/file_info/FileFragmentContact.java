package com.neuron64.ftp.client.ui.file_info;

import com.neuron64.ftp.client.ui.base.BasePresenter;
import com.neuron64.ftp.client.ui.base.BaseView;
import com.neuron64.ftp.domain.model.FileInfo;

import java.util.Date;

/**
 * Created by Neuron on 21.10.2017.
 */

public interface FileFragmentContact {

    interface View extends BaseView<FileFragmentContact.Presenter>{

        FileInfo getExtraFileInfo();

        void showInfoAboutFile(String name, String ext, Date date, String path, long size);

    }

    interface Presenter extends BasePresenter<FileFragmentContact.View> {

    }

}
