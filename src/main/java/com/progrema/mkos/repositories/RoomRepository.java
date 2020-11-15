package com.progrema.mkos.repositories;

import com.progrema.mkos.entities.model.Room;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RoomRepository extends PagingAndSortingRepository<Room, Long> {

    List<Room> findByRoomNumber(String roomNUmber);

}
