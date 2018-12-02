import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import myCity.Citizen;
import myCity.Report;
import myCity.Task;
import myCity.TaskDone;
import myCity.TaskManager;
import myCity.TaskState;
import myCity.Worker;

class TaskManagerTest {

	@Test
	void checkTaskConfirm() {
		Citizen author = new Citizen("Name","Surname",LocalDate.now(),"email@gmail.com");
		Report report = new Report("Report Title","Report description",author);
		Task task = new Task("Task Description",10,15,5);
		task.setState(TaskState.WAITING_FOR_CONFIRMS);
		report.setTask(task);

		Citizen citizen = new Citizen("Giovanni", "Santinelli", LocalDate.now(), "email1@gmail.com");
		TaskDone taskConfirm = new TaskDone(citizen, true);
		citizen.checkTaskDone(task, taskConfirm );
		
		Citizen citizen2 = new Citizen("Andrea", "Rossi", LocalDate.now(), "email2@gmail.com");
		TaskDone taskConfirm2 = new TaskDone(citizen2, true);
		citizen2.checkTaskDone(task, taskConfirm2 );
		
		Citizen citizen3 = new Citizen("Francesco", "Bianchi", LocalDate.now(), "email2@gmail.com");
		TaskDone taskConfirm3 = new TaskDone(citizen3, true);
		citizen3.checkTaskDone(task, taskConfirm3 );		
		
		Citizen citizen4 = new Citizen("Marco", "Gialli", LocalDate.now(), "email2@gmail.com");
		TaskDone taskConfirm4 = new TaskDone(citizen4, true);
		citizen4.checkTaskDone(task, taskConfirm4 );
		
		Citizen citizen5 = new Citizen("Giuseppe", "Verdi", LocalDate.now(), "email2@gmail.com");
		TaskDone taskConfirm5 = new TaskDone(citizen5, true);
		citizen5.checkTaskDone(task, taskConfirm5 );
		
		TaskManager taskManager = new TaskManager();
		taskManager.checkTaskDone(task);
		
	
		assertEquals(citizen.getPoints(),3);
		assertEquals(citizen3.getPoints(),3);
		assertEquals(citizen5.getPoints(),3);
		assertTrue(task.getState()==TaskState.SOLVED);
		
	}

}
