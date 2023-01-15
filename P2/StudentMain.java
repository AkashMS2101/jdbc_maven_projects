package jdbc_maven_eb9_2;

import java.util.Scanner;

public class StudentMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean exit = true;
		StudentCRUD crud = new StudentCRUD();
		Student student = new Student();
		do {
			System.out.println("enter the choice");
			System.out.println("1.to insert \n2.to update name \n3.to delete \n4.to display all details \n5.to exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter the name");
				String name = sc.nextLine();
				System.out.println("Enter the id");
				int id = sc.nextInt();
				System.out.println("Enter the marks");
				int marks = sc.nextInt();
				System.out.println("Enter the father name");
				String father_name = sc.nextLine();
				System.out.println("Enter the address");
				String address = sc.nextLine();

				student.setSid(id);
				student.setStd_address(address);
				student.setStd_father_name(father_name);
				student.setStdmarks(marks);
				student.setStdname(name);

				try {
					crud.saveStudent(student);
				} catch (Exception e) {
					System.out.println("Error");
				}

				break;
			}
			case 2: {
				System.out.println("Enter the name");
				String name = sc.nextLine();
				System.out.println("Enter the id");
				int id = sc.nextInt();

				student.setStdname(name);
				student.setSid(id);
				try {
					crud.updateStudent(student);
				} catch (Exception e) {
					System.out.println("Error");
				}
				break;
			}

			case 3: {
				System.out.println("Enter the id");
				int id = sc.nextInt();

				try {
					crud.deleteStudent(id);
				} catch (Exception e) {
					System.out.println("Error");
				}
				break;
			}

			case 4: {
				try {
					crud.displayAllStudent();
				} catch (Exception e) {
					System.out.println("Error");
				}
				break;
			}
			case 5: {
				exit = false;
				break;
			}
			}
		} while (exit);
	}
}
