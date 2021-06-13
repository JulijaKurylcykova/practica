package ua.ippt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.ippt.entity.PsychologicalTest;
import ua.ippt.entity.Question;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {

    List<Question> getByPsychologicalTest(PsychologicalTest psychologicalTest);
}
