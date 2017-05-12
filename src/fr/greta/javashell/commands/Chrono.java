package fr.greta.javashell.commands;

import fr.greta.javashell.Command;
import fr.greta.javashell.ShellException;
import fr.greta.javashell.ShellSession;

public class Chrono extends Command 
{
	private long start;
	

	
	public Chrono()
	{
		super("chrono","Returns the time in seconds between the start and the stop");
	}
	public long getStart() 
	{
		return start;
	}
	public void setStart(long result) 
	{
		this.start = result;
	}
	
	public void start()
	{
		setStart(System.currentTimeMillis());
	}
	@Override
	public String execute(ShellSession session, String... arguments) throws ShellException 
	{
		// TODO Auto-generated method stub
		if (arguments[0].equals("start"))
		{
			this.start();
			return "the chrono is set use 'chrono stop' to stop";
		}
		else if(arguments[0].equals("stop"))
		{
			if (getStart()!=0L) 
			{
				//System.out.println(getStart()+"");
				long tmp=(System.currentTimeMillis()-getStart())/1000L;
				return tmp+"";
			} 
			else
			{
				// TODO Auto-generated catch block
				return "you haven't started the chrono!";
				//return e.getMessage();
			}
		}
		else
			return "";
	}

}
