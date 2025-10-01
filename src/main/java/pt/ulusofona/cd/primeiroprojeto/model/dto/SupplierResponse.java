package pt.ulusofona.cd.primeiroprojeto.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class SupplierResponse {
    private UUID id;
    private String companyName;
    private String supplierCode;
    private String email;
    private String phone;
    private String address;

    // Active status (to soft delete)
    private Boolean active;
}
