package com.cuatroa.retodos.repository;

import com.cuatroa.retodos.model.Cookware;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cuatroa.retodos.repository.crud.CookwareCrudRepository;

/**
 *
 * @author desaextremo
 */
@Repository
public class CookwareRepository {
    @Autowired
    private CookwareCrudRepository repository;

    public List<Cookware> getAll() {
        return repository.findAll();
    }

    public Optional<Cookware> getClothe(String reference) {
        return repository.findById(reference);
    }
    
    public Cookware create(Cookware clothe) {
        return repository.save(clothe);
    }

    public void update(Cookware clothe) {
        repository.save(clothe);
    }
    
    public void delete(Cookware clothe) {
        repository.delete(clothe);
    }
    
    public List<Cookware> productByPrice(double precio) {
	return repository.findByPriceLessThanEqual(precio);
}

    public List<Cookware> findByDescriptionLike(String description) {
        return repository.findByDescriptionLike(description);
    }
}
