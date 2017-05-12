package fr.greta.javashell.commands;

import fr.greta.javashell.Command;
import fr.greta.javashell.ShellSession;

/**
 * Shell command repeating the arguments that are supplying to it.
 * 
 * @author javaauthor
 *
 */
public class Echo extends Command 
{
	public Echo()
	{
		super("echo", "Echo the given arguments");
	}
	
	@Override
	public String execute(ShellSession session, String... arguments) 
	{
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (String argument: arguments)
		{
			if (i > 0) sb.append(" ");
			sb.append(argument);
			i++;
		}
		/* String s = "";
		for (int i = 0; i < arguments.length; i++)
			s += " " + arguments[i]; */
		return sb.toString();
	}

}
