package pt.ulusofona.cd.primeiroprojeto.model.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class SupplierRequest {
    private UUID id;

    @NotBlank
    @Size(min = 3, max = 120)
    private String companyName;

    // Unique identifier for the supplier (like VAT, CNPJ, etc.)
    private String supplierCode;

    // Contact email
    private String email;

    // Contact phone
    private String phone;

    @NotBlank
    // Physical address
    private String address;

    // Active status (to soft delete)
    private Boolean active;
}