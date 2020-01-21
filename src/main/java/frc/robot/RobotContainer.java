/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.RumbleCommand;
import frc.robot.commands.RunShooter;
import frc.robot.commands.StopShooter;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private Joystick joystick = new Joystick(0);

  private final ShooterSubsystem m_ShooterSubsystem = new ShooterSubsystem();

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    final JoystickButton a = new JoystickButton(joystick, 1);
    final JoystickButton b = new JoystickButton(joystick, 2);
    final JoystickButton x = new JoystickButton(joystick, 3);
    final JoystickButton y = new JoystickButton(joystick, 4);
    final JoystickButton rb = new JoystickButton(joystick, 6);
    final JoystickButton leftMenu = new JoystickButton(joystick, 7);
    final JoystickButton rightMenu = new JoystickButton(joystick, 8);

    b.whenPressed(new StopShooter(m_ShooterSubsystem));
    leftMenu.whenPressed(new RunShooter(m_ShooterSubsystem, -0.1));
    rightMenu.whenPressed(new RunShooter(m_ShooterSubsystem, 0.1));
    a.whenPressed(new RumbleCommand(GenericHID.RumbleType.kLeftRumble, GenericHID.RumbleType.kRightRumble, 1.0, joystick));
    b.whenPressed(new RumbleCommand(GenericHID.RumbleType.kLeftRumble, GenericHID.RumbleType.kRightRumble, 0.0, joystick));
    //rb.whenPressed(new RunShooter(m_ShooterSubsystem, 0.25));
    //a.whenPressed(new RunShooter(m_ShooterSubsystem, 0.5));
    //x.whenPressed(new RunShooter(m_ShooterSubsystem, 0.6));
    //y.whenPressed(new RunShooter(m_ShooterSubsystem, 1.0));
  }


  /*
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  //public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
   // return new RunShooter(m_ShooterSubsystem, joystick.getRawAxis(0));
  //}
}
