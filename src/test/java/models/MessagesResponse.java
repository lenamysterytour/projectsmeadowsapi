package models;

import lombok.Data;

@Data

public class MessagesResponse {
    String messageid, name, email, phone, subject, description;
}
