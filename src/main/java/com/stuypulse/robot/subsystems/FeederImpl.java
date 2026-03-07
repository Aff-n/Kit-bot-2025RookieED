package com.stuypulse.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.spark.SparkMax;
import com.stuypulse.robot.constants.Motors;
import com.stuypulse.robot.constants.Ports;

public class FeederImpl extends Feeder{
    private final SparkMax feederMotor1;
    private final SparkMax feederMotor2;

    public FeederImpl(){
        feederMotor1 = new SparkMax(Ports.Feeder.FEEDER_MOTOR_1, null);
        feederMotor2 = new SparkMax(Ports.Feeder.FEEDER_MOTOR_2, null);

         Motors.Feeder.MOTOR_CONFIG_1.configure(feederMotor1);
    }
}