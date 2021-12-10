package co.com.sofka.calendar.controller;

import co.com.sofka.calendar.model.ProgramDate;
import co.com.sofka.calendar.services.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class controller {

    @Autowired
    SchedulerService schedulerService;

    @GetMapping("/generate/{date}/{id}")
    public Flux<ProgramDate> generateCalendar(@PathVariable("date") String date, @PathVariable("id") String id) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);

        return schedulerService.generateCalendar(id, localDate);
    }
}
