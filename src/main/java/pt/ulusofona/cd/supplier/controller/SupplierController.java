package pt.ulusofona.cd.supplier.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import pt.ulusofona.cd.supplier.mapper.SupplierMapper;
//import pt.ulusofona.cd.supplier.service.SupplierService;

import pt.ulusofona.cd.supplier.mapper.SupplierMapper;
import pt.ulusofona.cd.supplier.model.Supplier;
import pt.ulusofona.cd.supplier.model.dto.SupplierRequest;
import pt.ulusofona.cd.supplier.model.dto.SupplierResponse;
import pt.ulusofona.cd.supplier.service.SupplierService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/supplier")
public class SupplierController {

    private final SupplierService service;

    public SupplierController(SupplierService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SupplierResponse> create(
            @Valid @RequestBody SupplierRequest request
    ) {
        Supplier created = service.createSupplier(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(SupplierMapper.toResponse(created));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierResponse> getById(@PathVariable UUID id) {
        Supplier supplier = service.getSupplierById(id);
        return ResponseEntity.ok(SupplierMapper.toResponse(supplier));
    }

    @GetMapping
    public ResponseEntity<List<SupplierResponse>> getAll() {
        List<Supplier> products = service.getAllSuppliers();
        List<SupplierResponse> responseList = products.stream()
                .map(SupplierMapper::toResponse)
                .toList();

        return ResponseEntity.ok(responseList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierResponse> update(
            @PathVariable UUID id,
            @Valid @RequestBody SupplierRequest request
    ) {
        Supplier updated = service.updateSupplier(id, request);
        return ResponseEntity.ok(SupplierMapper.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }
}
