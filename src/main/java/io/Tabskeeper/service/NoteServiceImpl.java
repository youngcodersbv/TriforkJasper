package io.Tabskeeper.service;

import io.Tabskeeper.model.Note;
import io.Tabskeeper.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService{

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

}

