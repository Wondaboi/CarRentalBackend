package com.vehicleRental.controller;

import com.vehicleRental.domain.History;
import com.vehicleRental.domain.Rent;
import com.vehicleRental.factories.HistoryFactory;
import com.vehicleRental.services.Impl.HistoryServiceImpl;
import com.vehicleRental.services.Impl.RentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RequestMapping(path = "/history")
public class HistoryController
{
    @Autowired
    private HistoryServiceImpl historyService;

    @GetMapping(path="/all")
    public @ResponseBody
    Set<History> getAllHistory()
    {
        return historyService.readAll();
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public ResponseEntity addHistory(@RequestBody History history){
        if(StringUtils.isEmpty(history.getRent()))
        {
            return new ResponseEntity("Need extra information", HttpStatus.NO_CONTENT);
        }
        historyService.create(history);
        return new ResponseEntity(history, HttpStatus.OK);
    }

    @RequestMapping(value="/find/{id}")
    public @ResponseBody ResponseEntity
    findHistory(@PathVariable("id") Integer id)
    {
        Optional<History> history = historyService.read(id);

        if(!history.isPresent())
        {
            return new ResponseEntity("No history found for history " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(history, HttpStatus.OK);
    }

    @RequestMapping(value="/update", method = RequestMethod.PUT)
    public ResponseEntity updateHistory(@RequestBody History history)
    {
        if(StringUtils.isEmpty(history.getRent()))
        {
            return new ResponseEntity("Need extra information", HttpStatus.NO_CONTENT);
        }
        historyService.update(history);
        return new ResponseEntity(history, HttpStatus.OK);
    }

    @RequestMapping(value="/delete/{historyID}", method = RequestMethod.DELETE)
    public void deleteHistory(@PathVariable History historyID)
    {
        historyService.delete(historyID);
    }

}
