package jdbc_maven_eb9_3;

import java.util.Scanner;

public class UserMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean res = true;
		do {
			System.out.println("Enter the choice");
			System.out.println("1.to insert new user data");
			System.out.println("2.To update the old data");
			System.out.println("3.To delete th user");
			System.out.println("4.To display all the users data");
			System.out.println("5.To login");
			System.out.println("6.To insert in bulk");
			System.out.println("7.To exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter the user ID");
				int user_id = scanner.nextInt();
				System.out.println("Enter the user name");
				String user_name = scanner.next();
				System.out.println("enter the password ");
				String password = scanner.next();
				System.out.println("enter the phone number");
				long phone = scanner.nextLong();
				System.out.println("enter the e _ mailId");
				String e_mailid = scanner.next();

				User user = new User();
				user.setUser_id(user_id);
				user.setE_mailid(e_mailid);
				user.setPassword(password);
				user.setUser_name(user_name);
				user.setPhone(phone);

				UserCRUD crud = new UserCRUD();
				try {
					crud.saveUser(user);
				} catch (Exception e) {
					System.out.println("303 eror");
				}

			}
				break;

			case 2: {
				System.out.println("Enter the user name");
				String user_name = scanner.next();
				System.out.println("enter the user ID ");
				int user_id = scanner.nextInt();

				User user = new User();
				user.setUser_id(user_id);
				user.setUser_name(user_name);

				UserCRUD crud = new UserCRUD();
				try {
					crud.updateUser(user);
				} catch (Exception e) {
					System.out.println("303 error");
				}
				break;
			}
			case 3: {
				System.out.println("Enter the user ID");
				int user_id = scanner.nextInt();

				User user = new User();
				user.setUser_id(user_id);

				UserCRUD crud = new UserCRUD();
				try {
					crud.deleteUser(user);
				} catch (Exception e) {
					System.out.println("303 error");
				}
				break;
			}
			case 4: {
				UserCRUD crud = new UserCRUD();
				try {
					crud.displayUser();
				} catch (Exception e) {
					System.out.println("303 error");
				}
				break;
			}
			case 5: {
				System.out.println("Enter the user name");
				String user_name = scanner.next();
				System.out.println("Enter the password");
				String password = scanner.next();
				User user = new User();
				user.setPassword(password);
				user.setUser_name(user_name);
				UserCRUD crud = new UserCRUD();

				try {
					boolean result = crud.loginUser(user);
					if (result == true) {
						System.out.println("Logged in successfully");
					} else {
						System.out.println("Invalid user and password");
					}
				} catch (Exception e) {
					System.out.println("303 error");
				}break;

			}
			case 6:{
				UserCRUD crud = new UserCRUD();
				try {
					crud.saveInBatchUser();
				} catch (Exception e) {
					System.out.println("303 Error");
				}break;
			}
			case 7: {
				res = false;
			}

			default: {
				System.out.println("Thankyou");
			}
				break;
			}

		} while (res);

	}
}
