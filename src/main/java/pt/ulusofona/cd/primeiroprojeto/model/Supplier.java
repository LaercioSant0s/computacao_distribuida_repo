package pt.ulusofona.cd.primeiroprojeto.model;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import pt.ulusofona.cd.primeiroprojeto.repository.Identifiable;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class Supplier implements Identifiable {
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

    //todo: study Instant class. Seems to auto store creation and update date when obj. modified
    private Instant createdAt;
    private Instant updatedAt;
}