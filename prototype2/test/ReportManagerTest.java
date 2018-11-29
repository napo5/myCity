
import myCity.*;

import java.io.IOException;
import java.time.LocalDate;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReportManagerTest {

    @Test
    @DisplayName("Change report state to Work in Progress")
    void changeReportState() throws IOException {
        Citizen author = new Citizen("Name","Surname",LocalDate.now(),"email@gmail.com");
        Report report = new Report("Report Title","Report description",author);
        Task task = new Task("Task Description",10,15);
        Worker worker = new Worker("Giovanni", "Santinelli", LocalDate.now(), "email1@gmail.com");
        Worker worker2 = new Worker("Andrea", "Rossi", LocalDate.now(), "email2@gmail.com");
        Worker worker3 = new Worker("Francesco", "Verdi", LocalDate.now(), "email2@gmail.com");
        TaskManager taskManager = new TaskManager();
        CityAdmin ca = new CityAdmin("Luca","Pretini",LocalDate.now(),"luca@gmail.com");
        ReportManager reportManager = new ReportManager();
        reportManager.addReport(report);
        report.setTask(task);
        worker.applyForTask(report, 3);
        worker2.applyForTask(report, 5);
        worker3.applyForTask(report, 1);
        InputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        taskManager.sendRequestToWorker(task, ca);
        InputStream in2 = new ByteArrayInputStream("1".getBytes());
        System.setIn(in2);
        worker2.acceptTask();
        reportManager.applyTaskChecker();
        assertEquals(ReportState.WORK_IN_PROGRESS, report.getState());
    }
}
