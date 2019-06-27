package com.cbrr.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(schema = "public", name = "function")
public class Function {

    @Id
    @GeneratedValue(generator = "function_function_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "function_function_id_seq", sequenceName = "public.function_function_id_seq", allocationSize = 1)
    @Column(name = "function_id")
    private Long functionId;
    @Column(name = "created_by_user")
    private Long createdByUser;
    @Column(name = "modified_by_user")
    private Long modifiedByUser;
    @Column(name = "movie_id")
    private Long movieId;
    @Column(name = "schedule_id")
    private Long scheduleId;
    @Column(name = "format_id")
    private Long formatId;
    @Column(name = "lounge_id")
    private Long loungeId;
    @Column(name = "seats")
    private Long seats;
}
