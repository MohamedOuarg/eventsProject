package tn.esprit.eventsproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.eventsproject.entities.Event;
import tn.esprit.eventsproject.entities.Logistics;
import tn.esprit.eventsproject.entities.Participant;
import tn.esprit.eventsproject.services.IEventServices;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("event")
@RestController
public class EventRestController {
    private final IEventServices eventServices;

    @PostMapping("/addPart")
    public Participant addParticipant(@RequestBody Participant participant){
        return eventServices.addParticipant(participant);
    }
    @PostMapping("/addEvent/{id}")
    public Event addEventPart(@RequestBody Event event, @PathVariable("id") int idPart){
        return eventServices.addAffectEvenParticipant(event, idPart);
    }
    @PostMapping("/addEvent")
    public Event addEvent(@RequestBody Event event){
        return eventServices.addAffectEvenParticipant(event);
    }
//    @PutMapping("/addAffectLog/{description}")
//    public Logistics addAffectLog(@RequestBody Logistics logistics,@PathVariable("description") String descriptionEvent){
//        return eventServices.addAffectLog(logistics,descriptionEvent);
//    }
    //    @PutMapping("/addAffectLog/{description}")
//    public Logistics addAffectLog(@RequestBody Logistics logistics,@PathVariable("description") String descriptionEvent){
//        return eventServices.addAffectLog(logistics,descriptionEvent);
//    }

    //    @PutMapping("/addAffectLog/{description}")

    //    @PutMapping("/addAffectLog/{description}")
    

    
   





    @GetMapping("/getLogs/{d1}/{d2}")
    public List<Logistics> getLogistiquesDates (@PathVariable("d1") LocalDate date_debut, @PathVariable("d2") LocalDate date_fin){
        return eventServices.getLogisticsDates(date_debut,date_fin);
    }
    @GetMapping("/getall")
    public List<Event> getall() {
        return eventServices.getall();
    }
    @GetMapping("/getbyid")
    public Event getbyid(@RequestParam int id) {
        return eventServices.findone(id);
    }
}
