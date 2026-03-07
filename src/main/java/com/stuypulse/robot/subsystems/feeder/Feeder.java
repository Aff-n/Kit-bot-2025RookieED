package com.stuypulse.robot.subsystems.feeder;

import com.stuypulse.robot.Robot;
import com.stuypulse.robot.constants.Settings;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public abstract class Feeder extends SubsystemBase {
    private static final Feeder instance;
    private FeederState state;

    static {
        if (Robot.isReal()) {
            instance = new FeederImpl();
        } else {
            instance = new FeederSim();
        }
    }

    public static Feeder getInstance() {
        return instance;
    }

    public enum FeederState {
        IDLE(0),
        INTAKE(Settings.Feeder.FEEDER_INTAKE),
        SHOOT(Settings.Feeder.FEEDER_SHOOT);
        
        private double targetDutyCycle;

        private FeederState(double targetDutyCycle) {
            this.targetDutyCycle = targetDutyCycle;
        }

        public double getDutyCycle() {
            return this.targetDutyCycle;
        }
    }

    protected Feeder() {
        this.state = FeederState.IDLE;
    }

    public FeederState getState() {
        return state;
    }
    
    public void setState(FeederState state) {
        this.state = state;
    }
    
    @Override
    public void periodic() {
        SmartDashboard.putString("Feeder/State", getState().name());
        SmartDashboard.putString("States/Feeder", getState().name());
    }
}