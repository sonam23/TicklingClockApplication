package com.janio.clock.model;

import com.janio.clock.impl.ApplicationProperties;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class SpecialClock {
    public final static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    public final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss");
    public final static ZoneId sgt = ZoneId.of(ApplicationProperties.INSTANCE.getZoneId());

    private Clock nowClock = null;

    private int offset;

    /**
     * Obtains a clock that uses the best available system clock in the default zone, with specified duration added
     * @param offset duration to add, not null, in hours, could be negative
     */
    public SpecialClock(int offset){
        this.offset = offset;
        nowClock = Clock.tick(Clock.systemDefaultZone(), Duration.ofSeconds(ApplicationProperties.INSTANCE.getTimeDuration()));
    }

    public String printBackTime() {
        return ZonedDateTime.ofInstant(nowClock.instant(), sgt).minusHours(offset).format(timeFormatter);
    }

    public String printNowTime() {
        return ZonedDateTime.ofInstant(nowClock.instant(), sgt).format(timeFormatter);
    }

    public String printBackDateTime() {
        return ZonedDateTime.ofInstant(nowClock.instant(), sgt).minusHours(offset).format(dateTimeFormatter);
        //return backTimedClock.format(dateTimeFormatter);
    }

    public String printNowDateTime() {
        return ZonedDateTime.ofInstant(nowClock.instant(), sgt).format(dateTimeFormatter);
       // return nowClock.format(dateTimeFormatter);
    }
}
