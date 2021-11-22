package de.ur.remex.model.experiment;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExperimentGroup {

    @JsonProperty("name")
    private final String name;
    @JsonProperty("startTimeInMillis")
    private long startTimeInMillis;
    @JsonProperty("surveys")
    private final ArrayList<Survey> surveys;

    @JsonCreator
    public ExperimentGroup(@JsonProperty("name") String name,
                           @JsonProperty("startTimeInMillis") long startTimeInMillis,
                           @JsonProperty("surveys") ArrayList<Survey> surveys) {
        this.name = name;
        this.startTimeInMillis = startTimeInMillis;
        this.surveys = surveys;
    }

    public void setStartTimeInMillis(long startTimeInMillis) {
        this.startTimeInMillis = startTimeInMillis;
    }

    public long getStartTimeInMillis() {
        return startTimeInMillis;
    }

    public Survey getFirstSurvey() {
        for (Survey survey: surveys) {
            if (survey.getPreviousSurveyId() == 0) {
                return survey;
            }
        }
        return null;
    }

    public Survey getSurveyById(int surveyId) {
        for (Survey survey: surveys) {
            if (surveyId == survey.getId()) {
                return survey;
            }
        }
        return null;
    }

    public ArrayList<Survey> getSurveys() {
        return surveys;
    }

    public String getName() {
        return name;
    }
}
