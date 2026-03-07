package com.stuypulse.robot.subsystems.superstructure;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class Superstructure extends SubsystemBase {
    private static final SuperstructureImpl instance;

    static {
        // if (Robot.isReal()) {
        instance = new SuperstructureImpl();
        // } else {
        //     instance = new SuperstructureSim();
        // } 
    }

    public static SuperstructureImpl getInstance() {
        return instance;
    }

    public enum SuperstructureState {
        IDLE(0),
        SHOOTING(1), // intaking as well?
        FERRYING(2); // outtaking as well?

        private double RPM;

        private SuperstructureState(double RPM) {
            this.RPM = RPM;
        }

        public double getTargetRPM() {
            return RPM;
        }
    }
    public SuperstructureState state;

    public SuperstructureState getState() {
        return state;
    }

    public void setState(SuperstructureState state) {
        this.state = state;
    }

    public boolean isShooting() {
        return state == SuperstructureState.SHOOTING;
    }
}