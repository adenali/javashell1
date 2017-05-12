package fr.greta.javashell;

/** An executed command with its arguments and result */
public class CommandExecution 
{
	private final Command command;
	private final String[] arguments;
	private String result;
	
	public CommandExecution(Command command, String[] arguments)
	{
		this.command = command;
		this.arguments = arguments;
	}
	
	public void run(ShellSession session) throws ShellException
	{
		result = command.execute(session, arguments);
	}
	
	public String getResult()
	{
		return result;
	}
}
