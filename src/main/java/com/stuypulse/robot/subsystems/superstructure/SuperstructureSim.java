package com.stuypulse.robot.subsystems.superstructure;

// import com.ctre.phoenix6.hardware.TalonFX;
// import com.stuypulse.robot.constants.Field;
// import com.stuypulse.robot.util.ShooterInterpolation;
// import com.stuypulse.robot.util.superstructure.Interpolation;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.stuypulse.robot.constants.Gains;
// import com.stuypulse.robot.constants.Settings;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.system.plant.LinearSystemId;

public class SuperstructureSim extends Superstructure {    
    private final FlywheelSim motor; 
    private final PIDController shooterController;

    public SuperstructureSim() {
        super();
        
        // DCMotor gearbox = DCMotor.getKrakenX60(1);

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
            Gains.Superstructure.kP,
            Gains.Superstructure.kI,
            Gains.Superstructure.kD
        );
    }

    public double getShooterRPM() {
        return motor.getAngularVelocityRPM();
    }
    
    @Override
    public void periodic() {
        super.periodic();

        double targetRPM = getState().getTargetRPM();
        double currentRPM = getShooterRPM();

        double voltage = shooterController.calculate(currentRPM, targetRPM);
        motor.setInputVoltage(voltage);
        
        SmartDashboard.putNumber("Superstructure/Simulated RPM", getShooterRPM());
        SmartDashboard.putNumber("Superstructure/Target RPM", targetRPM);
    }
}