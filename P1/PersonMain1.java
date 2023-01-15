package jdbc_maven_eb9_1;

import java.util.Scanner;

public class PersonMain1 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		boolean exit = true;
		PersonCRUD crud = new PersonCRUD();
		Person person = new Person();
		do {
			System.out.println("enter the choice");
			System.out.println("1.to insert \n2.to update name \n3.to delete \n4.to display all details \n5.to exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:{
				System.out.println("Enter the id");
				int id = sc.nextInt();
				System.out.println("Enter the name");
				String name = sc.nextLine();
				System.out.println("Enter the phone number");
				long phone = sc.nextLong();
				
				
				person.setId(id);
				person.setName(name);
				person.setPhone(phone);
				
				try {
					crud.savePerson(person);
				} catch (Exception e) {
					System.out.println("404 error");
				}
				break;
			}
			case 2:{
				System.out.println("Enter the id");
				int id = sc.nextInt();
				System.out.println("Enter the name");
				String name = sc.nextLine();
				person.setId(id);
				person.setName(name);
				try {
					crud.updatePerson(person);
				} catch (Exception e) {
					System.out.println("404 error");
				}
				break;
			}
			case 3:{
				System.out.println("Enter the id");
				int id = sc.nextInt();
				try {
					crud.deletePerson(id);
				} catch (Exception e) {
					System.out.println("Deleted");
				}
				break;
			}
			case 4:{
				try {
					crud.displayPerson(person);
				} catch (Exception e) {
					System.out.println("404 Error");
				}
			}
			case 5:{
				exit=false;
				break;
			}
			}
		} while (exit);
	}
}
