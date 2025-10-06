package pt.ulusofona.cd.supplier.mapper;
import pt.ulusofona.cd.supplier.model.Supplier;
import pt.ulusofona.cd.supplier.model.dto.SupplierRequest;
import pt.ulusofona.cd.supplier.model.dto.SupplierResponse;

public class SupplierMapper {

    //Processes the httpbody request to a object that can be stored
    public static Supplier toEntity(SupplierRequest dto) {
        Supplier p = new Supplier();
        p.setCompanyName(dto.getCompanyName().trim());
        p.setSupplierCode(dto.getSupplierCode().trim());
        p.setEmail(dto.getEmail().trim());
        p.setPhone(dto.getPhone().trim());
        p.setAddress(dto.getAddress().trim());
        p.setActive(true);
        return p;
    }

    //Answers the request with a response. Object that was is in DB.
    public static SupplierResponse toResponse(Supplier entity) {
        SupplierResponse r = new SupplierResponse();
        r.setId(entity.getId());
        r.setCompanyName(entity.getCompanyName().trim());
        r.setSupplierCode(entity.getSupplierCode().trim());
        r.setEmail(entity.getEmail().trim());
        r.setPhone(entity.getPhone().trim());
        r.setAddress(entity.getAddress().trim());
        r.setActive(true);
        return r;
    }
}
