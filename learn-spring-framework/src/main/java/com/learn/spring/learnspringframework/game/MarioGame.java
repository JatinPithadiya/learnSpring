package com.learn.spring.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class MarioGame implements GamingConsole {

    public void up() {
    System.out.println("go up");
    }

    public void down() {
        System.out.println("go down");
    }

    public void left() {
        System.out.println("go left");
    }

    public void right() {
        System.out.println("go right");
    }

}
