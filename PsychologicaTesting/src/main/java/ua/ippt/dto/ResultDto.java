package ua.ippt.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultDto {
    private String result;
    private String description;
    private String imageUrl;
}
