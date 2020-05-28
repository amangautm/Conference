package com.example.conference.controllers;

import com.example.conference.models.Speaker;
import com.example.conference.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public Iterable<Speaker> list(){
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Optional<Speaker> get(@PathVariable Long id){
        return speakerRepository.findById(id);
    }

    @PostMapping
    public Speaker create(@RequestBody Speaker speaker){
        return speakerRepository.save(speaker);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id){
        speakerRepository.deleteById(id);
    }

    @PutMapping
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker){
        Speaker existingSpeaker =speakerRepository.findById(id).get();
        BeanUtils.copyProperties(speaker,existingSpeaker,"speaker_id");
        return speakerRepository.save(existingSpeaker);
    }
}
