package com.ocprojecttree.location.Services.Rental;

import com.ocprojecttree.location.Models.Rental.Dto.CreateRentalDto;
import com.ocprojecttree.location.Models.Rental.Dto.UpdateRentalDto;
import com.ocprojecttree.location.Models.Rental.Rental;
import com.ocprojecttree.location.Models.Rental.RentalResponse;

import java.util.List;
import java.util.Optional;

public interface RentalService {
    List<Rental> all();
    Optional<Rental> detail(Long id);
    RentalResponse create(CreateRentalDto rental);
    RentalResponse update(Long id , UpdateRentalDto rental);



}
