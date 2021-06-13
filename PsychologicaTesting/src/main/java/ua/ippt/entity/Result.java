package ua.ippt.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "results")
public class Result {

    @Id
    @Column(name = "result_id")
    private int resultId;

    @Column
    private String lowDescription;

    @Column
    private String lowImageUrl;

    @Column
    private String midDescription;

    @Column
    private String midImageUrl;

    @Column
    private String highDescription;

    @Column
    private String highImageUrl;

    @OneToOne(mappedBy = "result")
    private PsychologicalTest psychologicalTest;
}
