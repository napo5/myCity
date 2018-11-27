import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import myCity.Citizen;
import myCity.CityAdmin;
import myCity.Report;
import myCity.Task;
import myCity.TaskManager;
import myCity.Worker;

class WorkerTests {

	@Test
	void AcceptTaskTest() throws IOException {
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

		assertTrue(task.getApplyList().size()==3);
		CityAdmin ca = new CityAdmin("Luca","Pretini",LocalDate.now(),"luca@gmail.com");
		//ANDREA ROSSI must be choose;
		ca.chooseWorkerForTask(task, taskManager);
		//Now you are ANDREA ROSSI, and you have to accept the task;
		worker2.acceptTask();
		assertEquals(task.getPersonInCharge().getName(),"Andrea");
		assertEquals(task.getPersonInCharge().getSurname(),"Rossi");
		System.out.println(task.getPersonInCharge().getName() + " "+ task.getPersonInCharge().getSurname());
	}

	@Test
	void RefuseTaskTest() throws IOException {
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
		CityAdmin ca = new CityAdmin("Luca","Pretini",LocalDate.now(),"luca@gmail.com");
		//ANDREA ROSSI must be choose;
		ca.chooseWorkerForTask(task, taskManager);
		//Now you are ANDREA ROSSI, and you have to refuse the task;
		assertTrue(task.getApplyList().size()==3);  //the applys are 3 before we delete our;
		worker2.refuseTask();
		worker2.printConfirmRequest();
		task.printApplyList();
		
		assertEquals(task.getApplyList().size(),2);
		assertEquals(worker2.getConfirmRequest().size(),0);
		assertTrue(task.getApplyList().size()==2); //now applys are 2 cuz we deleted our;
	}
}
