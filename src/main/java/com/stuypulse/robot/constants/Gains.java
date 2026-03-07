package com.stuypulse.robot.constants;

import com.stuypulse.stuylib.network.SmartNumber;
public class Gains{

    public interface Feeder {
        double kP = 0.9;
        double kI = 0;
        double kD = 0;
        
        double kS = 0;
        double kG = 0;
        SmartNumber kV = new SmartNumber("Feeder/kV",0.5);
        SmartNumber kA = new SmartNumber("Feeder/kV",0.5);
    }


}