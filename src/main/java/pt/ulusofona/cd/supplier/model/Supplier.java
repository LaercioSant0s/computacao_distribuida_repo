package pt.ulusofona.cd.supplier.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import pt.ulusofona.cd.supplier.repository.Identifiable;

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
    @Email
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