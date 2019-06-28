package com.cbrr.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(schema = "public", name = "user_account")
@JsonIgnoreProperties({"accountNonExpired", "accountNonLocked", "credentialsNonExpired", "enabled", "password", "authorities", "countryId", "countryId", "stateId"})
public class User implements UserDetails {

    /**
     *
     */
    private static final long serialVersionUID = 2427238057150579366L;

    @Id
    @GeneratedValue(generator = "user_account_user_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "user_account_user_id_seq", sequenceName = "public.user_account_user_id_seq", allocationSize = 1)
    @Column(name = "user_id")
    private Long userId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Country countryId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id")
    private Rol rolId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state_id")
    private State stateId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "province_id")
    private Province provinceId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Temporal(TemporalType.DATE)
    @JsonIgnore
    private Calendar birthday;
    @Getter(AccessLevel.NONE)
    @JsonProperty("birthday")
    private String birthDay;
    private String username;
    @JsonIgnore
    @Column(name = "pass_word")
    private String passWord;
    private String address;
    private BigDecimal balance;
    @Column(name = "user_active_state")
    private Boolean userState;
    @Column(name = "user_blocked_state")
    private Boolean userBlockedState;
    @Column(name = "block_cause")
    private String blockCause;
    @Column(name = "user_logged")
    private Boolean userLogged;

    public boolean hasRoles(String rol) {
        return this.getRolId().getRolAk().equals(rol);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (hasRoles("ADM")) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADM"));
        } else {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_CLI"));
        }
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.userBlockedState;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.userBlockedState;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return userState;
    }

    /*Custom getters and setters*/
    public String getBirthDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        Date date = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String birth_day = null;
        try {
            birth_day = format.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return birth_day;
    }

}