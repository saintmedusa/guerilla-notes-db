package com.saintmedusa.guerillanotes.advice;

import com.saintmedusa.guerillanotes.exceptions.NoteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class NoteNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(NoteNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String noteNotFoundHandler(NoteNotFoundException exception) {
        return exception.getMessage();
    }
}