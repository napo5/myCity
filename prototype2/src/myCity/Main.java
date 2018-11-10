package myCity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Main {
		
	
		
		// ?????????????????????
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		
		System.out.println("Welcome to myCity");
		
		int selection = 0;
		
		BoardList boardlist = new BoardList();
		
		
		
		
		do {
			
			System.out.println("[1] CREATE A BOARD");
			System.out.println("[2] DISPLAY BOARDS LIST / ENTER IN A BOARD");
			System.out.println("[4] CREATE CITIZEN");
			System.out.println("[5] CREATE CITY ADMIN");
			System.out.println("[6] QUIT");
			
			System.out.println("Insert selection: ");
			
			Scanner in = new Scanner(System.in);
			
			selection = in.nextInt()
;
			
			switch(selection) {
			
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
				System.out.println("Insert board number to get into : ");
				Scanner inputBoardList = new Scanner(System.in);
				
				Board selectedBoard = boardlist.getBoards().get(inputBoardList.nextInt()-1);
				
				System.out.println("Welcome to "+selectedBoard.getCity()+" board !");
				
				System.out.println("These are the reports of this city. To create one insert 0");
				System.out.println("-0. Create a new report");
				selectedBoard.printReports();
				Scanner inputBoard = new Scanner(System.in);
				
				int selectedReport = inputBoard.nextInt();
				
				if( selectedReport == 0) {
					// create new report
				}
				
				else {
					System.out.println("Report nr. "+selectedBoard.getReports().get(selectedReport));
				}
				
				
				
				



				
				
				break;
			
				
				
			case 6:
				System.out.println("Exit.");
				break;
			
			default:
				System.out.println("Invalid selection.");
						
			}
			
			
		} while (selection != 6 && selection != 2);
		
		
		
//		Board Recanati = new Board();
//		Recanati.setCity("Recanati");
//		Date mybirtday = null;
//		Citizen Luca = new Citizen(1,"Luca","Pretini","Recanati",mybirtday,"lucapretini97@gmail.com");
//		Citizen Giovanni = new Citizen(2, "Giovanni","Santinelli","Cingoli",mybirtday,"giovanni.santinelli@unicam.it");
//		
//		
//		Recanati.addCitizen(Luca);
//		
//		
//		ArrayList<Comment> toccacrearlo = new ArrayList<Comment>();
//		
//		Report reportDiLuca = new Report("La biblioteca non è mai aperta!", toccacrearlo ,ReportState.REGULAR, Luca);
//		Report secondoreportDiLuca = new Report("Servirebbero più cestini", toccacrearlo ,ReportState.REGULAR, Luca);
//		
//		
//		Luca.sendReport(reportDiLuca,Recanati);
//		Luca.sendReport(secondoreportDiLuca, Recanati);
//		Comment commentoDiGiovanni = new Comment("concordo.", Giovanni, 0, 0, mybirtday);
//		Giovanni.writeComment(commentoDiGiovanni,reportDiLuca);
//		
//		
//		
//		Recanati.printReports();

	}

}
