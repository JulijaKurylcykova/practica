package ua.ippt.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.ippt.dto.PsychologicalTestDto;
import ua.ippt.dto.ResultDto;
import ua.ippt.dto.TestQuestionDto;
import ua.ippt.dto.UserAnswersDtoList;
import ua.ippt.entity.Result;
import ua.ippt.enumeration.PsychoResult;
import ua.ippt.repository.PsychologicalTestRepository;
import ua.ippt.repository.QuestionRepository;
import ua.ippt.util.Converter;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PsychologicalTestService {

    private static final String RESULT_MESSAGE = "Ваш результат %s відсотків";

    private final PsychologicalTestRepository psychologicalTestRepository;
    private final QuestionRepository questionRepository;


    public List<PsychologicalTestDto> getAllTests() {
        var allTests = psychologicalTestRepository.findAll();
        return allTests.stream().map(Converter::convertTestsToDto).collect(Collectors.toList());
    }

    public TestQuestionDto getTestById(int id) {
        var test = psychologicalTestRepository.getById(id);
        var allQuestions = questionRepository.getByPsychologicalTest(test);
        return Converter.convertTestQuestionDto(allQuestions, test);
    }

    public ResultDto checkResults(int testId, UserAnswersDtoList userAnswersDtoList) {
        final var test = psychologicalTestRepository.getById(testId);
        var count = test.getQuestions().size();
        var rightQuestionCount = getRightQuestionCount(userAnswersDtoList);

        var percentage = calculatePercentage(rightQuestionCount, count);
        return populateResult(test.getResult(), percentage);
    }

    private int getRightQuestionCount(UserAnswersDtoList userAnswersDtoList) {
        var userAnswerDtoList = userAnswersDtoList.getAnswers();
        return Math.toIntExact(userAnswerDtoList.stream().filter(userAnswerDto ->
                isRightAnswer(userAnswerDto.getQuestionId(), userAnswerDto.getAnswerId()))
                .count());
    }

    private boolean isRightAnswer(int questionId, int answerId) {
        var question = questionRepository.getById(questionId);
        return question.getAnswers().stream()
                .anyMatch(answer -> answer.getAnswerId() == answerId);
    }

    private int calculatePercentage(int rightQuestionCount, int totalQuestionCount) {
        return Math.round((rightQuestionCount * 100f) / totalQuestionCount);
    }

    private ResultDto populateResult(Result result, int percentage) {
        var description = "";
        var imageUrl = "";

        var psychoResult = getPsychoResult(percentage);

        switch (psychoResult) {
            case LOW:
                description = result.getLowDescription();
                imageUrl = result.getLowImageUrl();
                break;
            case MIDDLE:
                description = result.getMidDescription();
                imageUrl = result.getMidImageUrl();
                break;
            case HIGH:
                description = result.getHighDescription();
                imageUrl = result.getHighImageUrl();
                break;
        }
        return ResultDto.builder().result(String.format(RESULT_MESSAGE,percentage)).description(description).imageUrl(imageUrl).build();
    }

    private PsychoResult getPsychoResult(int percentage) {

        if (percentage < 35) {
            return PsychoResult.LOW;
        } else if (percentage < 75) {
            return PsychoResult.MIDDLE;
        } else {
            return PsychoResult.HIGH;
        }
    }
}

