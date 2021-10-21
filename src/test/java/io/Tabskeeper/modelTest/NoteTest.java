package io.Tabskeeper.modelTest;

import io.Tabskeeper.model.Note;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NoteTest {

    Note note = new Note();
    @Test
    void createNote(){
        System.out.println("Running createNote...");
        // given
        String title = "Test title";
        String body = "Test body";

        // when
        note.setTitle(title);
        note.setBody(body);

        // then
       assertEquals(note.getTitle(), title);
       assertEquals(note.getBody(), body);
    }


}
