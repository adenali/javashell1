package fr.greta.javashell.commands;

import java.util.Random;

import fr.greta.javashell.Command;
import fr.greta.javashell.ShellSession;

/**
 * Shell command drawing a random number included between a lower and upper bound.
 * 
 * @author javaauthor
 *
 */
public class Rand extends Command 
{
	public Rand()
	{
		super("rand", "Return a random integer between the first and the second argument (included)");
	}

	/**
	 * Draw a random number.
	 * @param arguments first cell contains the lower bound, second cell the upper (included) bound
	 */
	@Override
	public String execute(ShellSession session, String... arguments) 
	{
		Random r = new Random();
		// TODO Auto-generated method stub
		int min = Integer.parseInt(arguments[0]);
		int max = Integer.parseInt(arguments[1]);
		int n = min+r.nextInt(max+1-min);
		assert(n >= min && n <= max);
		return n+"";
	}

}
