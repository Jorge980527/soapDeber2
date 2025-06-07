package soap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soap.model.Package;

public interface PackageRepository extends JpaRepository<Package, String> {
}

