package online.automationintesting.models;

import lombok.Data;

import java.util.List;

@Data

public class CreateRoomBody {
    String roomName, type, description, image, roomPrice;
    boolean accessible;
    List<String> features;

}

