package com.saintmedusa.guerillanotes.dao;

import com.saintmedusa.guerillanotes.model.Note;
import java.util.*;

public interface NoteDao {

    boolean addNote(UUID id, Note note);

    default boolean addNote(Note note) {
        UUID id = UUID.randomUUID();
        return addNote(id, note);
    }

    List<Note> selectAllNotes();

    Optional<Note> selectNoteByID(UUID id);

    boolean deleteNoteByID(UUID id);

    boolean updateNoteByID(UUID id, Note note);

}
