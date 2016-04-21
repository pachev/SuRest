package com.surest.Controller;

import com.surest.Dto.Schedule;
import com.surest.Service.ScheduleService;
import com.wordnik.swagger.annotations.*;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Created by pachevjoseph on 4/19/16.
 */
@RestController("ScheduleController")
@RequestMapping(
	value = {"/schedule/"},
	produces = { MediaType.APPLICATION_JSON_VALUE })
@Api(value = "Schedule Submit", description = "Submits a schedule to the server")
public class ScheduleController {

    @Inject
    private ScheduleService scheduleService;

    @PostConstruct
    private void postConstruct(){
        LoggerFactory.getLogger(getClass()).info("Loaded Device Usage Controller");
    }

    /**
     *
     * Returns @ResponseBody that is wrapped with header and json format result
     * The result displays whetere insertion was successful or not
     * @param json format Schedule objec
     * @return respsonse if successful insert
     * @throws Exception
     */
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @ApiOperation(value = "Submits a new schedule to be processed", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message=""),
            @ApiResponse(code = 400, message=""),
            @ApiResponse(code = 500, message="")
    })
    public @ResponseBody
    ResponseEntity<String> insertSchedule(
            @ApiParam(value = "", required = true) @RequestBody Schedule schedule) throws Exception {

        String result = scheduleService.insertSchedule(schedule);

        if (result == null)
            throw new Exception("Error");
        return new ResponseEntity<String>(result, HttpStatus.OK);
}
}
