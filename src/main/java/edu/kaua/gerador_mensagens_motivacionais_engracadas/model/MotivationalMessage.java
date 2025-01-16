package edu.kaua.gerador_mensagens_motivacionais_engracadas.model;

import jakarta.persistence.*;

@Entity
public class MotivationalMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(nullable = false)
    private String message;

    private String author;

    public MotivationalMessage() {}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
