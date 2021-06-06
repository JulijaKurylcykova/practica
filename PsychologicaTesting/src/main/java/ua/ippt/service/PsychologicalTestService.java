package ua.ippt.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.ippt.dto.PsychologicalTestDto;
import ua.ippt.entity.PsychologicalTest;
import ua.ippt.repository.PsychologicalTestRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PsychologicalTestService {

    private final PsychologicalTestRepository repository;

    public List<PsychologicalTestDto> getAllTests(){

       var allTests =  repository.findAll();
       return allTests.stream().map(this::convertTestToDto).collect(Collectors.toList());

    }

    private PsychologicalTestDto convertTestToDto(final PsychologicalTest test){
        return PsychologicalTestDto.builder().id(test.getTestId()).name(test.getName()).build();
    }
}
