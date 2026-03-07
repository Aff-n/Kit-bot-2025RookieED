package com.stuypulse.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.stuypulse.robot.Robot;
import com.stuypulse.robot.constants.Settings;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Feeder extends SubsystemBase{
    private static Feeder instance;
    private FeederState state;

    static {
        if (Robot.isReal()) {
            instance = new FeederImpl();
        } else {
            instance = new FeederSim();
        }
    }

    private static Feeder getInstance(){
        return instance;
    }
    
    public enum FeederState{
        IDLE(0),
        REVERSE(Settings.Feeder.FEEDER_REVERSE),
        FORWARD(Settings.Feeder.FEEDER_FORWARD);
        
        private double TargetRPM;

        private FeederState(double TargetRPM){
            this.TargetRPM=TargetRPM;
        }

        private double getTargetRPM(){
            return this.TargetRPM;
        }
    }

    protected Feeder() {
        this.state = FeederState.IDLE;
    }

    private FeederState getState(){
        return state;
    }
    
    private void setState(FeederState state){
        this.state = state;
    }
    
    @Override
    public void periodic() {
        SmartDashboard.putString("Feeder/State", getState().name());
        SmartDashboard.putString("States/Feeder", getState().name());
    }
}