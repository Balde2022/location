package com.ocprojecttree.location.Repository.Rental;

import com.ocprojecttree.location.Models.Rental.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental , Long> {
}
