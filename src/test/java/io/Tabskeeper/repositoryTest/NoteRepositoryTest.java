package io.Tabskeeper.repositoryTest;

import io.Tabskeeper.model.Note;
import io.Tabskeeper.repository.NoteRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


@DataJpaTest
public class NoteRepositoryTest {

    @Autowired
    private NoteRepository underTest;

    Note testNote = new Note();
    Note testNote1 = new Note();

    @BeforeEach
    void setUp(){
        testNote.setTitle("title");
        testNote.setBody("body");

        testNote1.setTitle("title1");
        testNote1.setBody("body1");
    }
    @Test
    void saveNote() {
        System.out.println("Running saveNote...");
        //given a note being saved
        underTest.save(testNote);

        //when all notes are found
        Iterable<Note> result = underTest.findAll();

        //then we only have a single Note in the stream
        assertEquals(1, StreamSupport.stream(result.spliterator(), false).count());

        //which is testNote
        for (Note i: result) { assertEquals(testNote, i);}
    }

    @Test
    void updateNote() {
        System.out.println("Running updateNote...");
        //given
        underTest.save(testNote);
        Long id = testNote.getId();
        Note note = underTest.findById(id).get();

        //when
        note.setTitle("New Title");
        note.setBody("New Body");
        underTest.save(note);
        Long testId = testNote.getId();

        //then
        Note result = underTest.findById(testId).get();
        assertEquals("New Title", result.getTitle());
        assertEquals("New Body", result.getBody());
    }

    @Test
    void deleteNote() {
        System.out.println("Running deleteNote...");

        //given
        underTest.save(testNote1);
        Long testNote1Id = testNote1.getId();

        underTest.save(testNote);
        Long testNoteId = testNote.getId();

        //when
        Note note1 = underTest.findById(testNote1Id).get();
        underTest.delete(note1);
        underTest.deleteById(testNoteId);

        //then
        assertFalse(underTest.existsById(testNote1Id));
        assertFalse(underTest.existsById(testNoteId));
    }
}
