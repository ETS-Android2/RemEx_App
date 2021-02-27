package de.ur.remex.model.experiment.questionnaire;

import java.util.ArrayList;

import de.ur.remex.model.experiment.Step;
import de.ur.remex.model.experiment.StepType;

public class Questionnaire extends Step {

    // RemEx Interface: For below attributes create two hidden instructions, one before and one after the questionnaire step.
    // instructionText
    // instructionHeader
    // dischargeText
    // dischargeHeader
    private ArrayList<Question> questions;

    public Questionnaire() {
        type = StepType.QUESTIONNAIRE;
        questions = new ArrayList<>();
    }

    public Question getFirstQuestion() {
        return questions.get(0);
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }
}
