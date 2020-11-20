package com.progrema.mkos.repositories;

import com.progrema.mkos.entities.tenant.Tenant;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TenantRepository extends PagingAndSortingRepository<Tenant, Long> {

    List<Tenant> findByTenantName(String name);

}
