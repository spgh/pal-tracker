package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


public class InMemoryTimeEntryRepository implements TimeEntryRepository {


    Map<Long, TimeEntry> timeEntriesMap = new HashMap<>();

    private int counter = 0;
    public TimeEntry create(TimeEntry timeentryObj)
    {

        timeentryObj.setId(++counter);

        this.timeEntriesMap.put(timeentryObj.getId(), timeentryObj);

        return timeentryObj;
    }

    public TimeEntry find(long timeEtnryId)
    {

        return this.timeEntriesMap.get(timeEtnryId);

    }

    public List<TimeEntry> list()
    {
        return new ArrayList<TimeEntry>(this.timeEntriesMap.values());


    }

    public TimeEntry update(long id,TimeEntry timeentryObj)

    {
        TimeEntry localTimeEntry =    this.timeEntriesMap.get(id);
        if (localTimeEntry!=null){
        timeentryObj.setId(id);
        this.timeEntriesMap.replace(id, timeentryObj);

        return timeentryObj ;
       }
      else
            return null;

    }

    public void delete(long id)

    {
        this.timeEntriesMap.remove(id);


    }
}
