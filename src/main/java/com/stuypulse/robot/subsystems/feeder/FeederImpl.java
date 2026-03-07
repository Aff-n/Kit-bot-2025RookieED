package com.stuypulse.robot.subsystems.feeder;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.stuypulse.robot.constants.Motors;
import com.stuypulse.robot.constants.Ports;

public class FeederImpl extends Feeder {
    private final SparkMax feederMotor;

    public FeederImpl() {
        feederMotor = new SparkMax(Ports.Feeder.FEEDER_MOTOR, MotorType.kBrushed);

        feederMotor.configure(
            Motors.Feeder.MOTOR_CONFIG,
            ResetMode.kResetSafeParameters,
            PersistMode.kPersistParameters
        );
    }

    public void setMotors() {
        feederMotor.set(getState().getDutyCycle());
    }

    @Override
    public void periodic() {
        super.periodic();
    }
}