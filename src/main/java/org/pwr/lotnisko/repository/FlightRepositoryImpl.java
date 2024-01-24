package org.pwr.lotnisko.repository;

import org.pwr.lotnisko.dto.CheckInTo;
import org.pwr.lotnisko.model.Flight;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class FlightRepositoryImpl implements FlightRepository {

    private final List<Flight> flights = new ArrayList<>();



    @Override
    public int addFlight(Flight flight) {
        flights.add(flight);
        return flights.indexOf(flight);
    }

    @Override
    public void removeFlight(Flight flight) {
        flights.remove(flight);
    }

    @Override
    public boolean editFlight(Flight flight) {
        boolean exists = flights.stream().anyMatch(f -> f.getId() == flight.getId());
        if (!exists) {
            return false;
        }
        flights.replaceAll(f -> f.getId() == flight.getId() ? flight : f);
        return true;
    }

    @Override
    public List<Flight> findAll() {
        return flights;
    }

    @Override
    public Optional<Flight> findById(final long id) {
        return flights.stream().filter(flight -> flight.getId() == id).findFirst();
    }
}
