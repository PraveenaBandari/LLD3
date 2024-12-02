package org.scaler.book_my_show_sept23morning.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDTO {
    private int userId;
    private ResponseStatus status;
    private String message;
}
