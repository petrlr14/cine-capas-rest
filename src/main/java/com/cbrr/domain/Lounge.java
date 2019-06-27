package com.cbrr.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(schema = "public", name = "lounge")
public class Lounge {
    @Id
    @GeneratedValue(generator = "lounge_lounge_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "lounge_lounge_id_seq", sequenceName = "public.lounge_lounge_id_seq", allocationSize = 1)
    @Column(name = "lounge_id")
    private Long loungeId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "created_by_user")
    @JsonIgnore
    private User createdByUser;
    @Transient
    @Getter(AccessLevel.NONE)
    private Long createdByUserID;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "modified_by_user")
    @JsonIgnore
    private User modifiedByUser;
    @Transient
    @Getter(AccessLevel.NONE)
    private Long modifiedByUserID;
    @Column(name = "lounge_capacity")
    private Integer capacity;

    public Long getCreatedByUserID() {
        return this.getCreatedByUser().getUserId();
    }

    public Long getModifiedByUserID(){
        return this.getModifiedByUser().getUserId();
    }

}
