package com.saintmedusa.guerillanotes.dao;

import java.util.*;
import com.saintmedusa.guerillanotes.model.Note;
import org.springframework.stereotype.Repository;


@Repository("fakeDao")
public class FakeNoteDataAccessService implements NoteDao {

    private static List<Note> DB = new ArrayList<>();

    @Override
    public boolean addNote(UUID id, Note note) {
        DB.add(new Note(id, note.getTagID(), note.getText()));
        return true;
    }

    @Override
    public List<Note> selectAllNotes() {
        return DB;
    }

    @Override
    public Optional<Note> selectNoteByID(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public boolean deleteNoteByID(UUID id) {
        Optional<Note> noteMaybe = selectNoteByID(id);
        if (noteMaybe.isPresent()) {
            DB.remove(noteMaybe.get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateNoteByID(UUID id, Note updated) {
        return selectNoteByID(id)
                .map(note -> {
                    int noteIndex = DB.indexOf(note);
                    if (noteIndex >= 0) {
                        DB.set(noteIndex, new Note(id, updated.getTagID(), updated.getText()));
                        return true;
                    } else {
                        return false;
                    }
                })
                .orElse(false);
    }
}

