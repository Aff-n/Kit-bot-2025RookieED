package com.stuypulse.robot.commands.superstructure;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import com.stuypulse.robot.subsystems.superstructure.Superstructure;
import com.stuypulse.robot.subsystems.superstructure.Superstructure.SuperstructureState;

public class SuperStructureSetState extends InstantCommand {

    private final Superstructure superstructure;
    private final SuperstructureState state;

    public SuperStructureSetState(SuperstructureState state) {
        this.superstructure = Superstructure.getInstance();
        this.state = state;

        addRequirements(superstructure);
    }

    @Override
    public void initialize () {
        superstructure.setState(state);
    }
}