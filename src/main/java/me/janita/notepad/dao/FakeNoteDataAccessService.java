package me.janita.notepad.dao;

import me.janita.notepad.model.Note;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// add real DB
@Repository("fakeDao") // dependency injection
public class FakeNoteDataAccessService implements NoteDao {
    private static List<Note> DB = new ArrayList<>();

    @Override
    public int insertNote(UUID id, Note note) { // Bool to get true/false?
        DB.add(new Note(id, note.getName(), note.getDescription()));
        return 1; // Bool to get true/false?
    }

    @Override
    public List<Note> getAllNotes() {
        return DB;
    }

    @Override
    public Optional<Note> getOneNote(UUID id) {
        return DB
                .stream()
                .filter(note -> note.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteNote(UUID id) {
        Optional<Note> noteMaybe = getOneNote(id);
        if (noteMaybe.isEmpty()) return 0;

        DB.remove(noteMaybe.get());
        return 1;
    }

    @Override
    public int updateNote(UUID id, Note noteToUpdate) {
        return getOneNote(id)
                .map(note -> {
                    int indexOfNoteToUpdate = DB.indexOf(note);
                    if (indexOfNoteToUpdate >= 0) {
                        DB.set(indexOfNoteToUpdate, new Note(id, noteToUpdate.getName(), noteToUpdate.getDescription()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
