/************************ PROJECT PHIL ************************/
/* Copyright (c) 2024 StuyPulse Robotics. All rights reserved.*/
/* This work is licensed under the terms of the MIT license.  */
/**************************************************************/

package com.stuypulse.robot.constants;

import com.stuypulse.stuylib.network.SmartBoolean;
import com.stuypulse.stuylib.network.SmartNumber;

import edu.wpi.first.math.geometry.Rotation2d;

/*-
 * File containing tunable settings for every subsystem on the robot.
 *
 * We use StuyLib's SmartNumber / SmartBoolean in order to have tunable
 * values that we can edit on Shuffleboard.
 */
public interface Settings {
    public interface Intake{

        Rotation2d Idle_Angle = Rotation2d.fromDegrees(6.7);//change all of these later
        Rotation2d Intake_Angle = Rotation2d.fromDegrees(1.1);
        Rotation2d Out_Angle = Rotation2d.fromDegrees(1);
        Rotation2d Up_Angle = Rotation2d.fromDegrees(1);
        Rotation2d Down_Angle = Rotation2d.fromDegrees(1);
    }

}
