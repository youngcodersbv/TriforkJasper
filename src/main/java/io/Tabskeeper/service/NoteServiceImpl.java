package io.Tabskeeper.service;

import io.Tabskeeper.model.Note;
import io.Tabskeeper.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

    @Override
    public Iterable findAll() {
        return noteRepository.findAll();
    }

    @Override
    public Optional<Note> findById(Long id) {return noteRepository.findById(id);}

    @Override
    public void deleteById(Long id){ noteRepository.deleteById(id);}

    @Override
    public void delete(Note note){ noteRepository.delete(note);}

    @Override
    public boolean existsById(Long id){ return noteRepository.existsById(id);}
}

