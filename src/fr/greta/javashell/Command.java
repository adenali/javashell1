package fr.greta.javashell;

/**
 * An abstract class for a shell command.
 * In order to implement a command, we must create a class
 * that inherits from Command and implements the execute method.
 * 
 * Please see the documentation 
 * on the {@link #execute(ShellSession, String...)} method
 * to know how to define it.
 * 
 * @author javaauthor
 *
 */
public abstract class Command 
{
	public static final String NO_HELP_MESSAGE_AVAILABLE = 
			"No help message available";
	private final String name;
	private final String help;
	
	/**
	 * Construct a command
	 * @param name the name of the command
	 * @param help the help message of the command
	 */
	public Command(String name, String help)
	{
		this.name = name;
		this.help = help;
	}
	
	/**
	 * Construct a command using a default help message
	 * @param name the name of the command
	 */
	public Command(String name)
	{
		this(name, NO_HELP_MESSAGE_AVAILABLE);
	}
	
	/**
	 * Get the name of the command
	 * @return the name of the command
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Get the help message of the command
	 * @return the help message of the command
	 */
	public String getHelp()
	{
		return help;
	}
	
	/**
	 * Abstract method that must be defined to implement
	 * the behavior of the shell command.
	 * It receives a shell session (containing the history of the
	 * current session) and an array of arguments that are the parameters
	 * for the command.
	 * The arguments are expressed as strings but a shell command
	 * could requires special constraints on them (being convertable
	 * to integers for example).
	 * The result of the method is the result of the execution of
	 * the command that is a string.
	 * 
	 * @param session the used shell session
	 * @param arguments the arguments to communicate to the method
	 * @return the result returned by the command
	 * @throws ShellException if a problem was encountered during the execution of the command
	 */
	public abstract String execute(
			ShellSession session, 
			String... arguments)
		throws ShellException;
}
