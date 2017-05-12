package fr.greta.javashell;

import java.util.Arrays;
import java.util.Scanner;

import fr.greta.javashell.commands.*;

/** 
 * A Java shell implementation.
 * It works by asking a line to the user,
 * splitting this line to extract the command name
 * and its arguments separated by whitespaces,
 * then executing the command if it is valid.
 * This process is repeated until the user quits the shell
 * with the 'exit' command.
 * 
 * @author javaauthor
 *
 */
public class Shell 
{
	public static final String PROMPT = "JavaShell$ ";
	public static final int HISTORY_CAPACITY = 4;
	
	public static final Command[] COMMANDS = new Command[] {
		new Echo(),
		new Sum(),
		new Product(),
		new Rand(),
		new Fact(),
		new Help(),
		new Remember(),
		new Chrono()
	};
	
	public static Command findCommand(String name)
	{
		for (Command command: COMMANDS)
			if (command.getName().equals(name))
				return command;
		return null;
	}
	
	/** Manage the shell loop */
	public void run()
	{
		ShellSession session = new ShellSession(HISTORY_CAPACITY);
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print(PROMPT);
			while (sc.hasNextLine())
			{
				String line = sc.nextLine();
				String[] elements = line.split(" ");
				String commandName = elements[0];
				String[] arguments = Arrays.copyOfRange(elements, 1, elements.length);
				String result = "not supported";
				/* if (commandName.equals("echo"))
				{
					Echo echo = new Echo();
					result = echo.execute(arguments);
				} else if (commandName.equals("sum"))
				{
					Sum sum = new Sum();
					result = sum.execute(arguments);
				} */
				if (commandName.equals("exit"))
					break;
				else
				{
					Command command = findCommand(commandName);
					if (command != null)
					{
						CommandExecution ce = 
								new CommandExecution(command, arguments);
						try {
							ce.run(session);
							result = ce.getResult();
							session.addInHistory(ce);
						} catch (ShellException e)
						{
							System.out.println("There was a problem when executing the command: " + e);
						}
					}
					System.out.println(result);
					System.out.print(PROMPT);
				}
			}
		} finally
		{
			sc.close();
		}
	}
	
	public static void main(String[] args)
	{
		Shell shell = new Shell();
		shell.run();
	}
}
