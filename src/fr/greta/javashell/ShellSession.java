package fr.greta.javashell;

/** Contains information about the current shell session */
public class ShellSession 
{
	/** We save here the latest executed commands of the shell */
	private CommandExecution[] history;
	
	/** The number of executed commands in the history */
	private int historySize;
	
	public ShellSession(int historyCapacity)
	{
		this.history = new CommandExecution[historyCapacity];
	}
	
	/**
	 * Get one of the latest executed command
	 * The latest executed command is obtainable with index 0,
	 * the before last executed command with index 1,
	 * the antepenultimate executed command with index 2,
	 * and so on... 
	 * @param i the index of the latest executed command
	 * @return one of the latest executed command
	 * @throws IndexOutOfBoundsException thrown if the index is not valid
	 */
	public CommandExecution getLatestCommandExecution(int i)
	{
		int commandIndex = historySize - 1 - i;
		if (commandIndex < 0)
			throw new IndexOutOfBoundsException("Cannot retrieve the latest command #" + i);
		return history[commandIndex];
	}
	
	private void liberateOneCell()
	{
		for (int i = 1; i < history.length; i++)
			history[i-1] = history[i];
		historySize--;
	}
	
	/** 
	 * Add a new command to the history
	 * @param ce the command to add to the history
	 */
	public void addInHistory(CommandExecution ce)
	{
		// is the history array full
		if (history.length == historySize)
			liberateOneCell();
		assert(historySize < history.length);
		history[historySize] = ce;
		historySize++;
	}
}
