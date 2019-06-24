package com.cbrr.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "schedule", schema = "public")
public class Schedule {

    @Id
    @GeneratedValue(generator = "schedule_schedule_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "schedule_schedule_id_seq", sequenceName = "public.schedule_schedule_id_seq", allocationSize = 1)
    @Column(name = "schedule_id")
    private Long movieId;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "created_by_user", referencedColumnName = "user_id")
    private User createdByUser;
    @Transient
    private Long createdByUserID;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "modified_by_user", referencedColumnName = "user_id")
    private User modifiedByUser;
    @Transient
    private Long modifiedByUserID;
    @Column(name = "schedule")
    private String schedule;


}
