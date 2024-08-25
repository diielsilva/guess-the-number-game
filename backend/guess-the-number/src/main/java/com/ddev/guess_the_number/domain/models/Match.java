package com.ddev.guess_the_number.domain.models;

import java.util.ArrayList;
import java.util.List;

public class Match {

    public String id;
    public Answer answer;
    public List<Attempt> attempts = new ArrayList<>();

    public Match(Answer answer) {
        this.answer = answer;
    }

    public Match(String id, Answer answer) {
        this.id = id;
        this.answer = answer;
    }

}
