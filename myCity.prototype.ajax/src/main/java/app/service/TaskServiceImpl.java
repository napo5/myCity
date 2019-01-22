package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Task;
import app.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public Task createTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public Optional<Task> getTask(Long id) {
		return taskRepository.findById(id);
	}

	@Override
	public Task editTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public void deleteTask(Task task) {
		taskRepository.delete(task);
	}

	@Override
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
		
	}

	@Override
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	@Override
	public Task getTaskByReportId(Long idReport) {
		return taskRepository.getTaskByReportId(idReport);
	}

}

