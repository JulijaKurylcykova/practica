package ua.ippt.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerDto {

    private int answerId;
    private String description;
}
