package ua.ippt.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TestQuestionDto {

    private String name;
    private String description;
    private String imageUrl;
    List<QuestionDto> questions;
}
