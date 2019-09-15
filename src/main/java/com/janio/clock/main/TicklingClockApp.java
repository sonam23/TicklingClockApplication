package com.janio.clock.main;

import com.janio.clock.impl.TickingClockImpl;
import com.janio.clock.model.SpecialClock;

import java.io.IOException;
import java.util.Scanner;

public class TicklingClockApp {

    static Scanner sc = new Scanner(System.in);

    public static int readValidInput(){
        System.out.println("Please provide Units to decrement time in hours(Integer) : ");
        while (!sc.hasNextInt()) {
            sc.nextLine(); //clear the invalid input before prompting again
            System.out.print("Wrong input, please provide a positive Integer : ");
        }

        int hours = sc.nextInt();
        System.out.println("Hours " + hours);
        return  hours;
    }

    public static void main(String[] args) throws IOException {

        int hours = readValidInput();
        SpecialClock clock = new SpecialClock(hours);
        TickingClockImpl tickingClock = new TickingClockImpl(clock);
        tickingClock.printBackDateTickingClock();
        sc.close();
    }

}
