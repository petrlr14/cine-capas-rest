package com.cbrr.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(schema = "public", name = "user_rol")
public class Rol {

    @Id
    @GeneratedValue(generator = "user_rol_rol_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "user_rol_rol_id_seq", sequenceName = "public.user_rol_rol_id_seq", allocationSize = 1)
    @Column(name = "rol_id")
    private Long rolId;
    @Column(name = "rol_name")
    private String rolName;
    @Column(name = "rol_ak")
    private String rolAk;

}