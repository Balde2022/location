package com.ocprojecttree.location.Services.Rental;

import com.ocprojecttree.location.Models.Rental.Dto.CreateRentalDto;
import com.ocprojecttree.location.Models.Rental.Dto.UpdateRentalDto;
import com.ocprojecttree.location.Models.Rental.Rental;
import com.ocprojecttree.location.Models.Rental.RentalResponse;
import com.ocprojecttree.location.Repository.Rental.RentalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final RentalRepository repository;

    @Override
    public List<Rental> all() {
        return repository.findAll();
    }

    @Override
    public Optional<Rental> detail(Long id) {
        return repository.findById(id);
    }

    @Override
    public RentalResponse create(CreateRentalDto rental) {
        Rental rentalPush= new Rental();
        rentalPush.setName(rental.getName());
        rentalPush.setSurface(rental.getSurface());
        rentalPush.setPrice(rental.getPrice());
        rentalPush.setDescription(rental.getDescription());
        rentalPush.setPicture(rental.getPicture());
        Date date = new Date();
        rentalPush.setCreated_at(date);
        rentalPush.setUpdated_at(date);
        rentalPush.setUser(rentalPush.getUser());
        repository.save(rentalPush);
        RentalResponse response = new RentalResponse();
        response.setMessage("Rental created !");
        return response;
    }

    @Override
    public RentalResponse update(Long id, UpdateRentalDto rental) {
        return repository.findById(id).map(
                p -> {
                    p.setName(rental.getName());
                    p.setSurface(rental.getSurface());
                    p.setPrice(rental.getPrice());
                    p.setDescription(rental.getDescription());
                    p.setPicture(p.getPicture());
                    Date date = new Date();
                    p.setCreated_at(p.getCreated_at());
                    p.setUpdated_at(date);
                    p.setUser(p.getUser());
                    p.setId(p.getId());
                    repository.save(p);
                    RentalResponse response = new RentalResponse();
                    response.setMessage("Rental updated !");
                    return response;
                }
        ).orElseThrow();
    }
}
