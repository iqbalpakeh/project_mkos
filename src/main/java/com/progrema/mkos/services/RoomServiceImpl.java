package com.progrema.mkos.services;

import com.progrema.mkos.entities.wrapper.RoomWrapper;
import com.progrema.mkos.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<RoomWrapper> getRooms() {
        List<RoomWrapper> roomWrappers = new ArrayList<>();
        roomRepository.findAll().forEach(room -> {
            roomWrappers.add(new RoomWrapper(room));
        });
        return roomWrappers;
    }

}
