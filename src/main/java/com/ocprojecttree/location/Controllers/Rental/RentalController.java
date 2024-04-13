package com.ocprojecttree.location.Controllers.Rental;

import com.ocprojecttree.location.Models.Rental.Dto.CreateRentalDto;
import com.ocprojecttree.location.Models.Rental.Dto.UpdateRentalDto;
import com.ocprojecttree.location.Models.Rental.Rental;
import com.ocprojecttree.location.Models.Rental.RentalResponse;
import com.ocprojecttree.location.Services.Rental.RentalService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/rentals")
@Tag(name = "rentals")
@SecurityRequirement(name = "bearerAuth")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping()
    public List<Rental> all(){
        return rentalService.all();
    }

    @GetMapping("/{id}")
    public Optional<Rental> detail(@PathVariable Long id){
        return rentalService.detail(id);
    }

    @PostMapping()
    public RentalResponse create(CreateRentalDto rental){
        return rentalService.create(rental);
    }

    @PutMapping("/{id}")
    public RentalResponse update(@PathVariable Long id, UpdateRentalDto rental){
        return rentalService.update(id,rental);
    }
}
