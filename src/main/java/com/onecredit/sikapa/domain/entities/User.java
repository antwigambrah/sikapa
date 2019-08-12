package com.onecredit.sikapa.domain.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;



//@Table(name = "\"user\"")
@Table(name = "user")

@Entity
@Getter
@Setter
public class User{

    public enum AccountStatus {
        INACTIVE,
        ACTIVE
    }


    @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String firstname;
    @Column(nullable = true)
    private String middlename;
    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status",nullable = false)
    private  AccountStatus status;

    @Column(nullable = false)
    private String roles = "";
    @Column(nullable = true)
    private String permissions = "";

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<PersonalClient>clients=new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Branch branch;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    public User(String firstname,String middlename,String surname,String username, String password, String roles, String permissions) {
        this.firstname=firstname;
        this.middlename=middlename;
        this.surname=surname;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.permissions = permissions;
        this.status=AccountStatus.ACTIVE;
    }

    public User() {
    }


    public List<String> getRoleList() {
        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList() {
        if (this.permissions.length() > 0) {
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }


}