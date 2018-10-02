package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    //public TimeEntry create(TimeEntry te, long i);

    public TimeEntry find(long i);

    public List<TimeEntry> list();

    public TimeEntry update(long id, TimeEntry te);

    //public TimeEntry getId();

    public void delete(long id);

    public TimeEntry create(TimeEntry timeEntry);

}
