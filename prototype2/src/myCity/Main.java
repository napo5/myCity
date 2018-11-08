package myCity;

import java.util.Date;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Board Recanati = new Board();
		Recanati.setCity("Recanati");
		Date mybirtday = null;
		Citizen Luca = new Citizen(1,"Luca","Pretini","Recanati",mybirtday,"lucapretini97@gmail.com");
		Citizen Giovanni = new Citizen(2, "Giovanni","Santinelli","Cingoli",mybirtday,"giovanni.santinelli@unicam.it");
		
		
		Recanati.addCitizen(Luca);
		
		
		Vector<Comment> toccacrearlo = new Vector<Comment>();
		
		Report reportDiLuca = new Report("Reca fa schifo!", toccacrearlo ,ReportState.REGULAR, Luca);
		Report secondoreportDiLuca = new Report("anche porto fa schifo!", toccacrearlo ,ReportState.REGULAR, Luca);
		
		
		Luca.sendReport(reportDiLuca,Recanati);
		Luca.sendReport(secondoreportDiLuca, Recanati);
		Comment commentoDiGiovanni = new Comment("non è vero bro", Giovanni, 0, 0, mybirtday);
		Giovanni.writeComment(commentoDiGiovanni,reportDiLuca);
		
		
		
		Recanati.printReports();

	}

}
