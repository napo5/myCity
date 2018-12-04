import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import myCity.Citizen;
import myCity.CityAdmin;
import myCity.Report;
import myCity.Task;
import myCity.TaskManager;
import myCity.Worker;

class WorkerTests {

	private static Citizen author;
	private static Report report;
	private static Task task;
	private static Worker worker;
	private static Worker worker2;
	private static Worker worker3;
	private static TaskManager taskManager;
	private static CityAdmin ca;

	@BeforeAll
	static void init() {
		author = new Citizen("Name", "Surname", LocalDate.now(), "email@gmail.com");
		report = new Report("Report Title", "Report description", author);
		task = new Task("Task Description", 10, 15);
		worker = new Worker("Giovanni", "Santinelli", LocalDate.now(), "email1@gmail.com");
		worker2 = new Worker("Andrea", "Rossi", LocalDate.now(), "email2@gmail.com");
		worker3 = new Worker("Francesco", "Verdi", LocalDate.now(), "email2@gmail.com");
		taskManager = new TaskManager();
		ca = new CityAdmin("Luca", "Pretini", LocalDate.now(), "luca@gmail.com");
	}

	@Test
	@DisplayName("Check if task is accepted correctly")
	void AcceptTaskTest() throws IOException {
		ca.createTask(task, report);
		worker.applyForTask(report, 3);
		worker2.applyForTask(report, 5);
		worker3.applyForTask(report, 1);
		assertTrue(task.getApplyList().size()==3);
		// Choose Andrea Worker with ID = 3
		InputStream in = new ByteArrayInputStream("3".getBytes());
	    System.setIn(in);
	    taskManager.sendRequestToWorker(task, ca);
	    // Accept task with ID = 1
		InputStream in2 = new ByteArrayInputStream("1".getBytes());
	    System.setIn(in2);
		worker2.acceptTask();
		System.out.println(report.getTask().getPersonInCharge().getName());
		assertEquals("Andrea", report.getTask().getPersonInCharge().getName());
		assertEquals("Rossi", report.getTask().getPersonInCharge().getSurname());
	}

	@Test
	@DisplayName("Check if task is refused correctly")
	void RefuseTaskTest() throws IOException {
		ca.createTask(task, report);
		worker.applyForTask(report, 3);
		worker2.applyForTask(report, 5);
		worker3.applyForTask(report, 1);
		// Choose Andrea Worker with ID = 3
		InputStream in = new ByteArrayInputStream("3".getBytes());
	    System.setIn(in);
		taskManager.sendRequestToWorker(task, ca);
		assertTrue(task.getApplyList().size()==3);
		// Refuse task with ID = 1
		InputStream in2 = new ByteArrayInputStream("1".getBytes());
	    System.setIn(in2);
		worker2.refuseTask();
		worker2.printConfirmRequest();
		task.printApplyList();
		assertEquals(worker2.getConfirmRequest().size(),0);
		assertTrue(task.getApplyList().size()==2);
	}
}
