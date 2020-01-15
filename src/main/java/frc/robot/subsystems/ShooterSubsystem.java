/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class ShooterSubsystem extends SubsystemBase {
    private VictorSPX motor3;
    private VictorSPX motor4;

    private VictorSPX leftMotors;
    private VictorSPX rightMotors;

    public ShooterSubsystem() {
        this(new VictorSPX(0), new VictorSPX(2), new VictorSPX(3), new VictorSPX(4));
    }

    public ShooterSubsystem(VictorSPX rMotors, VictorSPX lMotors, VictorSPX motor3, VictorSPX motor4) {
        // Init motors
        this.rightMotors = rMotors;
        this.leftMotors = lMotors;
        this.motor3 = motor3;
        this.motor4 = motor4;

        this.motor3.follow(this.rightMotors);
        this.motor4.follow(this.leftMotors);
    }

    public void setSpeed(double speed) {
        // Function that sets motor speed
        rightMotors.set(ControlMode.PercentOutput, -speed);
        leftMotors.set(ControlMode.PercentOutput, speed);
    }

    public double getRPM(double speed) {
        if (speed < 0) {
            throw (new NumberFormatException("Speed should not be less than zero"));
        }
        return (6260 * speed) - 223;
    }

    public double getSetPoint(double rpm) {
        if (rpm < 0) {
            throw (new NumberFormatException("RPM should not be less than zero"));
        }
        return (rpm - 223) / 6260;
    }

    // Stops motors
    public void stop() {
        setSpeed(0.0);
    }

    @Override
    public void periodic() {

    }
}
