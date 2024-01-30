package com.accio.bookmyshow.Controller;

import com.accio.bookmyshow.Request.AddShowRequest;
import com.accio.bookmyshow.Request.AddShowSeatRequest;
import com.accio.bookmyshow.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("show")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("add")
    public ResponseEntity<String> addShow(@RequestBody AddShowRequest showRequest) throws Exception {

        try {
            String result = showService.addShow(showRequest);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("addShowSeat")
    public ResponseEntity<String> addShowSeat(@RequestBody AddShowSeatRequest showSeatRequest) throws Exception{
        try {
            String result = showService.addShowSeat(showSeatRequest);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
