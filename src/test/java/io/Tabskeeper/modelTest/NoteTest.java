package io.Tabskeeper.modelTest;

import io.Tabskeeper.model.Note;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class NoteTest {

    Note note = new Note();

    @BeforeEach
    @Test
    void setUp(){
        note.setTitle("test title");
        note.setBody("test body");
    }

    @Test
    void getNoteProperties(){
        System.out.println("Running getNoteProperties...");
        // given

        // when

        // then
       assertEquals(note.getTitle(), "test title");
       assertEquals(note.getBody(), "test body");
    }


}
