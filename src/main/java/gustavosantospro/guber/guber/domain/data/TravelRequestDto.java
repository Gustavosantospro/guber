package gustavosantospro.guber.guber.domain.data;

import gustavosantospro.guber.guber.domain.Passenger;

public record TravelRequestDto(Long passengerId, String origin, String destination) {
}
