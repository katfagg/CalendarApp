package com.example.CalendarApp.CalendarApp.services;

import com.example.CalendarApp.CalendarApp.models.*;
import com.example.CalendarApp.CalendarApp.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    UserService userService;

    @Autowired
    NoteRepository noteRepository;

    public Optional<Note> getNoteById(Long id){
        return noteRepository.findById(id);
    }

    public Note saveNote(UserService userService){
        Note newNote = new Note(userService);
        noteRepository.save(newNote);
        return newNote;
    }

}
