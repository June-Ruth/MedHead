package com.medhead.emergency.controller;

import com.medhead.emergency.dto.ReservationDto;
import com.medhead.emergency.dto.converter.ReservationDtoConverter;
import com.medhead.emergency.entity.GeographicCoordinates;
import com.medhead.emergency.entity.MedicalCenter;
import com.medhead.emergency.entity.MedicalCenterWithTravelTime;
import com.medhead.emergency.entity.Speciality;
import com.medhead.emergency.service.BedAvailabilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmergencyController {
    private final BedAvailabilityService bedAvailabilityService;

    public EmergencyController(BedAvailabilityService bedAvailabilityServiceP) {
        bedAvailabilityService = bedAvailabilityServiceP;
    }

    @GetMapping("/emergency/hospital")
    public ResponseEntity<ReservationDto> getMedicalCenterBySpecialityAndLocalisation(
            @RequestParam("speciality") Speciality speciality,
            @RequestParam("latitude") double latitude,
            @RequestParam("longitude") double longitude
    ) {
        MedicalCenterWithTravelTime closestMedicalCenter = new MedicalCenterWithTravelTime(new MedicalCenter(1, "Center 1", "Address 11", "Address 21", "Address 31", "City 1", "County 1", "PostCode 1", new GeographicCoordinates(11.11,11.11), List.of(Speciality.ALLERGY, Speciality.EMERGENCY_MEDICINE)), 2000000);
        int reservationNumber = bedAvailabilityService.registerOneBedReservation(closestMedicalCenter.getMedicalCenter().getOrganisationId());
        ReservationDto reservation = ReservationDtoConverter.convertMedicalCenterWithTravelTimeToReservationDto(closestMedicalCenter, reservationNumber);
        return ResponseEntity.ok(reservation);
    }

}
