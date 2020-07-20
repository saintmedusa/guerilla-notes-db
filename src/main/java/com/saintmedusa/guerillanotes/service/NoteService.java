package com.saintmedusa.guerillanotes.service;

import java.util.*;
import com.saintmedusa.guerillanotes.dao.NoteDao;
import com.saintmedusa.guerillanotes.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
    private final NoteDao noteDao;

    // can change qualifier to fit a db implementation >> PostGres, for example
    @Autowired
    public NoteService(@Qualifier("fakeDao") NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public boolean addNote(Note note) {
        return noteDao.addNote(note);
    }

    public List<Note> getAllNotes() {
        return noteDao.selectAllNotes();
    }

    public Optional<Note> getNoteByID(UUID id) {
        return noteDao.selectNoteByID(id);
    }

    public boolean deleteNote(UUID id) {
        return noteDao.deleteNoteByID(id);
    }

    public boolean updateNote(UUID id, Note newNote) {
        return noteDao.updateNoteByID(id, newNote);
    }
}
