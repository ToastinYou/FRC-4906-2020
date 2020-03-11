/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  //private UsbCamera cam;

  // The robot's subsystems and commands are defined here...
  private final AirSubsystem m_airSubsystem = new AirSubsystem();
  private final ColorSubsystem m_colorSubsystem = new ColorSubsystem();
  private final ConveyorSubsystem m_conveyorSubsystem = new ConveyorSubsystem();
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final HangSubsystem m_hangSubsystem = new HangSubsystem();
  private final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  private final ShiftSubsystem m_shiftSubsystem = new ShiftSubsystem();
  private final ShooterSubsystem m_shooterSubsystem = new ShooterSubsystem();

  private final ColorCommand m_colorCommand = new ColorCommand(m_colorSubsystem);
  private final ConveyorCommand m_conveyorCommand = new ConveyorCommand(m_conveyorSubsystem);
  private final DriveCommand m_driveCommand = new DriveCommand(m_driveSubsystem);
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final HangCommand m_hangAirBrakeCommand = new HangCommand(m_hangSubsystem);
  private final HangCommand m_hangCommand = new HangCommand(m_hangSubsystem);
  private final IntakeCommand m_intakeCommand = new IntakeCommand(m_intakeSubsystem);
  private final IntakeCommand m_intakePistonCommand = new IntakeCommand(m_intakeSubsystem);
  private final ShiftCommand m_shiftCommand = new ShiftCommand(m_shiftSubsystem);
  private final ShooterCommand m_shooterCommand = new ShooterCommand(m_shooterSubsystem);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    
    /*ColorSensor.Initialize();

    // default driver mode for limelight camera w/LEDs off.
    LimeLight.setCameraMode(LimeLight.CameraMode.eDriver);
    LimeLight.setLedMode(LimeLight.LightMode.eOff);

    cam = CameraServer.getInstance().startAutomaticCapture();
    cam.setResolution(720, 480); // might need to be lowered*/
    
    m_colorSubsystem.setDefaultCommand(m_colorCommand);
    m_conveyorSubsystem.setDefaultCommand(m_conveyorCommand);
    m_driveSubsystem.setDefaultCommand(m_driveCommand);
    m_hangSubsystem.setDefaultCommand(m_hangCommand);
    m_intakeSubsystem.setDefaultCommand(m_intakeCommand);
    m_shiftSubsystem.setDefaultCommand(m_shiftCommand);
    m_shooterSubsystem.setDefaultCommand(m_shooterCommand);

    m_colorCommand.schedule();
    m_conveyorCommand.schedule();
    m_driveCommand.schedule();
    m_hangCommand.schedule();
    m_intakeCommand.schedule();
    m_shiftCommand.schedule();
    m_shooterCommand.schedule();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    OI.getBButtonObject().whenReleased(new IntakePistonCommand(m_intakeSubsystem));
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
