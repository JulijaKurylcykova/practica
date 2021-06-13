package ua.ippt.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuestionDto {

    private int questionId;
    private int sequence;
    private String description;
    private List<AnswerDto> answers;
}
