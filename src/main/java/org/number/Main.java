package org.number;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.number")
public class Main {
  public static void main(String[] args) {
    SpringApplication.run(Main.class,args);
  }
}
