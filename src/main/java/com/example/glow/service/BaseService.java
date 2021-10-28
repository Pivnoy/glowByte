package com.example.glow.service;

import com.example.glow.controller.dto.BaseData;
import com.example.glow.entity.mySql.ClientBirthDtResource;
import com.example.glow.entity.mySql.ClientFioResource;
import com.example.glow.entity.mySql.ClientInnResource;
import com.example.glow.repository.mySqlRep.ClientBirthDtResourceCrudRepository;
import com.example.glow.repository.mySqlRep.ClientFioResourceCrudRepository;
import com.example.glow.repository.mySqlRep.ClientInnResourceCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Lagus Maksim, Makarev Evgenij
 * @version 1.0
 * Service to get list of data from database
 * and pack it into java class to use further
 */
@Service
public class BaseService {

    private ClientFioResourceCrudRepository clientFioResourceCrudRepository;
    private ClientInnResourceCrudRepository clientInnResourceCrudRepository;
    private ClientBirthDtResourceCrudRepository clientBirthDtResourceCrudRepository;

    @Autowired
    public BaseService(ClientFioResourceCrudRepository clientFioResourceCrudRepository, ClientInnResourceCrudRepository clientInnResourceCrudRepository, ClientBirthDtResourceCrudRepository clientBirthDtResourceCrudRepository) {
        this.clientFioResourceCrudRepository = clientFioResourceCrudRepository;
        this.clientInnResourceCrudRepository = clientInnResourceCrudRepository;
        this.clientBirthDtResourceCrudRepository = clientBirthDtResourceCrudRepository;
    }

    /**
     * Native sql get method implemented with CRUD rep
     * @return list of matched Fio, Id, Birth and Inn data
     */

    public List<BaseData> getData() {
        List<BaseData> data = new ArrayList<>();
        List<ClientFioResource> fio = new ArrayList<>();
        List<ClientInnResource> inn = new ArrayList<>();
        List<ClientBirthDtResource> birthDt = new ArrayList<>();
        clientFioResourceCrudRepository.findAll().forEach(fio::add);
        clientInnResourceCrudRepository.findAll().forEach(inn::add);
        clientBirthDtResourceCrudRepository.findAll().forEach(birthDt::add);
        if (fio.size() == inn.size() && inn.size() == birthDt.size()) {
            for (int i = 0; i < inn.size(); i++) {
                if (Objects.equals(fio.get(i).getClientId(), inn.get(i).getClientID()) &&
                        Objects.equals(inn.get(i).getClientID(), birthDt.get(i).getClientId())) {
                    data.add(BaseData.builder().
                            custFio(fio.get(i).getClientFio())
                            .custId(fio.get(i).getClientId())
                            .custBirth(birthDt.get(i).getClientBirthDt())
                            .custInn(inn.get(i).getClientInn()).build());
                }
            }
        }
        return data;
    }
}




