import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main
{
	public static Collection<File> chain = new ArrayList<File>();

	public static void main(String[] args) throws InterruptedException
	{
		Thread crawlerThread = new Thread(new Crawler());
		Thread indexThread = new Thread(new Indexer());
		Thread searchThread = new Thread(new IndexSearch());

		searchThread.start();

		crawlerThread.start();
		crawlerThread.join();

		chain = Crawler.getChain();

		Indexer.setChain(chain);
		indexThread.start();
		indexThread.join();
		
		
	}
}
