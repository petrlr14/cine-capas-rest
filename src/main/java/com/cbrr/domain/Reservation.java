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
@Table(name = "movie_reservation", schema = "public")
public class Reservation {

    @Id
    @GeneratedValue(generator = "movie_movie_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "movie_movie_id_seq", sequenceName = "public.movie_movie_id_seq", allocationSize = 1)
    @Column(name = "movie_reservation_id")
    private Long reservationId;
    @OneToOne
    @JoinColumn(name = "movie_id")
    @JsonIgnore
    private Movie movie;
    @Transient
    private Long movieId;
    @OneToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;
    @Transient
    private Long scheduleId;
    @OneToOne
    @JoinColumn(name = "movie_format_id")
    private MovieFormat movieFormat;
    @Transient
    private Long movieFormatId;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Transient
    private Long UserId;
}
