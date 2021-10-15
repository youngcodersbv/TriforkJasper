package io.Tabskeeper.controller;

import io.Tabskeeper.model.Note;
import io.Tabskeeper.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@RestController()
@RequestMapping(path = "/json/notes")
public class NoteJsonController {
    @Autowired
    private NoteRepository noteRepository;

    @GetMapping
    public Note[] getAllNoteInJson(){
        Iterable<Note> notes = noteRepository.findAll();

        List<Note> result = new ArrayList();
        StreamSupport.stream(notes.spliterator(),false)
                .forEach(result::add);

        return result.toArray(new Note[result.size()]);
    }
}
