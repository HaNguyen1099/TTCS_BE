package com.quanchun.backendexamsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "quizz")
@Builder
@ToString
public class Quizz {
    @Column(name = "quizz_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "host_id")
    private int hostId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "difficulty")
    private Integer difficulty;
    @Column(name = "created_at")
    @NotNull
    private Date createdAt;
    @Column(name = "started_at")
    private Date startedAt;
    @Column(name = "ended_at")
    private Date endedAt;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "score")
    private Integer score;
    @Column(name = "type")
    private Integer type;
    @Column(name = "subject")
    private String subject;

    @JsonManagedReference
    @OneToMany(mappedBy = "quizz",cascade = CascadeType.ALL)
    //@OneToMany(mappedBy = "quizz",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegisterQuizz> registerQuizzes;

    @ManyToMany(
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH}
    )
    @JoinTable(
            name = "quizzes_questions",
            joinColumns = @JoinColumn(
                    name = "quizz_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "question_id")
    )
    private List<Question> questions;

    public Quizz(int id){
        this.id = id;
    }
//    @ManyToMany(
//            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH}
//    )
//    @JoinTable(
//            name = "take_quizz",
//            joinColumns = @JoinColumn(name = "quizz_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
//    private List<User> users;
    public void addQuestion(Question question)
    {
        if(questions == null)
        {
            questions = new ArrayList<>();
        }
        questions.add(question);
    }

    public void addRegisterQuizz(RegisterQuizz rq)
    {
        if(this.registerQuizzes == null)
        {
            this.registerQuizzes = new ArrayList<>();
        }
        this.registerQuizzes.add(rq);
    }


}
