package com.ocprojecttree.location.Models.Message;

import com.ocprojecttree.location.Models.Rental.Rental;
import com.ocprojecttree.location.Models.Users.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "MESSAGE")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String message;
    private Date created_at;
    private Date updated_at;
}
