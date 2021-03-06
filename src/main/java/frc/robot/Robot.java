/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import org.opencv.core.Mat;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.HttpCamera;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.DriveSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  private UsbCamera cam;

  //private boolean LimeLightLED, LimeLightCAM;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    
    ColorSensor.Initialize();

    // default driver mode for limelight camera w/LEDs off.
    LimeLight.setCameraMode(LimeLight.CameraMode.eDriver);
    LimeLight.setLedMode(LimeLight.LightMode.eOff);

    cam = CameraServer.getInstance().startAutomaticCapture();
    cam.setResolution(320, 420);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
    
    // this doesn't work
    /*if (OI.getJoystickLimeLightLED()) {
      LimeLightLED = !LimeLightLED;

      if (!LimeLightLED) {
        LimeLight.setLedMode(LimeLight.LightMode.eOff);
      }
      else {
        LimeLight.setLedMode(LimeLight.LightMode.eOn);
      }
    }*/

    // this doesn't work
    /*if (OI.getJoystickLimeLightCAM()) {
      LimeLightCAM = !LimeLightCAM;

      if (!LimeLightCAM) {
        LimeLight.setCameraMode(LimeLight.CameraMode.eDriver);
      }
      else {
        LimeLight.setCameraMode(LimeLight.CameraMode.eVision);
      }
    }*/

    /*if (OI.getJoystickAutomation() && !Constants.LimeLightControlling) {
      // turn on LED to detect reflective tape
      LimeLight.setLedMode(LimeLight.LightMode.eOn);
      Constants.LimeLightControlling = true;
      SmartDashboard.putBoolean("Foo", Constants.LimeLightControlling);
      
      double Kp = -0.1;

      double headingError = LimeLight.getTx();
      double steeringAdjust = Kp * headingError;

      DriveSubsystem.left = OI.getJoystickZ() + steeringAdjust;
      DriveSubsystem.right = OI.getJoystickZ() - steeringAdjust;

      DriveSubsystem.dDrive.arcadeDrive(OI.getJoystickY(), DriveSubsystem.left + DriveSubsystem.right);

      // foreseeing a problem... if drivebase is set to arcade drive, driver will not be able to go forward/backward due to this switching it to tank drive.
      //DriveSubsystem.dDrive.tankDrive(DriveSubsystem.left, DriveSubsystem.right);
      
      // turn LED back off so we don't get penalized.
      // might flash on/off since this will be looped.. will have to test.
      //LimeLight.setLedMode(LimeLight.LightMode.eOff);
    }
    else {
      Constants.LimeLightControlling = false;
      DriveSubsystem.left = 0;
      DriveSubsystem.right = 0;
    }*/

    /*if (OI.getStartButton()) {
      HangAirBrakeCommand.ToggleAirBrake();
    }*/

    /*if (OI.getBButton()) {
      IntakePistonCommand.ToggleIntakePiston();
    }*/
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {   
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
