package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping
public class TimeEntryController {


    TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository)
    {
       this.timeEntryRepository =  timeEntryRepository;
    }
    @PostMapping("/time-entries")
    public ResponseEntity create(@RequestBody TimeEntry timeEntryObj)
    {

        TimeEntry timeEntry =  this.timeEntryRepository.create(timeEntryObj);

        if (timeEntry!=null) {
            return ResponseEntity
                    .status(HttpStatus.CREATED).body(timeEntry);

        } else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(timeEntry);

        }
    }

    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable  long id)
    {
       TimeEntry timeEntry=  this.timeEntryRepository.find(id);

        if (timeEntry!=null) {
            return ResponseEntity
                    .ok()
                    .body(timeEntry);
        } else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(timeEntry);

        }

    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list()
    {

        List<TimeEntry> timeEntryList =  this.timeEntryRepository.list();

        return ResponseEntity
                .ok()
                .body(timeEntryList);




    }

    @PutMapping("/time-entries/{id}")
    public ResponseEntity update(@PathVariable  long id, @RequestBody TimeEntry timeEntryObj)
    {
       // TimeEntry timeEntry=  this.timeEntryRepository.find(id);

      //  if (timeEntry!=null) {


        TimeEntry timeEntry = this.timeEntryRepository.update(id, timeEntryObj );

        if (timeEntry!=null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(timeEntry);
        }
         else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(timeEntry);

        }
    }

    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity delete(@PathVariable long id)
    {
        this.timeEntryRepository.delete(id);

        TimeEntry timeEntry=  this.timeEntryRepository.find(id);

        if (timeEntry!=null) {
            return ResponseEntity
                    .ok()
                    .body(timeEntry);
        } else
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(timeEntry);

        }
    }


}
