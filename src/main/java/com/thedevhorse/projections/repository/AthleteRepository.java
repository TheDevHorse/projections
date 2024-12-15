package com.thedevhorse.projections.repository;

import com.thedevhorse.projections.projection.AthleteResponse;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface AthleteRepository extends Repository<AthleteEntity, Long> {

    Optional<AthleteResponse> findByAthleteId(String athleteId);

    List<AthleteResponse> findAllBy();

    void save(AthleteEntity athleteEntity);

}