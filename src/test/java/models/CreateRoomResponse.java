package models;

import lombok.Data;

import java.util.List;
@Data

public class CreateRoomResponse {
    String roomName, type, descripion, image, roomPrice;
    boolean accessible;
    int roomid;
    private List<String> features;
}
