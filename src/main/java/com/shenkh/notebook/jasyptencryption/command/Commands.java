package com.shenkh.notebook.jasyptencryption.command;

import org.springframework.stereotype.Component;

@Component
public class Commands {
  private Command generateKeyPairCommand;

  public Commands(Command generateKeyPairCommand) {
    this.generateKeyPairCommand = generateKeyPairCommand;
  }

  public void execute(String... parameters) {
    if (parameters == null || parameters.length == 0) {
      return;
    }

    switch (parameters[0].toLowerCase()) {
      case "gen-key-pair":
        this.generateKeyPairCommand.execute(parameters);
        break;
    }
  }
}
