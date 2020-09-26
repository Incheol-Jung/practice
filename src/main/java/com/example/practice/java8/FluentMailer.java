package com.example.practice.java8;

import java.util.function.Consumer;

/**
 * @author Incheol Jung
 */
public class FluentMailer {

    private FluentMailer() {}

    public FluentMailer from(final String address) {
        System.out.println("Mailer::from");
        return this;
    }

    public FluentMailer to(final String address) {
        System.out.println("Mailer::to");
        return this;
    }

    public FluentMailer subject(final String subject) {
        System.out.println("Mailer::subject");
        return this;
    }

    public FluentMailer body(final String content) {
        System.out.println("Mailer::body");
        return this;
    }

    public void send(final Consumer<FluentMailer> block) {
        final FluentMailer mailer = new FluentMailer();
        block.accept(mailer);
        System.out.println("sending....");
    }

    public static void main(String[] args) {
        new FluentMailer().send(mailer -> mailer.from("bluesky761@naver.com")
                                                .to("bluesky761@naver.com")
                                                .subject("test subject")
                                                .body("test content"));
    }
}
