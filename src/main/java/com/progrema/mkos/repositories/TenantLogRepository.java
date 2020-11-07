package com.progrema.mkos.repositories;

import com.progrema.mkos.entities.db.TenantLog;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TenantLogRepository extends PagingAndSortingRepository<TenantLog, Long> {
}
