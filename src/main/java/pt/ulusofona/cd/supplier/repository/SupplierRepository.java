package pt.ulusofona.cd.supplier.repository;

import org.springframework.stereotype.Repository;
import pt.ulusofona.cd.supplier.model.Supplier;

import java.util.Optional;

@Repository
public class SupplierRepository extends InMemoryRepository<Supplier> {

    public Optional<Supplier> findBySupplierCodeIgnoreCase(String code) {
        return findAll().stream()
                .filter(p -> p.getSupplierCode().equalsIgnoreCase(code))
                .findFirst();
    }

    public boolean existsBySupplierCodeIgnoreCase(String code) {
        return findBySupplierCodeIgnoreCase(code).isPresent();
    }
}
