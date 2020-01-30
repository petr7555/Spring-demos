package com.example.demo;

/**
 * @author Petr Janik 485122
 * @since 31/07/2019
 */
public class MyPongResponse {
    private String text;

    public MyPongResponse(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
