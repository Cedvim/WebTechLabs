package ex01C;
import org.apache.log4j.*;
public class Log4jBasics
{
	//Définition des logs
	protected static Logger log = Logger.getLogger(Log4jBasics.class);
	
	public static void main(String[] args)
	{
		//Logs de test
		log.debug("DEBUG: Cool !");
		log.info("INFO: Cool !");
	}
}