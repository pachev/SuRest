package com.surest.Dao;

import com.surest.Dto.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

/**
 * Created by pachevjoseph on 4/19/16.
 */
@Repository("scheduleDao")
public class ScheduleDao {


    @Inject
    private JdbcTemplate jdbcTemplate;

    public int insertSchedule(Schedule schedule) {
        try {
            String sql = "INSERT INTO users ('mondays') VALUES(?);";

            jdbcTemplate.update(sql, schedule.getDay());

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
       return 1;
    }

}
