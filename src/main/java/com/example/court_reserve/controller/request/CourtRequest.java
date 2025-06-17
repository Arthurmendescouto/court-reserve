package com.example.court_reserve.controller.request;

import com.example.court_reserve.entity.SportType;
import org.antlr.v4.runtime.misc.NotNull;

public record CourtRequest(SportType sportType, Double pricePerHour, boolean isAvailable) {
}
