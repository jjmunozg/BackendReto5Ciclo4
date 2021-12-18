package com.cuatroa.retodos.service;

import com.cuatroa.retodos.model.Cookware;
import com.cuatroa.retodos.repository.CookwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author desaextremo
 */
@Service
public class CookwareService {

    @Autowired
    private CookwareRepository repository;

    public List<Cookware> getAll() {
        return repository.getAll();
    }

    public Optional<Cookware> getClothe(String reference) {
        return repository.getClothe(reference);
    }

    public Cookware create(Cookware accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return repository.create(accesory);
        }
    }

    public Cookware update(Cookware accesory) {

        if (accesory.getReference() != null) {
            Optional<Cookware> accesoryDb = repository.getClothe(accesory.getReference());
            if (!accesoryDb.isEmpty()) {
                if (accesory.getBrand() != null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }

                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }

                if (accesory.getDimensiones() != null) {
                    accesoryDb.get().setDimensiones(accesory.getDimensiones());
                }

                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                repository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getClothe(reference).map(accesory -> {
            repository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }

   // public List<Cookware> productByPrice(double price) {
  //      return repository.productByPrice(price);
    //}

    //Reto 5
    public List<Cookware> productByPrice(double price) {
        return repository.productByPrice(price);
    }

    //Reto 5
    public List<Cookware> findByDescriptionLike(String description) {
        return repository.findByDescriptionLike(description);
    }

}
