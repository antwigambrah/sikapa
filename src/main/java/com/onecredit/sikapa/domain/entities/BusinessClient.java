package com.onecredit.sikapa.domain.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "business_client")
@Getter
@Setter
public class BusinessClient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,  generator="native")
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String businessName;
    @Column(nullable = false)
    private String businessType;
    @Column(nullable = false)
    private String businessSector;
    @Column(nullable = false)
    private String businessProducts;
    @Type(type = "date")
    @Column(nullable = false)
    private Date dateOfIncorporation;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;
    @Column(nullable = false)
    @Embedded
    private Client personal;
    @CreationTimestamp
    @Column(nullable = false)
    private Date createdAt;
    @UpdateTimestamp
    @Column(nullable = false)
    private Date updatedAt;

    public BusinessClient(String businessName, String businessType, String businessSector, String businessProducts, Date dateOfIncorporation, User user, Client personal) {
        this.businessName = businessName;
        this.businessType = businessType;
        this.businessSector = businessSector;
        this.businessProducts = businessProducts;
        this.dateOfIncorporation = dateOfIncorporation;
        this.personal = personal;
    }

    public BusinessClient(){

    }
}
