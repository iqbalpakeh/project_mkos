package com.progrema.mkos.repositories;

import com.progrema.mkos.entities.db.Room;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoomRepository extends PagingAndSortingRepository<Room, Long> {
}
