package com.thedevhorse.projections;

import com.thedevhorse.projections.projection.AthleteResponse;
import com.thedevhorse.projections.repository.AddressEntity;
import com.thedevhorse.projections.repository.AthleteEntity;
import com.thedevhorse.projections.repository.AthleteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class AthleteRepositoryTests {

    @Autowired
    private AthleteRepository athleteRepository;

    @BeforeEach
    public void setUp() {
        AthleteEntity athlete = new AthleteEntity("1", 25, "John", new AddressEntity("New York", "Broadway", "10001"));
        athleteRepository.save(athlete);
    }

    @Test
    void givenAthleteIdValida_whenFindByAthleteId_thenAthleteResponseIsReturned() {
        Optional<AthleteResponse> athlete = athleteRepository.findByAthleteId("1");
        assertTrue(athlete.isPresent());
    }
}