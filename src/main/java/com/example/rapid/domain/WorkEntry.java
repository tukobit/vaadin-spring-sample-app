package com.example.rapid.domain;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="WorkEntry")
public class WorkEntry {

    /**
     */
    @Size(max = 255)
    private String comment;

    /**
     */
    @NotNull
    @ManyToOne
    private Project project;

    /**
     */
    @NotNull
    @ManyToOne
    private RapidUser employee;

    /**
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date startTime;
}
