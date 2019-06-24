package com.cbrr.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(schema = "public", name = "state")
public class State {

    @Id
    @GeneratedValue(generator = "state_state_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "state_state_id_seq", sequenceName = "public.state_state_id_seq", allocationSize = 1)
    @Column(name = "state_id")
    private Long stateId;
    @Column(name = "state_name")
    private String stateName;
    @Column(name = "state_ak")
    private String stateAk;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country countryId;

}
