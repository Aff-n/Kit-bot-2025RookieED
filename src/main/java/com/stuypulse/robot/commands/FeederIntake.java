package com.stuypulse.robot.commands;

import com.stuypulse.robot.subsystems.feeder.Feeder.FeederState;

public class FeederIntake extends FeederSetState{
    public FeederIntake() {
        super(FeederState.INTAKE);
    }
}
