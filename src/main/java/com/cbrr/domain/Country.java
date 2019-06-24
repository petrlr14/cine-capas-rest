package com.cbrr.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(schema = "public", name = "country")
public class Country {

    @Id
    @GeneratedValue(generator = "country_country_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "country_country_id_seq", sequenceName = "public.country_country_id_seq", allocationSize = 1)
    @Column(name = "country_id")
    private Long countryId;
    @Column(name = "country_name")
    private String countryName;
    @Column(name = "country_ak")
    private String countryAk;

}

