package ua.ippt.util;

import ua.ippt.dto.AnswerDto;
import ua.ippt.dto.PsychologicalTestDto;
import ua.ippt.dto.QuestionDto;
import ua.ippt.dto.TestQuestionDto;
import ua.ippt.entity.Answer;
import ua.ippt.entity.PsychologicalTest;
import ua.ippt.entity.Question;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public static TestQuestionDto convertTestQuestionDto(List<Question> questions, PsychologicalTest test) {
        return TestQuestionDto.builder().name(test.getName())
                .description(test.getDescription())
                .imageUrl(test.getImageUrl())
                .questions(convertToQuestionDtoList(questions)).build();
    }

    public static List<QuestionDto> convertToQuestionDtoList(List<Question> questions) {
        return questions.stream().map(Converter::convertToQuestionDto).collect(Collectors.toList());
    }

    public static QuestionDto convertToQuestionDto(final Question question){
        return QuestionDto.builder().questionId(question.getQuestionId())
                .description(question.getDescription())
                .sequence(question.getSequence())
                .answers(convertToAnswerDtoList(question.getAnswers())).build();
    }

    public static List<AnswerDto> convertToAnswerDtoList(List<Answer> answers) {
        return answers.stream().map(Converter::convertToAnswerDto).collect(Collectors.toList());
    }

    public static AnswerDto convertToAnswerDto(final Answer answer){
        return AnswerDto.builder().answerId(answer.getAnswerId()).description(answer.getDescription()).build();
    }

    public static PsychologicalTestDto convertTestsToDto(final PsychologicalTest test){
        return PsychologicalTestDto.builder().id(test.getTestId()).name(test.getName()).build();
    }
}
