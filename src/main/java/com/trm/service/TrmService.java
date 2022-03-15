package com.trm.service;

import com.trm.dto.Result;
import com.trm.exception.ToManyRequestException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class TrmService {

    public Result get() {

        LocalDateTime currenDateTime = LocalDateTime.now();

        if(currenDateTime.getSecond() > 40) {
            throw new ToManyRequestException();
        }

        Double trm = 3827.64 + getRandomNumberInRange(1,10);

        return new Result(trm);
    }

    private int getRandomNumberInRange(int min, int max) {

        Random r = new Random();
        return r.ints(min, (max + 1)).findFirst().getAsInt();

    }
}
