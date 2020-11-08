package com.progrema.mkos.repositories;

import com.progrema.mkos.entities.db.Room;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RoomRepository extends PagingAndSortingRepository<Room, Long> {

    List<Room> findByRoomNumber(String roomNUmber);

}
