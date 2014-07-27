package com.example.rapid.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="RapidUser")
public class RapidUser extends AbstractEntity {

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
    @Column(nullable = false, columnDefinition = "BIT default true", name="admin", length = 1)
    private boolean admin;
}
