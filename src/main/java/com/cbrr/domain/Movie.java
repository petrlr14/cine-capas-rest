package com.cbrr.domain;

import com.cbrr.responses.BaseResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "movie", schema = "public")
public class Movie  extends BaseResponse {

    @Id
    @GeneratedValue(generator = "movie_movie_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "movie_movie_id_seq", sequenceName = "public.movie_movie_id_seq", allocationSize = 1)
    @Column(name = "movie_id")
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
    @Column(name = "movie_name")
    private String movieName;
    @Column(name = "movie_poster")
    private String moviePoster;
    @Column(name = "movie_description")
    private String movieDescription;
    @Column(name = "active")
    private Boolean active;

}
