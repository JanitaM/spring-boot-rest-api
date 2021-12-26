package me.janita.notepad.api;

import me.janita.notepad.model.Note;
import me.janita.notepad.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("notes")
@RestController
public class NoteController {
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public void addNote(@Valid @NonNull @RequestBody Note note) {
        noteService.addNote(note);
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping(path = "/{id}")
    public Note getOneNote(@PathVariable("id") UUID id) {
        return noteService
                .getOneNote(id)
                .orElse(null);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteNote(@PathVariable("id") UUID id) {
        noteService.deleteNote(id);
    }

    @PutMapping(path = "/{id}")
    public void updateNote(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Note updatedNote) {
        noteService.updateNote(id, updatedNote);
    }
}
