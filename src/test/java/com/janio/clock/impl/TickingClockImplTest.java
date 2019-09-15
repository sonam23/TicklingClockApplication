package com.janio.clock.impl;

import com.janio.clock.model.SpecialClock;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.concurrent.TimeUnit;

public class TickingClockImplTest {

    private TickingClockImpl tickingClock;

    /**
     * Tests ticking clock of past after sleep - 5 seconds,
     * @throws InterruptedException
     */
    @Test
    public void testSchedulerPastTime() throws InterruptedException {
        int offset = 2;
        tickingClock = new TickingClockImpl(new SpecialClock(offset));

        PrintStream oldOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        tickingClock.printBackDateTickingClock();

        String pastTime = ZonedDateTime.ofInstant(Instant.now(), SpecialClock.sgt).minusHours(offset).format(SpecialClock.timeFormatter);
        TimeUnit.SECONDS.sleep(5);
        tickingClock.stop();
        String pastTimePost5Sec = ZonedDateTime.ofInstant(Instant.now(), SpecialClock.sgt).minusHours(offset).format(SpecialClock.timeFormatter);

        System.setOut(oldOut);
        String output = new String(outContent.toByteArray());
        System.out.println(output);
        Assert.assertTrue(output.contains(pastTime));
        Assert.assertTrue(output.contains(pastTimePost5Sec));
    }

}
