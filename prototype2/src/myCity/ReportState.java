package myCity;

/**
 * States can be modified by City Admin
 *
 * REGULAR = default state,
 * CLOSED = citizens can no longer comment,
 * SUSPENDED = city admin can't handle this report in this moment. Citizens can comment.
 * TASK_AVAILABLE = city admin posted relative task.
 * WORK_IN_PROGRESS = city admin is solving report topic.
 */
public enum ReportState {
	
	REGULAR,CLOSED,SUSPENDED,TASK_AVAILABLE,WORK_IN_PROGRESS;
				
}
