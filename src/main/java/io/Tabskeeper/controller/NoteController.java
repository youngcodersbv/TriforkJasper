package io.Tabskeeper.controller;

import io.Tabskeeper.dto.CreateNote;

import io.Tabskeeper.model.Note;
import io.Tabskeeper.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static io.Tabskeeper.controller.Constants.NOTES;
import static io.Tabskeeper.controller.Constants.REDIRECT;

@Controller
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    NoteService noteService;

    @GetMapping()
    public String getNote(Model model){
        Iterable iter = noteService.findAll();
        model.addAttribute("notes", iter);
        return "note";
    }
    @PostMapping()
    public String postIndex(@ModelAttribute CreateNote createNote) {
        Note note = new Note();
        note.setTitle(createNote.getTitle());
        note.setBody(createNote.getBody());
        noteService.save(note);

        return REDIRECT + NOTES;
    }
}
