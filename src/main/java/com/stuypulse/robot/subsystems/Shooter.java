package com.stuypulse.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class Shooter extends SubsystemBase {
    private static final Shooter instance;

    static {
        // if (Robot.isReal()) {
        instance = new ShooterImpl();
        // } else {
        //     instance = new ShooterSim();
        // } 
    }

    public static Shooter getInstance() {
        return instance;
    }

    public enum ShooterState {
        IDLE(0), SHOOTING(1), FERRYING(2);

        private double RPM;

        private ShooterState(double RPM) {
            this.RPM = RPM;
        }

        public double getTargetRPM() {
            return RPM;
        }
    }
    public ShooterState state;

    public ShooterState getState() {
        return state;
    }

    public void setState(ShooterState state) {
        this.state = state;
    }

    public boolean isShooting() {
        return state == ShooterState.SHOOTING;
    }
}