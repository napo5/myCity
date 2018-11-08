package it.unicam.ids.core;

/**
 * Report State
 * Only the city admin can manage the state of a reporto
 * Each report could has three different state:
 * 1. OPEN - report is open, each registered user can comment
 * 2. CLOSED - report is closed, no one can comment. Only view is admitted
 * 3. LOCKED - report is locked, everyone can see the report but no one can comment
 */

public enum ReportState {
    OPEN,
    CLOSED,
    LOCKED,
}
