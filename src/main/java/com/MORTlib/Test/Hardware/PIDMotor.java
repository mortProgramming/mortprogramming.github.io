package com.MORTlib.Test.Hardware;

import edu.wpi.first.math.controller.PIDController;

public class PIDMotor implements MotorIntf {

    public int motorID;
    public MotorTypeEnum motorType;

    public Motor motor;

    public PIDController controller;

    public PIDMotor(MotorTypeEnum motorType, int motorID) {
        this.motorID = motorID;
        this.motorType = motorType;

        motor = new Motor(motorType, motorID);

        controller = new PIDController(0, 0, 0);
        controller.enableContinuousInput(-180, 180);
        controller.setTolerance(2, 10);
    }

    public void setCurrentLimit(double limit) {
        motor.setCurrentLimit(limit);
    }

    public void setDirection(boolean direction) {
        motor.setDirection(direction);
    }

    public void setPositionD(double position, double setpoint) {
        motor.setVoltage(controller.calculate(position, setpoint));
    }

    public void setPercent(double percent) {
        motor.setPercent(percent);
    }

    public void setVoltage(double voltage) {
        motor.setVoltage(voltage);
    }

    public void setPIDValues(double kP, double kI, double kD) {
        controller = new PIDController(kP, kI, kD);
    }

    public void setPIDTolerance(double position, double velocity) {
        controller.setTolerance(position, velocity);
    }



    public double getPositionD() {
        return motor.getPositionD();
    }

    public double getPosition() {
        return motor.getPosition();
    }

    public double getVelocityD() {
        return motor.getVelocityD();
    }

    public double getVelocity1() {
        return motor.getVelocity1();
    }

    public MotorIntf getMotor() {
        return motor;
    }

    public MotorTypeEnum getMotorType() {
        return motorType;
    }

}