package com.stuypulse.robot.subsystems;

import com.stuypulse.robot.constants.Settings;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;

public class FeederSim extends Feeder{
    
    private FlywheelSim feeder; 

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
