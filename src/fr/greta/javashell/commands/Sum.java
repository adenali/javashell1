package fr.greta.javashell.commands;

import fr.greta.javashell.Command;
import fr.greta.javashell.ShellSession;

/**
 * A shell command that computes the sum of its arguments.
 * All the arguments must be integers.
 * 
 * @author javaauthor
 *
 */
public class Sum extends Command 
{
	/**
	 * Create a new sum object.
	 */
	public Sum()
	{
		super("sum", "Compute the sum of the integer arguments");
	}

	/**
	 * Execute the sum command by computing the sum of the arguments.
	 * @param session the shell session containing the history (not used here)
	 * @param arguments the arguments to sum (that will be converted from string to integer)
	 * @return the result of the sum converted to a string
	 */
	@Override
	public String execute(ShellSession session, String... arguments) 
	{
		int r = 0;
		for (String a: arguments)
		{
			int i = Integer.parseInt(a);
			r += i;
		}
		return "" + r; // return Integer.toString(r)
	}
}
