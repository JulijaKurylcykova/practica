package ua.ippt.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PsychologicalTestDto {
    private int id;
    private String name;
}
