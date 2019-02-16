package com.lambdaschool.javacities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

// Serializable makes data from object blob readable
import java.io.Serializable;

// makes getters and setters
@Data
public class AeCityMessage implements Serializable
{
    private final String text;
    private final int priority;
    private final boolean secret;

    public AeCityMessage(@JsonProperty String text, @JsonProperty int priority, @JsonProperty boolean secret)
    {
        this.text = text;
        this.priority = priority;
        this.secret = secret;
    }
}
