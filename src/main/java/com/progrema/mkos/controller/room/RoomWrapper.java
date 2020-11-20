package com.progrema.mkos.controller.room;

import com.progrema.mkos.entities.Room;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomWrapper {

    private final Room room;

    public RoomWrapper(Room room) {
        this.room = room;
    }

}
