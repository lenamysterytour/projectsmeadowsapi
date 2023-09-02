package models;

import lombok.Data;

@Data

public class MessagesRequest {

    String messageid, name, email, phone, subject, description;
}
