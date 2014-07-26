package com.example.rapid.domain;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="RapidUser")
public class RapidUser {

    /**
     */
    @NotNull
    @Size(min = 2)
    private String username;

    /**
     */
    @NotNull
    @Size(min = 4)
    private String password;

    /**
     */
    private boolean admin;
}
