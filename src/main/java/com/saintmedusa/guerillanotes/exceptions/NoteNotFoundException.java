package com.saintmedusa.guerillanotes.exceptions;

import java.util.*;

public class NoteNotFoundException extends RuntimeException {
    NoteNotFoundException(UUID id) {
        super("Could not find note" + id);
    }
}
