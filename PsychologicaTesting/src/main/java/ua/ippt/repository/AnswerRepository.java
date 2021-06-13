package ua.ippt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.ippt.entity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Integer> {
}
