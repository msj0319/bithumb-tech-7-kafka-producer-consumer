package net.msj0319.api.producer.domain;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data @NoArgsConstructor
public class User {
    private String id;
    private String name;
    private String email;

    @Override
    public String toString() {
        return String.format("%s, %s, %s\n", id, name, email);
    }

}