package com.janio.clock.api;

import com.janio.clock.model.SpecialClock;

/**
 * Interface for the Tickling clock
 */
public interface TickingClock {
    /**
     * Creates and executes a periodic action, of printing the instant of the baseClock which ticks as per the specified duration.
     * This action is scheduled at the provided fixed time unit rate.
     */
    void printBackDateTickingClock();

    /**
     * Creates and executes a periodic action, of printing the instant of the baseClock which ticks as per the current time.
     * This action is scheduled at the provided fixed time unit rate.
     */
    void printCurrentTickingClock();
}