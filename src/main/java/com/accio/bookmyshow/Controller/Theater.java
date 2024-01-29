package com.accio.bookmyshow.Controller;

import com.accio.bookmyshow.Request.AddTheaterRequest;
import com.accio.bookmyshow.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("theater")
public class Theater {

    @Autowired
    private TheaterService theaterService;

    @PostMapping("add")
    public ResponseEntity<String> addTheater(@RequestBody AddTheaterRequest theaterRequest) {
        String result = theaterService.addTheater(theaterRequest);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
