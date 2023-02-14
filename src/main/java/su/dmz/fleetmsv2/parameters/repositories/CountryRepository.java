package su.dmz.fleetmsv2.parameters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import su.dmz.fleetmsv2.parameters.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> { }
