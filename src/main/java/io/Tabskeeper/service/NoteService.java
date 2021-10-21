package io.Tabskeeper.service;

import io.Tabskeeper.model.Note;

import java.util.Optional;


public interface NoteService {
    void save(Note note);

    Iterable findAll();

    Optional<Note> findById(Long id);

    void deleteById(Long id);

    void delete(Note entity);

    boolean existsById(Long id);
}
