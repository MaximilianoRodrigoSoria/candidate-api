package ar.com.laboratory.candidatesapi.application.service;

import java.util.List;

public interface AbstractService<RQ,RP,ID> {

    RP created(RQ request);

    RP read(ID id);

    RP update(RQ request, ID id);

    void delete(ID id);

    List<RP> readAll();
}