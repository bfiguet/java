package com.bfiguet.designpatterns.proxy;

//private CommandExecutor commandExecutor;

public class CommandExecutorProxy implements CommandExecutor {

	private boolean isAdmin = false;
	private CommandExecutor commandExecutor;

	public CommandExecutorProxy(String login, String password){
		isAdmin = "bfiguet".equals(login) && "secret".equals(password);
		commandExecutor = new CommandExecutorImpl();
	}
	@Override
	public void executeCommand(String cmd) throws Exception {
		if(isAdmin){
			System.out.println("Executing command " + cmd + " as an admin");
			commandExecutor.executeCommand(cmd);
		}else{
			if(cmd.contains("rm")){
				throw new Exception("rm command is not allowed for non-admin users.");
			}else{
				commandExecutor.executeCommand(cmd);
			}
		}	
}
