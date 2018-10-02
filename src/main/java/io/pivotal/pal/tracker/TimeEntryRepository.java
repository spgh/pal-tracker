package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface TimeEntryRepository {



    public TimeEntry create(TimeEntry timeentryObj);


    public TimeEntry find(long timeEtnryId);


    public List<TimeEntry> list();


    public TimeEntry update(long id,TimeEntry timeentryObj);


    public void delete(long id);


}
