package pt.ulusofona.cd.supplier.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SupplierResponse {
    private UUID id;
    private String companyName;
    // Unique identifier for the supplier (like VAT, CNPJ, etc.)
    private String supplierCode;

    // Contact email
    private String email;

    // Contact phone
    private String phone;

    // Physical address
    private String address;

    // Active status (to soft delete)
    private Boolean active;
}