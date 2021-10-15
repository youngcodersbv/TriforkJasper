package io.Tabskeeper.controller;

import io.Tabskeeper.dto.CreateNoteCommand;

import io.Tabskeeper.model.Note;
import io.Tabskeeper.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

import static io.Tabskeeper.controller.Constants.NOTES;
import static io.Tabskeeper.controller.Constants.REDIRECT;

@Controller
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    NoteService noteService;

    @PostMapping()
    public String postIndex(@ModelAttribute CreateNoteCommand createNoteCommand) {
        Note note = new Note();
        note.setTitle(createNoteCommand.getTitle());
        note.setBody(createNoteCommand.getBody());
        noteService.save(note);

        return REDIRECT + NOTES;
    }
}
