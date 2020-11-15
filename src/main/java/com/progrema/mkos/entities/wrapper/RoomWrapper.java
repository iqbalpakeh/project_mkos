package com.progrema.mkos.entities.wrapper;

import com.progrema.mkos.entities.model.Room;
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
