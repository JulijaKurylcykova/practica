package ua.ippt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    @Column(name = "question_id")
    private int questionId;

    @Column
    private int sequence;

    @Column
    private String description;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    @ManyToOne
    @JoinColumn(name="test_id", referencedColumnName = "test_id")
    private PsychologicalTest psychologicalTest;
}
