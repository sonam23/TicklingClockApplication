package com.janio.clock.model;

import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.concurrent.TimeUnit;

public class SpecialClockTest {

    private SpecialClock clock;

    @Test
    public void testCurrentTimeDate_NoOffset(){
        clock = new SpecialClock(0);
        String nowTime = ZonedDateTime.ofInstant(Instant.now(), SpecialClock.sgt).format(SpecialClock.timeFormatter);
        String nowDateTime = ZonedDateTime.ofInstant(Instant.now(), SpecialClock.sgt).format(SpecialClock.dateTimeFormatter);

        Assert.assertEquals(nowTime, clock.printBackTime());
        Assert.assertEquals(nowTime, clock.printNowTime());

        Assert.assertEquals(nowDateTime, clock.printBackDateTime());
        Assert.assertEquals(nowDateTime, clock.printNowDateTime());
    }

    @Test
    public void testCurrentTimeDate_PositiveOffset(){
        int offset = 2;
        clock = new SpecialClock(offset);
        String nowTime = ZonedDateTime.ofInstant(Instant.now(), SpecialClock.sgt).format(SpecialClock.timeFormatter);
        String nowDateTime = ZonedDateTime.ofInstant(Instant.now(), SpecialClock.sgt).format(SpecialClock.dateTimeFormatter);
        String pastTime = ZonedDateTime.ofInstant(Instant.now(), SpecialClock.sgt).minusHours(offset).format(SpecialClock.timeFormatter);
        String pastDateTime = ZonedDateTime.ofInstant(Instant.now(), SpecialClock.sgt).minusHours(offset).format(SpecialClock.dateTimeFormatter);


        Assert.assertEquals(pastTime, clock.printBackTime());
        Assert.assertEquals(nowTime, clock.printNowTime());

        Assert.assertEquals(pastDateTime, clock.printBackDateTime());
        Assert.assertEquals(nowDateTime, clock.printNowDateTime());
    }

    @Test
    public void testTickingAction_PositiveOffset() throws InterruptedException {
        int offset = 2;
        clock = new SpecialClock(offset);

        //Causing delay
        System.out.println("Sleeping for 5 seconds, at present time is: "+ZonedDateTime.ofInstant(Instant.now(), SpecialClock.sgt).format(SpecialClock.timeFormatter));

        TimeUnit.SECONDS.sleep(5);
        String nowTime = ZonedDateTime.ofInstant(Instant.now(), SpecialClock.sgt).format(SpecialClock.timeFormatter);
        String pastTime = ZonedDateTime.ofInstant(Instant.now(), SpecialClock.sgt).minusHours(offset).format(SpecialClock.timeFormatter);

        Assert.assertEquals(nowTime, clock.printNowTime());
        Assert.assertEquals(pastTime, clock.printBackTime());
        System.out.println("Sleeping for 5 seconds, time after 5 seconds: "+ZonedDateTime.ofInstant(Instant.now(), SpecialClock.sgt).format(SpecialClock.timeFormatter));
    }

}
