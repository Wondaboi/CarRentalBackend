package com.vehicleRental.services.Impl;

import com.vehicleRental.domain.History;
import com.vehicleRental.repositories.HistoryRepository;
import com.vehicleRental.services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class HistoryServiceImpl implements HistoryService
{
    @Autowired
    private HistoryRepository historyRepository;


    public History create(History history)
    {
        return historyRepository.save(history);
    }

    public Optional<History> read(Integer id)
    {
        return historyRepository.findById(id);
    }
    public History update(History history)
    {
        return historyRepository.save(history);
    }
    public void delete(History id)
    {
         historyRepository.delete(id);
    }
    public Set<History> readAll()
    {
        Iterable<History> historys = historyRepository.findAll();
        Set historySet = new HashSet();
        for(History history:historys)
        {
            historySet.add(history);
        }
        return historySet;
    }

}
