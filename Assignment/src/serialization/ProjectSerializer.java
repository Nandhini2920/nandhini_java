package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ProjectSerializer {
	Map<Project, ArrayList<Employee>> projectMap1 = new LinkedHashMap<Project, ArrayList<Employee>>();
	Map<Project, ArrayList<Employee>> map2 = new HashMap<>();
	Map<Project, ArrayList<Employee>> map3 = new HashMap<>();
	ArrayList<Employee> elist1 = new ArrayList<Employee>();
	ArrayList<Employee> elist2 = new ArrayList<Employee>();
	ArrayList<Employee> elist3 = new ArrayList<Employee>();

	public void serializeProjectDetails(Map<Project, ArrayList<Employee>> map) throws IOException {
		FileOutputStream fos;

		try

		{
			fos = new FileOutputStream("C:\\Users\\Dhayabharani.A\\eclipse-workspace\\Assignment\\file.txt");
			@SuppressWarnings("resource")
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(map);

			System.out.println("SerializeData");
			System.out.flush();

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}

	}

	public void deSerializeProjectDetails() {

		FileInputStream file;
		try {
			file = new FileInputStream("C:\\Users\\Dhayabharani.A\\eclipse-workspace\\Assignment\\file.txt");
			ObjectInputStream in = new ObjectInputStream(file);
			// Customer[] c=(Customer[])in.readObject();
			Map<Project, ArrayList<Employee>> map = (Map<Project, ArrayList<Employee>>) in.readObject();
			Set<Map.Entry<Project, ArrayList<Employee>>> s = map.entrySet();

			System.out.println("DeSerializeData");

			for (Map.Entry<Project, ArrayList<Employee>> maps : s)

			{

				System.out.println("DeSerialized Data :\r\n" + "The Project" + maps.getKey() + "Has the\r\n"
						+ "following Employees\r\n" + "Employees ............." + maps.getValue());

				System.out.flush();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Converted from file into object");

	}

	public static void main(String[] args) {
		ProjectSerializer projectSerializer = new ProjectSerializer();

		Project project1 = new Project("P1", "Music Synthesizer", 23);
		Project project2 = new Project("P2", "Vehicle Movement Tracker", 13);
		Project project3 = new Project("P3", "Liquid Viscosity Finder", 15);
		Employee e1 = new Employee("E001", "Harsha", "9383993933", "RTNagar", 1000);
		Employee e2 = new Employee("E002", "Harish", "9354693933", "Jayanagar", 2000);
		Employee e3 = new Employee("E003", "Meenal", "9383976833", "Malleswaram", 1500);

		projectSerializer.elist1.add(e1);
		projectSerializer.elist1.add(e2);
		projectSerializer.elist1.add(e3);
		Employee e4 = new Employee("E004", "Sundar", "9334593933", "Vijayanagar", 3000);
		Employee e5 = new Employee("E005", "Suman", "9383678933", "Indiranagar", 2000);
		Employee e6 = new Employee("E006", "Suma", "9385493933", "KRPuram", 1750);
		projectSerializer.elist2.add(e4);
		projectSerializer.elist2.add(e5);
		projectSerializer.elist2.add(e6);
		Employee e7 = new Employee("E007", "Chitra", "9383978933", "Koramangala", 4000);
		Employee e8 = new Employee("E008", "Suraj", "9383992133", "Malleswaram", 3000);
		Employee e9 = new Employee("E009", "Manu", "9345193933", "RTNagar", 2000);
		projectSerializer.elist3.add(e7);
		projectSerializer.elist3.add(e8);
		projectSerializer.elist3.add(e9);
		projectSerializer.projectMap1.put(project1, projectSerializer.elist1);
		projectSerializer.projectMap1.put(project2, projectSerializer.elist2);
		projectSerializer.projectMap1.put(project3, projectSerializer.elist3);
		try {
			projectSerializer.serializeProjectDetails(projectSerializer.projectMap1);
		} catch (IOException e) {

			e.printStackTrace();
		}
		projectSerializer.deSerializeProjectDetails();

	}

}

