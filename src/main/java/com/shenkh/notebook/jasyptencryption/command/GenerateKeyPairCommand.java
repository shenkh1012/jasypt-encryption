package com.shenkh.notebook.jasyptencryption.command;

import com.shenkh.notebook.jasyptencryption.config.ApplicationConfig;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component("get-key-pair-command")
public class GenerateKeyPairCommand extends AbstractCommand {
  private ApplicationConfig applicationConfig;

  public GenerateKeyPairCommand(ApplicationConfig applicationConfig) {
    this.applicationConfig = applicationConfig;
  }

  @Override
  public void execute(String... parameters) {
    try {
      KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(applicationConfig.getEncryptAlgorithm());
      keyPairGenerator.initialize(2048);

      KeyPair keyPair = keyPairGenerator.generateKeyPair();

      System.out.println("--------BEGIN PRIVATE KEY--------");
      System.out.println(Base64.getMimeEncoder().encodeToString(keyPair.getPrivate().getEncoded()));
      System.out.println("--------END PRIVATE KEY--------");
      System.out.println();
      System.out.println("--------BEGIN PUBLIC KEY--------");
      System.out.println(Base64.getMimeEncoder().encodeToString(keyPair.getPublic().getEncoded()));
      System.out.println("--------END PUBLIC KEY--------");
    } catch (NoSuchAlgorithmException e) {
      System.out.println("No such algorithm: " + applicationConfig.getEncryptAlgorithm());
      System.exit(-1);
    }
  }
}
