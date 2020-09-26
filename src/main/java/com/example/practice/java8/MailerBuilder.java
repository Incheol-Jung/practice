package com.example.practice.java8;

/**
 * @author Incheol Jung
 */
public class MailerBuilder {

    public MailerBuilder from(final String address) { System.out.println("Mailer::from"); return this; }
    public MailerBuilder to(final String address) { System.out.println("Mailer::to");  return this; }
    public MailerBuilder subject(final String subject) { System.out.println("Mailer::subject");  return this; }
    public MailerBuilder body(final String content) { System.out.println("Mailer::body");  return this; }
    public void send() { System.out.println("Mailer::send"); }
    public static void main(String[] args) {
        new MailerBuilder().from("bluesky761@naver.com")
                           .to("bluesky761@naver.com")
                           .subject("test subject")
                           .body("test content")
                           .send();
    }
}
