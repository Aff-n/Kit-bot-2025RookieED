package com.stuypulse.robot.util;

import edu.wpi.first.math.interpolation.InterpolatingDoubleTreeMap;

public class ShooterInterpolation {
    private static final InterpolatingDoubleTreeMap ShooterInterpolater;


    //TODO: Get from testing
    private static final double[][] RPMAndDistance = {
        {50, 0},
        {100, 5},
        {200, 10}
    };

    static {
        ShooterInterpolater = new InterpolatingDoubleTreeMap();

        for (double[] data : RPMAndDistance) {
            ShooterInterpolater.put(data[0], data[1]);
        }
    }

    public static double getRPM(double distance) {
        Double rpm = ShooterInterpolater.get(distance);
        return rpm != null ? rpm : 0.0; /*if not null, return rpm
                                          else, return 0.0.      */
    }
}