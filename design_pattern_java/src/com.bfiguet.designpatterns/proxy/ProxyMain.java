package com.bfiguet.designpatterns.proxy;

public class ProxyMain {
	public static void main(String[] args) {
		CommandExecutor cmdLine = new CommandExecutorProxy( "bfiguet", "secret");
		try {
			cmdLine.executeCommand( "ls -a");
			cmdLine.executeCommand( "rm some folder");
		} catch (Exception e) {
			System.out.println("Exception Message::" + e.getMessage());
		}
	}
}