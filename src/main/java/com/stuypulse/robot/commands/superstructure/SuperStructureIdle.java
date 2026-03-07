package com.stuypulse.robot.commands.superstructure;

import com.stuypulse.robot.subsystems.superstructure.Superstructure.SuperstructureState;

public class SuperStructureIdle extends SuperStructureSetState {
    public SuperStructureIdle(){
        super(SuperstructureState.IDLE);
    }
}