package com.ocprojecttree.location.Models.Rental;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ocprojecttree.location.Models.Users.User;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
@Entity
@Data
@Table(name = "rentals")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer surface;
    private Integer price;
    private String picture;
    private String description;
    @OneToOne
    @JoinColumn(name = "owner_id")
    private User user;
    @CreatedDate
    @Column(nullable = false,updatable = false)
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date created_at;
    @LastModifiedDate
    @Column(insertable = false)
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date updated_at;
}
