package thread;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Thread1 {

	HashMap<Project, ArrayList<Employee>> hMap;

	public Thread1(HashMap<Project, ArrayList<Employee>> hMap) {
		super();
		this.hMap = hMap;
	}

	boolean flag = false;

	synchronized public void deSerializeProjectDetails() {

		if (flag == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		FileInputStream file;
		System.out.println("DeSerialize called by Consumer");
		try {
			file = new FileInputStream("C:\\Users\\Dhayabharani.A\\eclipse-workspace\\Assignment\\file.txt");
			ObjectInputStream in = new ObjectInputStream(file);
			// Customer[] c=(Customer[])in.readObject();
			Map<Project, ArrayList<Employee>> map = (Map<Project, ArrayList<Employee>>) in.readObject();
			Set<Map.Entry<Project, ArrayList<Employee>>> s = map.entrySet();
			System.out.print("DeSerialized Data{");

			for (Map.Entry<Project, ArrayList<Employee>> maps : s) {
				System.out.println("The Project" + maps.getKey() + "=\r\n" + maps.getValue());

			}
			System.out.println("}");
			System.out.println();
			flag = false;
			notify();
			System.out.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	synchronized void serializeProjectDetails(Map<Project, ArrayList<Employee>> map) throws IOException {
		if (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		FileOutputStream fos;
		FileInputStream file;
		System.out.println("Serialize called by Producer");
		try {
			fos = new FileOutputStream("C:\\Users\\Dhayabharani.A\\eclipse-workspace\\Assignment\\file.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(map);
			System.out.flush();
			file = new FileInputStream("C:\\Users\\Dhayabharani.A\\eclipse-workspace\\Assignment\\file.txt");
			ObjectInputStream inn = new ObjectInputStream(file);

			HashMap<Project, ArrayList<Employee>> mapp = (HashMap<Project, ArrayList<Employee>>) inn.readObject();
			Set<Map.Entry<Project, ArrayList<Employee>>> s = mapp.entrySet();
			System.out.println("Serialized Data:");
			System.out.print("{");
			for (Map.Entry<Project, ArrayList<Employee>> mapss : s) {
				System.out.println("The Project" + mapss.getKey() + "=" + mapss.getValue());

			}

			System.out.println("}");
			System.out.println();

			flag = true;
			notify();

			System.out.flush();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

}
