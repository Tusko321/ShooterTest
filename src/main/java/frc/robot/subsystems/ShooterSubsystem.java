/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ShooterSubsystem extends SubsystemBase {

    private CANSparkMax leftMotors;
    private CANSparkMax rightMotors;

    private double speed;

    public ShooterSubsystem() {
        this(new CANSparkMax(1, MotorType.kBrushless), new CANSparkMax(2, MotorType.kBrushless)); //new CANSparkMax(2, MotorType.kBrushless), new CANSparkMax(3, MotorType.kBrushless));
    }

    public ShooterSubsystem(CANSparkMax rMotors, CANSparkMax lMotors) {
        // Init motors
        this.rightMotors = rMotors;
        this.leftMotors = lMotors;
        //this.motor3 = motor3;
        //this.motor4 = motor4;

        //this.motor3.follow(this.rightMotors);
        //this.motor4.follow(this.leftMotors);

        //this.leftMotors.setClosedLoopRampRate(2);
        //this.rightMotors.setClosedLoopRampRate(2);
        //this.motor3.setClosedLoopRampRate(2);
        //this.motor4.setClosedLoopRampRate(2);
    }

    public void setSpeed(double speed) {
        // Function that sets motor speed
        rightMotors.set(speed);
        leftMotors.set(-speed);
    }

    public void addSpeed(double speed)
    {
        if(this.speed + speed >= 1.0)
        {
            this.speed = 1.0;
        }
        else
        {
            this.speed += speed;
        }
        setSpeed(this.speed);
    }

    public double getRPM(double speed) throws NumberFormatException {
        if (speed < 0) {
            System.out.println("Speed has been set less than zero!");
            //throw (new NumberFormatException("Speed should not be less than zero"));
        }
        return (6260 * speed) - 223;
    }

    public double getSetPoint(double rpm) throws NumberFormatException {
        if (rpm < 0) {
            System.out.println("RPM has been set below zero!");
            //throw (new NumberFormatException("RPM should not be less than zero"));
        }
        return (rpm + 223) / 6260;
    }

    // Stops motors
    public void stop() {
        speed = 0.0;
        setSpeed(0.0);
    }

    @Override
    public void periodic() {      
        //System.out.println("Left motors: " + leftMotors.getAlternateEncoder().getVelocity());
        //System.out.println("Right motors: " + rightMotors.getAlternateEncoder().getVelocity());
    }
}
