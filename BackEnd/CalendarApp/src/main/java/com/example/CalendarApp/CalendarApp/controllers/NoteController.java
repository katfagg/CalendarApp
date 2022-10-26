package com.example.CalendarApp.CalendarApp.controllers;

import com.example.CalendarApp.CalendarApp.models.Note;
import com.example.CalendarApp.CalendarApp.models.User;
import com.example.CalendarApp.CalendarApp.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/notes")
public class NoteController {

    @Autowired
    NoteService noteService;

    @GetMapping(value = "/{email}")
    public ResponseEntity<Note> getNoteById(@PathVariable long email){
        Optional<Note> note = noteService.getNoteById(email);
        if (note.isPresent()){
            return  new ResponseEntity<>(note.get(),HttpStatus.OK);
        } else {
            return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<Note> startNewNote (@RequestParam long noteId){
        Note savedNote = noteService.saveNote(noteId);
        return new ResponseEntity<>(savedNote, HttpStatus.CREATED);
    }

    //Delete list by id

}
