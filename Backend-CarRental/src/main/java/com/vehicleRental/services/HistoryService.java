package com.vehicleRental.services;

import com.vehicleRental.domain.History;

import java.util.Optional;
import java.util.Set;

public interface HistoryService
{
    History create(History history);
    Optional<History> read(Integer id);
    History update(History history);
    void delete(History id);
    Set<History> readAll();
}
