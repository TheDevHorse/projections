package com.thedevhorse.projections;

import com.thedevhorse.projections.projection.AthleteResponse;
import com.thedevhorse.projections.repository.AddressEntity;
import com.thedevhorse.projections.repository.AthleteEntity;
import com.thedevhorse.projections.repository.AthleteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class AthleteRepositoryTests {

    @Autowired
    private AthleteRepository athleteRepository;

    @BeforeEach
    public void setUp() {
        AthleteEntity athlete = new AthleteEntity("PT1", 25, "John", new AddressEntity("New York", "Broadway", "10001"));
        athleteRepository.save(athlete);
    }

    @Test
    void whenFindAllBy_thenListOfAthleteResponseIsReturned() {
        // Given
        // When
        List<AthleteResponse> actual = athleteRepository.findAllBy();

        // Then
        assertEquals(1, actual.size());
    }

    @Test
    void givenAthleteIdValid_whenFindByAthleteId_thenAthleteResponseIsReturned() {
        // Given
        String athleteId = "PT1";

        // When
        Optional<AthleteResponse> actual = athleteRepository.findByAthleteId(athleteId);

        // Then
        assertTrue(actual.isPresent());
    }

    @Test
    void givenAthleteIdValid_whenFindByAthleteId_thenReturnsCurrentResult() {
        // Given
        String athleteId = "PT1";

        // When
        AthleteResponse actual = athleteRepository.findByAthleteId(athleteId).get();

        // Then
        assertEquals("PT1", actual.getAthleteId());
        assertEquals("John", actual.getName());
        assertEquals("New York", actual.getAddress().getCity());
        assertEquals("Broadway", actual.getAddress().getStreet());
        assertEquals("10001", actual.getAddress().getZipCode());
    }
}