package io.github.lsj8367.demo.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "newMessage")
public class Message {
    private String text;
}