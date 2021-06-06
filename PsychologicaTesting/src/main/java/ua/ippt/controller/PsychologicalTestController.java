package ua.ippt.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.ippt.dto.PsychologicalTestDto;
import ua.ippt.service.PsychologicalTestService;

import java.util.List;

@RestController
@RequestMapping("/tests")
@AllArgsConstructor
public class PsychologicalTestController {

    private final PsychologicalTestService psychologicalTestService;

    @GetMapping
    public List<PsychologicalTestDto> getAllTests(){

        return psychologicalTestService.getAllTests();
    }
}
