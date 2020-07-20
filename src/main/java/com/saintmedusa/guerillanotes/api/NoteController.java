package com.saintmedusa.guerillanotes.api;

import java.util.*;
import com.saintmedusa.guerillanotes.service.NoteService;
import com.saintmedusa.guerillanotes.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@RequestMapping("/api/v1/note")
@RestController
public class NoteController {
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    // post request
    @PostMapping("/notes")
    public void addNote(@RequestBody Note note) {
        System.out.println(note);
        noteService.addNote(note);
    }
    // get all request (TO-DO: get all public, geo-cached notes)
    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        List<Note> temp = noteService.getAllNotes();
        return temp;
    }

    @GetMapping("/notes/{id}")
    public Note getNoteByID(@PathVariable("id") UUID id) {
        return noteService.getNoteByID(id)
                .orElse(null); // could return error message 404 here
    }

    // make return a response body
    @DeleteMapping("/notes/{id}")
    public boolean deleteNote(@PathVariable("id") UUID id) {
        return noteService.deleteNote(id);
    }

    @PutMapping("/notes/{id}")
    public void updateNote(@PathVariable UUID id, @RequestBody Note newNote) {
        noteService.updateNote(id, newNote);
    }
}
