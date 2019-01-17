package app.service;

import java.util.List;
import java.util.Optional;

import app.model.Task;

public interface TaskService {
	Task createTask(Task task);

	Optional<Task> getTask(Long id);

	Task editTask(Task task);

	void deleteTask(Task task);

	void deleteTask(Long id);

	List<Task> getAllTasks();
	
	Task getTaskByReportId(Long idReport);
}
