package myCity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TaskManager {

	public TaskManager() {
		
	}
	
	public ArrayList<Entry<Worker,ApplyRequest>> analyzeWorkerRequests(Task task) {  //use an alogorithm to analyze the applyRequest list; 
		return orderApplyRequests(task.getApplyList());
	}
	
	private ArrayList<Entry<Worker,ApplyRequest>> orderApplyRequests(HashMap<Worker,ApplyRequest> hashmap) { //order the ApplyRequest list based on DaysToComplete value;
		 ArrayList<Entry<Worker, ApplyRequest>> entryList = new ArrayList<Map.Entry<Worker, ApplyRequest>>(hashmap.entrySet());
         Collections.sort(
                 entryList, new Comparator<Map.Entry<Worker, ApplyRequest>>() {
             @Override
             public int compare(Map.Entry<Worker, ApplyRequest> first,
                                Map.Entry<Worker, ApplyRequest> second) {
                 return first.getValue().getDaysToComplete()
                         .compareTo(second.getValue().getDaysToComplete());
             }
         }
     );
         return entryList;
	}
}
