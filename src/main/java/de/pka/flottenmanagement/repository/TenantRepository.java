package de.pka.flottenmanagement.repository;

import de.pka.flottenmanagement.model.Tenant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends CrudRepository<Tenant, Long> {
}
