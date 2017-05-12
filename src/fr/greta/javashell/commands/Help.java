package fr.greta.javashell.commands;

import fr.greta.javashell.Command;
import fr.greta.javashell.Shell;
import fr.greta.javashell.ShellSession;

/**
 * Shell command displaying the help message of another command.
 * The command for which the message is displayed is supplied as the single argument.
 * 
 * @author javaauthor
 *
 */
public class Help extends Command 
{
	public Help()
	{
		super("help", "Display a help message for a command");
	}
	
	/**
	 * Return the help message for the command named arguments[0]
	 * @param arguments the first cell must contain the name of the command
	 * @return the help message for the command (or an error message if no command with the given name exists)
	 */
	@Override
	public String execute(ShellSession session, String... arguments) 
	{
		Command command = Shell.findCommand(arguments[0]);
		if (command != null)
			return command.getHelp();
		else
			return "no command with the name " + arguments[0];
	}

}
