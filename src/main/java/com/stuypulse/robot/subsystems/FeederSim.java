package com.stuypulse.robot.subsystems;

import com.stuypulse.robot.constants.Gains;
import com.stuypulse.robot.constants.Settings;
import com.stuypulse.robot.subsystems.feeder.Feeder;
import com.stuypulse.stuylib.control.feedback.PIDController;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class FeederSim extends Feeder{
    
    private FlywheelSim feeder;
    private SimpleMotorFeedforward feedForward;
    private PIDController controller;

    public FeederSim(){
        super();
        
        DCMotor motor = DCMotor.getCIM(1);
        feeder = new FlywheelSim(
            LinearSystemId.createFlywheelSystem(
            motor,
            1.9,
            2),
        motor
        );
    }

    @Override
    public void periodic(){
        super.periodic();

        
        feeder.update(Settings.DT);
    }
}
