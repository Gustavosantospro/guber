package gustavosantospro.guber.guber.domain.data;

import gustavosantospro.guber.guber.domain.Passenger;

public record TravelRequestDto(Passenger passenger, String origin, String destination) {
}
