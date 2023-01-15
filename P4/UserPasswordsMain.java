package jdbc_maven_eb9_4;

import java.util.Scanner;

public class UserPasswordsMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean exit = true;
		do {
			System.out.println("enter your choice");
			System.out.println("1.sign-in \n2.login \n3.exit");
			int choice1 = scanner.nextInt();
			switch (choice1) {
			case 1: {
				System.out.println("enter the user id");
				int user_id = scanner.nextInt();
				System.out.println("enter the user name");
				String user_name = scanner.next();
				System.out.println("enter the user email id");
				String user_email = scanner.next();
				System.out.println("enter the password");
				String user_password = scanner.next();
				System.out.println("enter the address");
				String user_address = scanner.next();

				UserPasswordsCRUD crud = new UserPasswordsCRUD();
				UserPasswords passwords = new UserPasswords();

				passwords.setUser_id(user_id);
				passwords.setUser_name(user_name);
				passwords.setUser_email(user_email);
				passwords.setUser_password(user_password);
				passwords.setUser_address(user_address);
				passwords.setFacebook_pw("null");
				passwords.setInsta_pw("null");
				passwords.setSnapchat_pw("null");
				passwords.setWhatsapp_pw("null");
				passwords.setTwitter_pw("null");
				try {
					crud.saveUserPasswords(passwords);
				} catch (Exception e) {
					System.out.println("error");
					e.printStackTrace();
				}
				break;
			}

			case 2: {
				System.out.println("enter the user name");
				String user_name = scanner.next();
				System.out.println("enter the password");
				String user_password = scanner.next();

				UserPasswordsCRUD crud = new UserPasswordsCRUD();
				UserPasswords passwords = new UserPasswords();

				passwords.setUser_name(user_name);
				passwords.setUser_password(user_password);

				try {
					boolean result = crud.loginUserPasswords(passwords);
					if (result == true) {
						System.out.println("logged in succesfully");
						boolean exitfromlogin = true;
						do {
							System.out.println("enter the choice");
							System.out.println(
									"1.to save the passwords to table \n2.to modify the passwords in table \n3.to veiw your saved passwords");
							System.out.println("4.exit");
							int choice2 = scanner.nextInt();
							switch (choice2) {
							case 1: {

								if (crud.checkTable(user_name)) {
									System.out.println("enter ur id");
									int user_id = scanner.nextInt();
									System.out.println("enter the fb pw");
									String facebook_pw = scanner.next();
									System.out.println("enter the ista pw");
									String insta_pw = scanner.next();
									System.out.println("enter the sch pw");
									String snapchat_pw = scanner.next();
									System.out.println("enter the wts pw");
									String whatsapp_pw = scanner.next();
									System.out.println("enter the twt pw");
									String twitter_pw = scanner.next();

									passwords.setUser_id(user_id);
									passwords.setFacebook_pw(facebook_pw);
									passwords.setInsta_pw(insta_pw);
									passwords.setSnapchat_pw(snapchat_pw);
									passwords.setWhatsapp_pw(whatsapp_pw);
									passwords.setTwitter_pw(twitter_pw);

									crud.saveAllPasswords(passwords);
									break;
								} else
									System.out.println("your already saved passwords");
							}
							case 2: {
								if (!(crud.checkTable(user_name))) {
									System.out.println("enter your user id");
									int user_id = scanner.nextInt();
									System.out.println("heres your info");
									crud.displayPasswords(user_id);
									System.out.println("enter the option to change");
									int choice3 = scanner.nextInt();
									switch (choice3) {
									case 1: {
										System.out.println("enter your new password");
										String newfacebook_pw = scanner.next();
										crud.updateFacebookPasswords(user_id, newfacebook_pw);
										break;
									}
									case 2: {
										System.out.println("enter your new password");
										String newinsta_pw = scanner.next();
										crud.updateInstaPasswords(user_id, newinsta_pw);
										break;
									}
									case 3: {
										System.out.println("enter your new password");
										String newsnapchat_pw = scanner.next();
										crud.updateInstaPasswords(user_id, newsnapchat_pw);
										break;
									}
									case 4: {
										System.out.println("enter your new password");
										String newwhatsapp_pw = scanner.next();
										crud.updateInstaPasswords(user_id, newwhatsapp_pw);
										break;
									}
									case 5: {
										System.out.println("enter your new password");
										String newtwitter_pw = scanner.next();
										crud.updateInstaPasswords(user_id, newtwitter_pw);
									}
										break;
									}
								} else
									System.out.println("please save some passwords");
								break;
							}

							case 3: {
								System.out.println("enter your id");
								int user_id = scanner.nextInt();
								crud.displayPasswords(user_id);
								break;
							}
							case 4: {
								exitfromlogin = false;
							}
							}
						} while (exitfromlogin);

					} else
						System.out.println("invalid user name and password");
				} catch (Exception e) {
					System.out.println("error");
					e.printStackTrace();
				}
			}

			case 3: {
				exit = false;
			}

			default: {
				System.out.println("thank you");
			}
			}

		} while (exit);
	}
}
