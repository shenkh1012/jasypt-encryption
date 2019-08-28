package com.shenkh.notebook.jasyptencryption.command;

@FunctionalInterface
public interface Command {
  void execute(String... parameters);
}
