package com.janio.clock.impl;

import com.janio.clock.api.TickingClock;
import com.janio.clock.model.SpecialClock;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Main class to implement the scheduler to print the backtimed tickling clock.
 * Also extends and print the current tickling clock
 */
public class TickingClockImpl implements TickingClock {

    private final SpecialClock clock;
    private static final long ONE_SECOND = 1;
    private static final long NO_INITIAL_DELAY = 0;
    private final ScheduledExecutorService timerService = Executors.newSingleThreadScheduledExecutor();

    public TickingClockImpl(SpecialClock clock){
        this.clock = clock;
        System.out.println("Current Time: "+clock.printNowDateTime());
        System.out.println("BackDated Time: "+clock.printBackDateTime());
    }

    /**
     * Print the backtimed tickiling clock
     */
    @Override
    public void printBackDateTickingClock() {
        if(clock == null){
            System.out.println("Clock cannot be null! Please create the relevant Clock to see it tickle!!");
            return;
        }
        scheduleJob(false);
    }

    /**
     * Print the current tickling clock
     */
    @Override
    public void printCurrentTickingClock() {
        if(clock == null){
            System.out.println("Clock cannot be null! Please create the relevant Clock to see it tickle!!");
            return;
        }
        scheduleJob(true);
    }

    /**
     * Schedule the job to execute the printing job
     * @param isCurrent
     */
    private void scheduleJob(boolean isCurrent){
        timerService.scheduleAtFixedRate(printClockTask(isCurrent),NO_INITIAL_DELAY, ONE_SECOND, ApplicationProperties.INSTANCE.getTimeUnit());
    }

    private Runnable printClockTask(boolean isCurrent){
        return () -> System.out.println(isCurrent?clock.printNowTime():clock.printBackTime());
    }

    public void stop() {
        timerService.shutdown();
    }
}

