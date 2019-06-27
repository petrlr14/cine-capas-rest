package com.cbrr.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(schema = "public", name = "province")
public class Province {

    @Id
    @GeneratedValue(generator = "province_province_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "province_province_id_seq", sequenceName = "public.province_province_id_seq", allocationSize = 1)
    @Column(name = "province_id")
    private Long provinceId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state_id")
    private State stateId;
    @Column(name = "province_name")
    private String provinceName;
    @Column(name = "province_ak")
    private String provinceAk;

}
