package com.shenkh.notebook.jasyptencryption.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "shenkh.notebook.jasypt")
@Component
public class ApplicationConfig {
  private String encryptAlgorithm;

  public String getEncryptAlgorithm() {
    return encryptAlgorithm;
  }

  public void setEncryptAlgorithm(String encryptAlgorithm) {
    this.encryptAlgorithm = encryptAlgorithm;
  }
}
