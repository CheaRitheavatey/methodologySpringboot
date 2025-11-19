package designPattern.structural.proxy;

public class CommandExecutorProxy implements CommandExecutor {
    @Override
    public void runCommand(String command) throws Exception {
        if (isAdmin) {
            commandExecutor.runCommand(command);
        } else {
            if (command.trim().startsWith("rm")) throw new Exception("rm command is not permit for non admin user");
            else commandExecutor.runCommand(command);
        }
    }

    // check if they are an admin or not
    private boolean isAdmin;
    private CommandExecutor commandExecutor;

    public CommandExecutorProxy(String name, String password) {
        if (name.equals("admin") && (password.equals("correctpas"))) {
            isAdmin = true;
        }
        commandExecutor = new CommandExecutorImplementation();
    }

}
