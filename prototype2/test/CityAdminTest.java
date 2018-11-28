import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import myCity.CityAdmin;
import myCity.Report;
import myCity.Task;
import myCity.TaskManager;
import myCity.Citizen;
import myCity.Worker;

class CityAdminTest {

	@Test
	void ChooseWorkerForTask() throws IOException {
		Citizen author = new Citizen("Name","Surname",LocalDate.now(),"email@gmail.com");
		Report report = new Report("Report Title","Report description",author);
		Report report2 = new Report("Report number 2","Report description number 2",author);
		Task task = new Task("Task Description",10,15);
		Task task2 = new Task("Task number 2",30,45);
		report.setTask(task);
		report2.setTask(task2);
		Worker worker = new Worker("Giovanni", "Santinelli", LocalDate.now(), "email1@gmail.com");
		worker.applyForTask(report, 3);
		Worker worker2 = new Worker("Andrea", "Rossi", LocalDate.now(), "email2@gmail.com");
		worker2.applyForTask(report, 5);
		worker2.applyForTask(report2, 7);
		Worker worker3 = new Worker("Francesco", "Verdi", LocalDate.now(), "email2@gmail.com");
		worker3.applyForTask(report, 1);
		TaskManager taskManager = new TaskManager();

		assertTrue(task.getApplyList().size()==3);
		CityAdmin ca = new CityAdmin("Luca","Pretini",LocalDate.now(),"luca@gmail.com");
		InputStream in = new ByteArrayInputStream("3".getBytes());
	    System.setIn(in);
		ca.chooseWorkerForTask(task, taskManager);
		InputStream in2 = new ByteArrayInputStream("3".getBytes());
		System.setIn(in2);
		ca.chooseWorkerForTask(task2, taskManager);
		// ANDREA ROSSI must be selected, otherwhise asserts and print wont work; 
		worker2.printConfirmRequest();
		assertTrue(worker2.getConfirmRequest().size() == 2);
		assertTrue(worker.getConfirmRequest().size() == 0);
		
	}

}
