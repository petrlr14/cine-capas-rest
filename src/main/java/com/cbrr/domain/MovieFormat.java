package com.cbrr.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "movie_format", schema = "public")
public class MovieFormat {

    @Id
    @GeneratedValue(generator = "movie_format_format_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "movie_format_format_id_seq", sequenceName = "public.movie_format_format_id_seq", allocationSize = 1)
    @Column(name = "format_id")
    private Long formatId;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "created_by_user", referencedColumnName = "user_id")
    private User createdByUser;
    @Transient
    @Getter(value = AccessLevel.NONE) private Long createdByUserID;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "modified_by_user", referencedColumnName = "user_id")
    private User modifiedByUser;
    @Transient
    @Getter(value = AccessLevel.NONE) private Long modifiedByUserID;
    @Column(name = "format_ak")
    private String formatAk;
    @Column(name = "price")
    private BigDecimal price;

    public Long getCreatedByUserID() {
        return this.getCreatedByUser().getUserId();
    }

    public Long getModifiedByUserID(){
        return this.getModifiedByUser().getUserId();
    }
}
