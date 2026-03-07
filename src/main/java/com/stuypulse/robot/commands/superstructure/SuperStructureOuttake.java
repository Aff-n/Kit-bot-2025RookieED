package com.stuypulse.robot.commands.superstructure;

import com.stuypulse.robot.subsystems.superstructure.Superstructure.SuperstructureState;

public class SuperStructureOuttake extends SuperStructureSetState {
    public SuperStructureOuttake(){
        super(SuperstructureState.OUTTAKING);
    }
}