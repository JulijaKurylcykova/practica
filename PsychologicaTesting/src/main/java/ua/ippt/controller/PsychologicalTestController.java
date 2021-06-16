package ua.ippt.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.ippt.dto.PsychologicalTestDto;
import ua.ippt.dto.ResultDto;
import ua.ippt.dto.TestQuestionDto;
import ua.ippt.dto.UserAnswersDtoList;
import ua.ippt.service.PsychologicalTestService;

import java.util.List;

@RestController
@RequestMapping("/tests")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class PsychologicalTestController {
    private final PsychologicalTestService psychologicalTestService;

    @GetMapping
    public List<PsychologicalTestDto> getAllTests() {
        return psychologicalTestService.getAllTests();
    }

    @GetMapping("/{id}")
    public TestQuestionDto getTestById(@PathVariable int id) {
        return psychologicalTestService.getTestById(id);
    }

    @PostMapping("/{id}")
    public ResultDto checkUserAnswers(@PathVariable("id") final int testId,
                                      @RequestBody UserAnswersDtoList userAnswersDtoList) {
        return psychologicalTestService.checkResults(testId, userAnswersDtoList);
    }
}
