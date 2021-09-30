package com.task345;

import org.springframework.stereotype.Component;

@Component
public class JavaScriptProgramming implements Programming {
    @Override
    public void programming() {
        System.out.println("Interested in JavaScript Programming!");
    }
}

