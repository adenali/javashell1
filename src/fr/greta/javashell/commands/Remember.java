package fr.greta.javashell.commands;

import fr.greta.javashell.Command;
import fr.greta.javashell.CommandExecution;
import fr.greta.javashell.ShellSession;

/**
 * A shell command that recalls the result from the last used command.
 * 
 * @author javaauthor
 *
 */
public class Remember extends Command 
{

	public Remember() 
	{
		super("remember", "Remember the result of the latest executed command");
	}

	@Override
	public String execute(ShellSession session, String... arguments) 
	{
		try {
			CommandExecution ce = session.getLatestCommandExecution(0);
			return ce.getResult();
		} catch (IndexOutOfBoundsException e)
		{
			return "there is no command in the history";
		}
	}

}
