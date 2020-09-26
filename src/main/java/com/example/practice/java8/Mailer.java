package com.example.practice.java8;

/**
 * @author Incheol Jung
 */
public class Mailer {
    public void from(final String address){ System.out.println("Mailer::from"); }
    public void to(final String address){ System.out.println("Mailer::to"); }
    public void subject(final String subject){ System.out.println("Mailer::subject"); }
    public void body(final String content){ System.out.println("Mailer::body"); }
    public void send(){ System.out.println("Mailer::send"); }

    public static void main(String[] args) {
        Mailer mailer = new Mailer();
        mailer.from("bluesky761@naver.com");
        mailer.to("bluesky761@naver.com");
        mailer.subject("test subject");
        mailer.body("test content");
        mailer.send();
    }
}
