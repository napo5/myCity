import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import myCity.Citizen;
import myCity.CityAdmin;
import myCity.Report;
import myCity.Task;
import myCity.TaskManager;
import myCity.Worker;

class WorkerTests {

	private Citizen author = new Citizen("Name","Surname",LocalDate.now(),"email@gmail.com");
	private Report report = new Report("Report Title","Report description",author);
	private Task task = new Task("Task Description",10,15);
	private Worker worker = new Worker("Giovanni", "Santinelli", LocalDate.now(), "email1@gmail.com");
	private Worker worker2 = new Worker("Andrea", "Rossi", LocalDate.now(), "email2@gmail.com");
	private Worker worker3 = new Worker("Francesco", "Verdi", LocalDate.now(), "email2@gmail.com");
	private TaskManager taskManager = new TaskManager();
	private CityAdmin ca = new CityAdmin("Luca","Pretini",LocalDate.now(),"luca@gmail.com");
	
	
	
	@Test
	void AcceptTaskTest() throws IOException {
		report.setTask(task);
		worker.applyForTask(report, 3);
		worker2.applyForTask(report, 5);
		worker3.applyForTask(report, 1);
		assertTrue(task.getApplyList().size()==3);
		//ANDREA ROSSI must be choose;
		InputStream in = new ByteArrayInputStream("7".getBytes());
	    System.setIn(in);
		ca.chooseWorkerForTask(task, taskManager);
		//Now you are ANDREA ROSSI, and you have to accept the task;
		InputStream in2 = new ByteArrayInputStream("2".getBytes());
	    System.setIn(in2);
		worker2.acceptTask();
		assertEquals(task.getPersonInCharge().getName(),"Andrea");
		assertEquals(task.getPersonInCharge().getSurname(),"Rossi");
		System.out.println(task.getPersonInCharge().getName() + " "+ task.getPersonInCharge().getSurname());
	}

	@Test
	void RefuseTaskTest() throws IOException {
		report.setTask(task);
		worker.applyForTask(report, 3);
		worker2.applyForTask(report, 5);
		worker3.applyForTask(report, 1);
		//ANDREA ROSSI must be choose;
		InputStream in = new ByteArrayInputStream("3".getBytes());
	    System.setIn(in);
		ca.chooseWorkerForTask(task, taskManager);
		//Now you are ANDREA ROSSI, and you have to refuse the task;
		assertTrue(task.getApplyList().size()==3);  //the applys are 3 before we delete our;
		InputStream in2 = new ByteArrayInputStream("1".getBytes());
	    System.setIn(in2);
		worker2.refuseTask();
		worker2.printConfirmRequest();
		task.printApplyList();
		
		assertEquals(worker2.getConfirmRequest().size(),0);
		assertTrue(task.getApplyList().size()==2); 
	}
}
