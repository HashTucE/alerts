package com.safetynet.alerts.service;

import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.repository.FireStationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FireStationServiceImpl implements FireStationService {


    @Autowired
    FireStationRepository fireStationRepository = new FireStationRepository();

    private static final Logger log = LogManager.getLogger(FireStationServiceImpl.class);

    List<FireStation> fireStationsList = fireStationRepository.loadFireStationsList();



    @Override
    public FireStation addFireStation(FireStation fireStation) {
        log.debug("addFireStation() from repository called !");
        return fireStationRepository.addFireStation(fireStation);
    }

    @Override
    public FireStation updateFireStation(FireStation fireStation) {
        log.debug("updateFireStation() from repository called !");
        return fireStationRepository.updateFireStation(fireStation);
    }

    @Override
    public void deleteFireStation(FireStation fireStation) {
        log.debug("deleteFireStation() from repository called !");
        fireStationRepository.deleteFireStation(fireStation);
    }

    @Override
    public List<FireStation> findAllFireStations() {
        log.debug("findAll() from repository called !");
        return fireStationRepository.findAll();

    }

    @Override
    public List<String> findFireStationAddressesByNumber(Integer fireStationNumber) {
//        List<FireStation> fireStationsList = fireStationRepository.loadFireStationsList();
        List<String> addressesList = new ArrayList<>();
        for (FireStation fireStation : fireStationsList) {
            if (fireStation.getStation().equals((fireStationNumber))) addressesList.add(fireStation.getAddress());
        }
        log.debug("List of addresses generated !");
        return addressesList;
    }

    @Override
    public List<String> findAddressesByNumber(Integer firestationNumber) {

        List<String> adressesList = new ArrayList<>();
        for (FireStation fireStation : fireStationsList) {
            if (fireStation.getStation().equals(firestationNumber))
                adressesList.add(fireStation.getAddress());
        }
        return adressesList;
    }

    @Override
    public Integer findStationNumberByAddress(String address) {

        Integer station = 0;
        for (FireStation fireStation : fireStationsList) {
            station = Integer.valueOf(fireStation.getStation());
//            if (fireStation.getAddress().equals(address)) ;
        }
        return station;
    }


}