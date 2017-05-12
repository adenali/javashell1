package fr.greta.javashell.commands;

import fr.greta.javashell.Command;
import fr.greta.javashell.ShellException;
import fr.greta.javashell.ShellSession;

/**
 * A shell command computing the factorial of a number.
 * 
 * @author java
 */
public class Fact extends Command 
{
	public Fact()
	{
		super("fact", "Compute the factorial of the argument");
	}

	@Override
	public String execute(ShellSession session, String... arguments) 
	throws ShellException
	{
		int n;
		try {
			n = Integer.parseInt(arguments[0]);
		} catch (NumberFormatException e)
		{
			throw new ShellException("you must enter a valid integer", e);
		} catch (ArrayIndexOutOfBoundsException e)
		{
			throw new ShellException("you must communicate one argument", e);
		} catch (Exception e)
		{
			throw new ShellException("there is one exception: " + e, e);
		} finally
		{
			System.out.println("Executed in finally");
		}
		int r = 1;
		for (int i = 2; i <= n; i++)
			r = r * i;
		assert(r >= 1);
		return "" + r;
	}

}
