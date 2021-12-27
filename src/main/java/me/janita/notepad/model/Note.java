package me.janita.notepad.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Note {
    private final UUID id;

    @NotBlank // not " "
    private final String name;

    private final String description;

    public Note(@JsonProperty("id") UUID id,
                @JsonProperty("name") String name,
                @JsonProperty("description") String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
}
