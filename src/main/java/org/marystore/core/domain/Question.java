package org.marystore.core.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@ToString
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false)
    private long id;
    @Column(name = "question_text", length = 1024)
    private String text;
    @OneToMany(mappedBy = "question", cascade = {CascadeType.REMOVE})
    private List<Answer> answers;
}
