package io.pivotal.pal.tracker;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository
{
    Map<Long, TimeEntry> repo = new HashMap<Long, TimeEntry>();
    private int idCounter = 0;

    public TimeEntry create(TimeEntry te, long id) {
        te.setId(id);
        repo.put(id, te);
        return te;
    }
    public TimeEntry find(long id) {
        return repo.get(id);
    }

    public List<TimeEntry> list() {
        return new ArrayList<TimeEntry>(repo.values());
    }

    public TimeEntry update(long id, TimeEntry teUp) {
        TimeEntry te = repo.get(id);
        if(te != null) {
            te.setProjectId(teUp.getProjectId());
            te.setUserId(teUp.getUserId());
            te.setHours(teUp.getHours());
            te.setDate(teUp.getDate());
            repo.put(id, te);
        }
        return te;
    }

    public TimeEntry getId() {
        return null;
    }

    public void delete(long id) {
        repo.remove(id);
    }

    public TimeEntry create(TimeEntry te) {
        return create(te, ++idCounter);
    }
}
