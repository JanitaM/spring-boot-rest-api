package me.janita.notepad.dao;

import me.janita.notepad.model.Note;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NoteDao {
    int insertNote(UUID id, Note note);

    default int insertNote(Note note) {
        UUID id = UUID.randomUUID();
        return insertNote(id, note);
    }

    List<Note> getAllNotes();

    Optional<Note> getOneNote(UUID id);

    int deleteNote(UUID id);

    int updateNote(UUID id, Note note); // overwrites everything
}
