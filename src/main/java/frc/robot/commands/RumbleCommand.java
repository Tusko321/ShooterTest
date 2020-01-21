/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class RumbleCommand extends CommandBase {
    private Joystick joystick;
    private GenericHID.RumbleType left, right;

    private double rumbleSpeed;

    public RumbleCommand(GenericHID.RumbleType left, GenericHID.RumbleType right, double rumbleSpeed, Joystick joystick) 
    {
        this.left = left;
        this.right = right;
        this.rumbleSpeed = rumbleSpeed;

        this.joystick = joystick;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() 
    {
        joystick.setRumble(left, rumbleSpeed);
        joystick.setRumble(right, rumbleSpeed);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() 
    {

    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) 
    {

    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return true;
    }
}
