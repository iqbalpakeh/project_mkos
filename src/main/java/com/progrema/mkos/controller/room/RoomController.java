package com.progrema.mkos.controller.room;

import com.progrema.mkos.controller.room.wrapper.RoomWrapper;
import com.progrema.mkos.services.RoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/api/rooms")
    public List<RoomWrapper> getRooms() {
        return roomService.getRooms();
    }
}
