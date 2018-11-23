package myCity;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		BoardList boardlist = new BoardList();
		int selection = 0;

		boolean quit = false;

		do {

			printMenu();

			System.out.println("Insert selection: ");

			Scanner in = new Scanner(System.in);

			selection = in.nextInt();

			switch (selection) {

			case 1:
				System.out.println("Insert name of the city: ");
				Scanner inputcity = new Scanner(System.in);
				String cityname = inputcity.nextLine();

				Board newBoard = new Board();
				newBoard.setCity(cityname);
				boardlist.addBoard(newBoard);

				System.out.println("Board created. ");

				break;

			case 2:

				boardlist.printBoards();

				if (boardlist.getBoards().size() == 0) {
					System.out.println("You have to create boards first !");
					break;

				}

				System.out.println("Insert board number to get into : ");
				Scanner inputBoardList = new Scanner(System.in);

				Board selectedBoard = boardlist.getBoards().get(inputBoardList.nextInt() - 1);

				System.out.println("Welcome to " + selectedBoard.getCity() + " board !");

				System.out.println("These are the reports of this city. To create one insert 0");
				System.out.println("To view/insert comments on a report select relative number");

				System.out.println("-0. Create a new report");
				selectedBoard.printReports();
				Scanner inputBoard = new Scanner(System.in);

				int reportNumber = inputBoard.nextInt();

				if (reportNumber == 0) {

					selectedBoard.printCitizens();

					System.out.println("Select citizen making the report : ");
					Scanner inputUserList = new Scanner(System.in);

					Citizen selectedUser = selectedBoard.getCitizens().get(inputUserList.nextInt() - 1);
					
					System.out.println("Insert title of the report : ");
					Scanner inputTitle = new Scanner(System.in);
					String newReportTitle = inputTitle.nextLine();
					

					System.out.println("Insert description of the report : ");
					Scanner inputDescription = new Scanner(System.in);
					String newReportDescription = inputDescription.nextLine();

					Report newReport = new Report(newReportTitle,newReportDescription, selectedUser);

					selectedUser.sendReport(newReport,selectedBoard);
				}

				else {
					
					Report selectedReport = selectedBoard.getReports().get(reportNumber-1);
					System.out.println("Report nr. " + selectedReport.getReportID());
					System.out.println("These are the commments of the report. To create one insert 0");
					selectedReport.printComments();
					
					Scanner inputComments = new Scanner(System.in);
					int selectionComments = inputComments.nextInt();
					if(selectionComments==0) {
						
						
						selectedBoard.printCitizens();

						System.out.println("Select citizen making the report : ");
						Scanner inputUserList = new Scanner(System.in);
						Citizen selectedUser = selectedBoard.getCitizens().get(inputUserList.nextInt() - 1);
						
						System.out.println("Insert comment of the report : ");
						Scanner inputDescription = new Scanner(System.in);
						String inputCommentDescription = inputDescription.nextLine();
						
						Comment newcomment = new Comment(inputCommentDescription, selectedUser);
						selectedUser.writeComment(newcomment,selectedReport);
						System.out.println("Comment succesfully added.");
					
					}

				}

				break;

			case 4:

				if (boardlist.getBoards().size() == 0) {
					System.out.println("You have to create boards first !");
					break;

				}

				boardlist.printBoards();

				System.out.println("Insert board number to get into : ");
				Scanner inputCitizenBoard = new Scanner(System.in);

				Board selectedCitizenBoard = boardlist.getBoards().get(inputCitizenBoard.nextInt() - 1);

				System.out.println("Insert name of the citizen: ");
				Scanner inputName = new Scanner(System.in);
				String name = inputName.nextLine();

				System.out.println("Insert surname of the citizen: ");
				Scanner inputSurname = new Scanner(System.in);
				String surname = inputSurname.nextLine();

				System.out.println("Insert email of the citizen: ");
				Scanner inputEmail = new Scanner(System.in);
				String email = inputEmail.nextLine();

				LocalDate fillData = null;

				Citizen newcitizen = new Citizen(name, surname, fillData, email);

				selectedCitizenBoard.addCitizen(newcitizen);

				System.out.println("New citizen created and added to specific board. ");

				break;

			case 5:

				if (boardlist.getBoards().size() == 0) {
					System.out.println("You have to create boards first !");
					break;

				}

				boardlist.printBoards();

				System.out.println("Insert board number to get into : ");
				Scanner inputCityAdminBoard = new Scanner(System.in);

				Board selectedCityAdminBoard = boardlist.getBoards().get(inputCityAdminBoard.nextInt() - 1);

				System.out.println("Insert name of the citizen: ");
				Scanner inputNameCA = new Scanner(System.in);
				String nameCA = inputNameCA.nextLine();

				System.out.println("Insert surname of the citizen: ");
				Scanner inputSurnameCA = new Scanner(System.in);
				String surnameCA = inputSurnameCA.nextLine();

				System.out.println("Insert email of the citizen: ");
				Scanner inputEmailCA = new Scanner(System.in);
				String emailCA = inputEmailCA.nextLine();

				LocalDate fillDataCA = null;

				CityAdmin newCityAdmin = new CityAdmin(nameCA, surnameCA, fillDataCA, emailCA);

				selectedCityAdminBoard.addAdmin(newCityAdmin);

				System.out.println("New city admin created and added to specific board. ");

				break;

			case 6:
				System.out.println("Exit.");
				quit = true;
				break;

			default:
				System.out.println("Invalid selection.");

			}

		} while (!quit);
		System.out.println("Thanks for using myCity!");

	}

	static void printMenu() {
		System.out.println();
		System.out.println();
		System.out.println("Welcome to myCity");
		System.out.println("-*- Main Menu");
		System.out.println();
		System.out.println("[1] CREATE A BOARD");
		System.out.println("[2] DISPLAY BOARDS LIST / ENTER IN A BOARD");
		System.out.println("[4] CREATE CITIZEN");
		System.out.println("[5] CREATE CITY ADMIN");	
		System.out.println("[6] QUIT");
	}

}


