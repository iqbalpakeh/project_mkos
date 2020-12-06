package com.progrema.mkos.controller;

import com.progrema.mkos.entities.room.wrapper.RoomWrapper;
import com.progrema.mkos.services.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {

    private final Logger logger = LoggerFactory.getLogger(RoomController.class);

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/api/rooms")
    public List<RoomWrapper> getRooms() {
        logger.info("getRooms()");
        return roomService.getRooms();
    }
}
