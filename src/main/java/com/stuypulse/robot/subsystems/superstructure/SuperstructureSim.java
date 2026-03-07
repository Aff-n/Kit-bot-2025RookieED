package com.stuypulse.robot.subsystems.superstructure;

import com.ctre.phoenix6.hardware.TalonFX;
import com.stuypulse.robot.constants.Field;
import com.stuypulse.robot.util.ShooterInterpolation;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.system.plant.LinearSystemId;

public class SuperstructureSim extends Superstructure {    
    private final FlywheelSim motor; 
    private final PIDController shooterController;

    public SuperstructureSim() {
        DCMotor gearbox = DCMotor.getKrakenX60(1);

        motor = new FlywheelSim(
            LinearSystemId.createFlywheelSystem(
                DCMotor.getKrakenX60(1),
                1.0,
                0.02
            // TODO: what to do with these 2 variables
            ),
            DCMotor.getKrakenX60(1)
        );

        shooterController = new PIDController(
            3,
            2,
            1
        );
    }

    public double getShooterRPM() {
        return motor.getAngularVelocityRPM();
    }
}