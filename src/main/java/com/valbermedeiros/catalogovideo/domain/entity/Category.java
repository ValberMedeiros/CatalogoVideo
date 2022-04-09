package com.valbermedeiros.catalogovideo.domain.entity;

import com.valbermedeiros.catalogovideo.domain.exception.NotBlankException;
import com.valbermedeiros.catalogovideo.domain.exception.NotNullException;

import java.util.UUID;

public class Category {

    private UUID id;
    private String name;
    private String description;
    private Boolean isActive = true;

    public Category(UUID id, String name, String description) {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
    }

    public Category(String name, String description) {
        this.id = UUID.randomUUID();
        this.setName(name);
        this.setDescription(description);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new NotNullException("Can not be null");
        }
        if (name.isEmpty()) {
            throw new NotBlankException("Can not be empty");
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public Boolean active() {
        return this.isActive = true;
    }

    public Boolean deactivate() {
        return this.isActive = false;
    }

    public void update(String name, String description, Boolean isActive) {
        this.setName(name);
        this.setDescription(description);
        if (isActive != null && isActive != this.isActive) {
            if (isActive) {
                this.active();
            } else {
                this.deactivate();
            }
        }
    }
}
