package ua.ippt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tests")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PsychologicalTest {

    @Id
    @Column(name = "test_id")
    private int testId;

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "psychologicalTest" )
    private List<Question> questions;

    @OneToOne
    @JoinColumn(name = "result_id", referencedColumnName = "result_id")
    private Result result;

}
