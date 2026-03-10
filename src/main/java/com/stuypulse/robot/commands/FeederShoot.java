package com.stuypulse.robot.commands;

import com.stuypulse.robot.subsystems.feeder.Feeder.FeederState;

public class FeederShoot extends FeederSetState{
    public FeederShoot(){
        super(FeederState.SHOOT);
    }
}
