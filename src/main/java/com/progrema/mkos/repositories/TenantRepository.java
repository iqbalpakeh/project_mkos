package com.progrema.mkos.repositories;

import com.progrema.mkos.entities.db.Tenant;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TenantRepository extends PagingAndSortingRepository<Tenant, Long> {
}
