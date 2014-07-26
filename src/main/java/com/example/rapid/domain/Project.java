package com.example.rapid.domain;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Project")
public class Project extends AbstractEntity {

    /**
     */
    @NotNull
    @Size(min = 2, max = 255)
    private String name;

    /**
     */
    private boolean enabled;
}
