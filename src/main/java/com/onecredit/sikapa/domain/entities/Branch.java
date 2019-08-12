package com.onecredit.sikapa.domain.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter
@Setter
@Table(name = "branch")
public class Branch {
    @Id
    @Column(nullable = false)
//    @GeneratedValue(generator = "branch_id_seq", strategy = GenerationType.SEQUENCE)
//    @SequenceGenerator(name = "branch_id_seq", sequenceName = "branch_id_seq", allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false,unique = true)
    private String area;
    @Column(nullable = false,unique = true)
    private String region;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)

    private List<User> users = new ArrayList<>();

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    public Branch() {
    }

    public Branch(String area, String region) {
        this.area = area;
        this.region = region;
    }
}