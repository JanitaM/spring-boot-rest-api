package me.janita.notepad.service;

import me.janita.notepad.dao.NoteDao;
import me.janita.notepad.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NoteService {
    private final NoteDao noteDao;

    @Autowired
    public NoteService(@Qualifier("fakeDao") NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public int addNote(Note note) {
        return noteDao.insertNote(note); // id auto generated
    }

    public List<Note> getAllNotes() {
        return noteDao.getAllNotes();
    }

    public Optional<Note> getOneNote(UUID id) {
        return noteDao.getOneNote(id);
    }

    public int deleteNote(UUID id) {
        return noteDao.deleteNote(id);
    }

    public int updateNote(UUID id, Note newNote) {
        return noteDao.updateNote(id, newNote);
    }
}
