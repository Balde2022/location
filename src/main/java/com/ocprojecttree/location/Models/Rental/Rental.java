package com.ocprojecttree.location.Models.Rental;

import jakarta.persistence.*;
import lombok.Data;

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
    private Long owner_id;
    private Date created_at;
    private Date updated_at;
}
