package com.stuypulse.robot.commands.superstructure;

import com.stuypulse.robot.subsystems.superstructure.Superstructure.SuperstructureState;

public class SuperStructureIntake extends SuperStructureSetState {
    public SuperStructureIntake(){
        super(SuperstructureState.INTAKING);
    }
}