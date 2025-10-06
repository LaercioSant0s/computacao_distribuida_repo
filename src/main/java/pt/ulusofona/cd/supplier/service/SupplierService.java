package pt.ulusofona.cd.supplier.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pt.ulusofona.cd.supplier.exception.SupplierNotFoundException;
import pt.ulusofona.cd.supplier.mapper.SupplierMapper;
import pt.ulusofona.cd.supplier.model.Supplier;
import pt.ulusofona.cd.supplier.model.dto.SupplierRequest;
import pt.ulusofona.cd.supplier.repository.SupplierRepository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository repo;

    public Supplier createSupplier(SupplierRequest request) {
        if (repo.existsBySupplierCodeIgnoreCase(request.getSupplierCode())) {
            throw new IllegalArgumentException("SKU must be unique");
        }

        Supplier supplier = SupplierMapper.toEntity(request);

        supplier.setId(UUID.randomUUID());
        supplier.setCreatedAt(Instant.now());
        supplier.setUpdatedAt(Instant.now());

        return repo.save(supplier);
    }

    public Supplier getSupplierById(UUID id) {
        return repo.findById(id)
                .orElseThrow(() -> new SupplierNotFoundException(id));
    }

    public List<Supplier> getAllSuppliers() {
        return repo.findAll();
    }

    public Supplier updateSupplier(UUID id, SupplierRequest request) {
        Supplier existing = getSupplierById(id);

        existing.setCompanyName(request.getCompanyName().trim());

        if (!existing.getSupplierCode().equalsIgnoreCase(request.getSupplierCode())
                && repo.existsBySupplierCodeIgnoreCase(request.getSupplierCode())) {
            throw new IllegalArgumentException("SKU must be unique");
        }

        existing.setSupplierCode(request.getSupplierCode().trim());
        existing.setEmail(request.getEmail().trim());

        existing.setUpdatedAt(Instant.now());

        return repo.save(existing);
    }

    public void deleteSupplier(UUID id) {
        if (!repo.findById(id).isPresent()) {
            throw new SupplierNotFoundException(id);
        }
        repo.deleteById(id);
    }
}
