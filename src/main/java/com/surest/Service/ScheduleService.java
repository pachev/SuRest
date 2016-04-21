package com.surest.Service;

import com.surest.Dao.ScheduleDao;
import com.surest.Dto.Schedule;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

import javax.inject.Inject;

/**
 * Created by pachevjoseph on 4/21/16.
 */
@Service("scheduleService ")

public class ScheduleService {

    @Inject
    private ScheduleDao scheduleDao;

    public String insertSchedule(Schedule schedule) {
        int response = scheduleDao.insertSchedule(schedule);
        JSONObject jsonObject = new JSONObject();

        if (response == 1) {
           jsonObject.put("Message: ", "Success");
           jsonObject.put("Days: ", "Need Something");

            return jsonObject.toString();
        }
        else {

            return null;
        }
    }
}
