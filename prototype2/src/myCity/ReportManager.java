package myCity;

import java.util.ArrayList;

public class ReportManager {

    private ArrayList<Report> reportToCheck = new ArrayList<>();

    public ReportManager() {

    }

    public void addReport(Report report) {
        reportToCheck.add(report);
    }

    public Report getRep() {
        return reportToCheck.get(0);
    }

    public void applyTaskChecker() {
        reportToCheck.forEach(report -> {
            if (report.getTask().getPersonInCharge() != null) {
                report.setState(ReportState.WORK_IN_PROGRESS);
            }
        });
    }
}
