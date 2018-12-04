
import myCity.*;

import java.io.IOException;
import java.time.LocalDate;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReportManagerTest {

    private static Citizen author;
    private static Report report;
    private static Task task;
    private static Worker worker;
    private static Worker worker2;
    private static Worker worker3;
    private static TaskManager taskManager;
    private static CityAdmin ca;
    private static ReportManager reportManager;

    @BeforeAll
    static void init() {
        author = new Citizen("Name","Surname",LocalDate.now(),"email@gmail.com");
        report = new Report("Report Title","Report description",author);
        task = new Task("Task Description",10,15,4);
        worker = new Worker("Giovanni", "Santinelli", LocalDate.now(), "email1@gmail.com");
        worker2 = new Worker("Andrea", "Rossi", LocalDate.now(), "email2@gmail.com");
        worker3 = new Worker("Francesco", "Verdi", LocalDate.now(), "email2@gmail.com");
        taskManager = new TaskManager();
        ca = new CityAdmin("Luca","Pretini",LocalDate.now(),"luca@gmail.com");
        reportManager = new ReportManager();
    }

    @Test
    @DisplayName("Change report state to Work in Progress")
    void changeReportState() throws IOException {
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
