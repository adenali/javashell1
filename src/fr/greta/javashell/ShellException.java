package fr.greta.javashell;

/**
 * An exception that is thrown when the execution of a shell
 * command fails.
 * 
 * @author javaauthor
 *
 */
public class ShellException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public ShellException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShellException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ShellException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ShellException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ShellException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
