package com.toyproject.messenger;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SpringBootTest
class MessengerApplicationTests {

    @Test
    void contextLoads() {

        Calendar monday = Calendar.getInstance();
        monday.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        Date mondayDate = monday.getTime();

        Calendar sunday = Calendar.getInstance();
        sunday.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        Date sundayDate = sunday.getTime();

        String todayString = "2024-01-24";


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
//            format.parse("2024-11-11");
            Date menuDate = format.parse(todayString);

            if (menuDate.equals(mondayDate) && menuDate.equals(sundayDate) && menuDate.after(mondayDate)
                    && menuDate.before(sundayDate)){

                System.out.println("########3");
            }


        } catch (Exception e) {

        }

    }

}
