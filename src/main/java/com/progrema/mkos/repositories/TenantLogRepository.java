package com.progrema.mkos.repositories;

import com.progrema.mkos.entities.model.TenantLog;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TenantLogRepository extends PagingAndSortingRepository<TenantLog, Long> {

    List<TenantLog> findByCheckin(long checkin);

}
