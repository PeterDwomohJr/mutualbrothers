package com.comcent.mutualbrothers.valueObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Message {

    private String message;
    private LocalDateTime timeCreated = LocalDateTime.now();
}
