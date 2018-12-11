package myCity;

import java.io.IOException;
import java.util.*;

public class TaskManager {

	public TaskManager() {

	}

	/**
	 * Sort the Workers stored in hashmap in increasing order
	 * according to daysToComplete in ApplyRequest
	 */
	public static HashMap<Worker, ApplyRequest> sortByValue(HashMap<Worker, ApplyRequest> myHashMap) {
		LinkedList<Map.Entry<Worker, ApplyRequest>> listValues = new LinkedList<>(myHashMap.entrySet());
		Collections.sort(listValues, Comparator.comparing(workerApplyRequestEntry -> (workerApplyRequestEntry.getValue().getDaysToComplete())));
		HashMap<Worker, ApplyRequest> hmap = new LinkedHashMap<>();
		for (Map.Entry<Worker, ApplyRequest> a : listValues) {
			hmap.put(a.getKey(), a.getValue());
		}
		return hmap;
	}

	/**
	 * Send apply request to worker
	 */
	public void sendRequestToWorker(Task task, CityAdmin ca) throws IOException {
		HashMap<Worker, ApplyRequest> orderedWorkers = sortByValue(task.getApplyList());
		int chosenWorkerId = ca.chooseWorkerForTask(orderedWorkers);
		orderedWorkers.forEach((worker, days) -> {
			if (worker.getCitizenID() == chosenWorkerId) {
				worker.addConfirmRequest(task);
			}
		});
	}
	
	public void checkTaskDone(Task task) {
		if (task.getNeededCheck() == task.getPositiveCheck().size()) {
			task.getPositiveCheck().forEach((k , v) -> { k.setPoints(k.getPoints() + task.pointsToConfirm);
			});
			task.getPersonInCharge().setPoints(task.getPersonInCharge().getPoints() + task.pointsToWorker);
			task.setState(TaskState.SOLVED);
		} else if (task.getNeededCheck() == task.getNegativeCheck().size()){
			task.getNegativeCheck().forEach((k , v) -> { k.setPoints(k.getPoints() + task.pointsToConfirm);
			});
			/*
			*da decidere in UC (si potrebbe mettere in "waiting for workers" e ricominciare come fosse
			*un nuovo task.
			*/
		}
	}
	
}
