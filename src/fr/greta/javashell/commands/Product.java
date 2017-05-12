package fr.greta.javashell.commands;

import fr.greta.javashell.Command;
import fr.greta.javashell.ShellSession;

/**
 * Shell command computing the product of its arguments.
 * All the arguments are converted to integers.
 * 
 * @author javaauthor
 *
 */
public class Product extends Command 
{
	public Product()
	{
		super("product", "Compute the product of the integers given as arguments");
	}

	@Override
	public String execute(ShellSession session, String... arguments) 
	{
		int r;
		if(arguments.length < 1)
			r = 0;
		else 
			r = 1;
		for (String a: arguments)
		{
			int i = Integer.parseInt(a);
			r *= i;
		}
		return "" + r; // return Integer.toString(r)
	}
}
