package com.stuypulse.robot.subsystems.intake;

import com.stuypulse.robot.Robot;
import com.stuypulse.robot.constants.Settings;

import edu.wpi.first.wpilibj2.command.SubsystemBase;



public abstract class Intake extends SubsystemBase {
    
    private final static Intake instance;
    private IntakeState state;
        
    
    static {
        if (Robot.isReal()){
            instance = new IntakeImpl();
                          
        } else {
            instance = new IntakeSim();  
        }
    public enum IntakeState{
        IDLE (Settings.Intake.Idle_Angle, Settings.Intakete)
        INTAKE (Settings.Intake.Intake_Angle)
        OUTTAKE
        UP
        DOWN

    }
    }

    }