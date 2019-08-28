package com.shenkh.notebook.jasyptencryption;

import com.shenkh.notebook.jasyptencryption.command.Commands;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JasyptEncryptionApplication implements CommandLineRunner {
  private Commands commands;

  public JasyptEncryptionApplication(Commands commands) {
    this.commands = commands;
  }

  public static void main(String[] args) {
    SpringApplication springApplication = new SpringApplication(JasyptEncryptionApplication.class);
    springApplication.setBannerMode(Banner.Mode.OFF);

    springApplication.run(args);
  }

  @Override
  public void run(String... args) throws Exception {
    this.commands.execute(args);
  }
}
