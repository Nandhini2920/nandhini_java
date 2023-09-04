package thread;

import java.io.IOException;
import java.io.StreamCorruptedException;

public class Producer extends Thread {

	Thread1 p;

	Producer(Thread1 p)

	{

		this.p = p;

		start();

	}

	public void run()

	{int i=0;

		while (i==0)

		{

			try {

				i++;
				p.serializeProjectDetails(p.hMap);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	}
}