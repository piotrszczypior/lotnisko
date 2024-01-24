package org.pwr.lotnisko.service;

import org.pwr.lotnisko.dto.CheckInTo;
import org.pwr.lotnisko.model.Flight;


public interface FlightService {
    Flight addFlight(Flight flight);

    Flight findById(long id);

    boolean vadateFlightNumber(CheckInTo checkInTo);

    String selectSeat(CheckInTo checkInTo);

    void addExtraLuggage(CheckInTo checkInTo);
}
