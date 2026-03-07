package com.stuypulse.robot.subsystems.superstructure;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.stuypulse.robot.constants.Settings;


public abstract class Superstructure extends SubsystemBase {
    private static final Superstructure instance;

    static {
        // if (Robot.isReal()) {
        instance = new SuperstructureImpl();
        // } else {
        //     instance = new SuperstructureSim();
        // }
    }

    public static Superstructure getInstance() {
        return instance;
    }

    public enum SuperstructureState { 
        IDLE(0),
        SHOOTING(Settings.Superstructure.SHOOT_SPEED), 
        INTAKING(Settings.Superstructure.INTAKE_SPEED),
        OUTTAKING(Settings.Superstructure.OUTTAKE_SPEED);
        
        private double RPM;

        private SuperstructureState(double RPM) {
            this.RPM = RPM;
        }

        public double getTargetRPM() {
            return RPM;
        }
    }

    public SuperstructureState state;

    protected Superstructure() {
        state = SuperstructureState.IDLE;
    }

    public SuperstructureState getState() {
        return state;
    }

    public void setState(SuperstructureState state) {
        this.state = state;
    }

    @Override
    public void periodic() {
        SmartDashboard.putString("Superstructure/State", getState().name());
        SmartDashboard.putString("States/Superstructure", getState().name());

        SmartDashboard.putNumber("Superstructure/TargetRPM", getState().getTargetRPM());
    }
}