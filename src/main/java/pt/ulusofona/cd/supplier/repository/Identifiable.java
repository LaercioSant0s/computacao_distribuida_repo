package pt.ulusofona.cd.supplier.repository;

import java.util.UUID;

public interface Identifiable {
    UUID getId();
    void setId(UUID id);
}
