package com.surest.Controller;

import com.surest.Dto.Schedule;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by pachevjoseph on 4/19/16.
 */
@RestController("ScheduleController")
@RequestMapping(
	value = {"/schedule/"},
	produces = { MediaType.APPLICATION_JSON_VALUE })
public class ScheduleController {

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> insertSchedule(
            @ApiParam(value = "", required = true) @RequestBody Schedule schedule) throws Exception {

        String result = "Scheudlesss";

        if (result == null)
            throw new Exception("Error");
        return new ResponseEntity<String>(result, HttpStatus.OK);
}
}
