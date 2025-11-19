package designPattern.structural.proxy;

import java.io.IOException;

public class CommandExecutorImplementation implements CommandExecutor{

    protected CommandExecutorImplementation() {}
    @Override
    public void runCommand(String command) throws IOException {
        System.out.println("Executing command: " + command);
    }
}
