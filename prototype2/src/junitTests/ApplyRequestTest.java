package junitTests;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import myCity.Citizen;
import myCity.Report;
import myCity.Task;
import myCity.TaskManager;
import myCity.Worker;

class ApplyRequestTest {

	@Test
	void ApplyRequestsTest() { //test if after someone's apply, the applyRequest is saved
		Citizen author = new Citizen("Name","Surname",LocalDate.now(),"email@gmail.com");
		Report report = new Report("Report Title","Report description",author);
		Task task = new Task("Task Description",10,15);
		report.setTask(task);
		Worker worker = new Worker("Giovanni", "Santinelli", LocalDate.now(), "email1@gmail.com");
		worker.applyForTask(report, 3);
		Worker worker2 = new Worker("Andrea", "Rossi", LocalDate.now(), "email2@gmail.com");
		worker2.applyForTask(report, 5);
		Worker worker3 = new Worker("Francesco", "Verdi", LocalDate.now(), "email2@gmail.com");
		worker3.applyForTask(report, 1);
		TaskManager taskManager = new TaskManager();
		System.out.println(taskManager.analyzeWorkerRequests(task));
		assertTrue(task.getApplyList().size()==3);
		// not yet finished;
		
	}

}
