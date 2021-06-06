package ua.ippt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.ippt.entity.PsychologicalTest;

@Repository
public interface PsychologicalTestRepository extends JpaRepository<PsychologicalTest,Integer> {
}
