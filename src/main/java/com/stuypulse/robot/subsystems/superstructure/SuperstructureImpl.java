package com.stuypulse.robot.subsystems.superstructure;

import java.util.Optional;

import com.ctre.phoenix6.controls.MotionMagicVelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;                     
import com.stuypulse.robot.constants.Motors;                                                                                         
import com.stuypulse.robot.constants.Ports;
import com.stuypulse.robot.constants.Settings;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SuperstructureImpl extends Superstructure {
    private final TalonFX motor;
    private final MotionMagicVelocityVoltage motorController;
    private Optional<Double> voltageOverride;

    public SuperstructureImpl() {
        motor = new TalonFX(Ports.Superstructure.MOTOR);
        motorController = new MotionMagicVelocityVoltage(getState().getTargetRPM()).withSlot(0);

        Motors.SuperstructureMotors.SUPERSTRUCTURE_MOTOR.configure(motor);
        voltageOverride = Optional.empty();
    }
    
    public void setVoltagesBasedOnState() {
        motor.setControl(motorController.withVelocity(getState().getTargetRPM() / 60)); // dividing 60 converts RPM to RPS, which motorController takes
    }

    public void setVoltageOverride(Optional<Double> volts) {
        this.voltageOverride = volts;
    }

    @Override
    public void periodic() {
        super.periodic();
        if (Settings.EnabledSubsystems.Superstructure.get()) {
            if (voltageOverride.isPresent()) {
                motor.setVoltage(voltageOverride.get());
            } else {
                setVoltagesBasedOnState();
            }
        }

        SmartDashboard.putNumber("Shooter/Target RPM", getState().getTargetRPM());
        SmartDashboard.putNumber("Shooter/Current RPM", motor.getVelocity().getValueAsDouble() * 60);
    }
}