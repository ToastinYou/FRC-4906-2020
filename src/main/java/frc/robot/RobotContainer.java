/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivebase m_drivebase = new Drivebase();
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final GearboxShiftSubsystem m_gearboxShiftSubsystem = new GearboxShiftSubsystem();

  private final ArcadeDrive m_arcadeDrive = new ArcadeDrive(m_drivebase);
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final GearboxShiftCommand m_gearboxShiftCommand = new GearboxShiftCommand(m_gearboxShiftSubsystem);
  private final TankDrive m_tankDrive = new TankDrive(m_drivebase);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    
    m_drivebase.setDefaultCommand(m_arcadeDrive);
    m_gearboxShiftSubsystem.setDefaultCommand(m_gearboxShiftCommand);
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    final Button aButton = new JoystickButton(Constants.XboxControl, XboxController.Button.kA.value);
    final Button xButton = new JoystickButton(Constants.XboxControl, XboxController.Button.kX.value);
    final Button yButton = new JoystickButton(Constants.XboxControl, XboxController.Button.kY.value);
    final Button bButton = new JoystickButton(Constants.XboxControl, XboxController.Button.kB.value);
    
    // 1
    final Button stickRightButton = new JoystickButton(Constants.XboxControl, XboxController.Button.kStickRight.value);

    // 2
    final Button dpadUp = new POVButton(Constants.XboxControl, 0);
    final Button dpadRight = new POVButton(Constants.XboxControl, 90);
    final Button dpadDown = new POVButton(Constants.XboxControl, 180);
    final Button dpadLeft = new POVButton(Constants.XboxControl, 270);

    // 3
    final Button stickLeftButton = new JoystickButton(Constants.XboxControl, XboxController.Button.kStickLeft.value);
    
    // 4
    final Button backButton = new JoystickButton(Constants.XboxControl, XboxController.Button.kBack.value);
    
    // 5
    final Button bumperLeftButton = new JoystickButton(Constants.XboxControl, XboxController.Button.kBumperLeft.value);

    // 6 -- left trigger

    // 7 -- XBOX home
    
    // 8
    final Button startButton = new JoystickButton(Constants.XboxControl, XboxController.Button.kStart.value);
    
    // 9 -- right trigger

    // 10
    final Button bumperRightButton = new JoystickButton(Constants.XboxControl, XboxController.Button.kBumperRight.value);

    //aButton.whenPressed(command);

    backButton.whenPressed(m_gearboxShiftCommand);
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
