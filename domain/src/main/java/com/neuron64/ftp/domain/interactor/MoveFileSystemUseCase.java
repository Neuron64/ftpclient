package com.neuron64.ftp.domain.interactor;

import com.neuron64.ftp.domain.exception.NameNotValide;
import com.neuron64.ftp.domain.executor.BaseSchedulerProvider;
import com.neuron64.ftp.domain.params.MoveFileParams;
import com.neuron64.ftp.domain.repository.FileSystemRepository;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * Created by yks-11 on 11/17/17.
 */

public class MoveFileSystemUseCase extends MoveDocumentUseCase<MoveFileParams>{

    @Inject
    public MoveFileSystemUseCase(BaseSchedulerProvider schedulerProvider, FileSystemRepository repository) {
        super(schedulerProvider, repository);
    }

    @Override
    protected Completable moveDocument(MoveFileParams params) {
        return repository.moveDocument(params.getDocumentId(), params.getTargetDocumentId());
    }

    @Override
    protected Completable validate(MoveFileParams params) {
        return Completable.create(e -> {
            if(params.getDocumentId() == null || params.getTargetDocumentId() == null) {
                e.onError(new NameNotValide());
            }
            e.onComplete();
        });
    }
}
