package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class HangSubsystem extends SubsystemBase {
  public static CANSparkMax hangMotorLeft, hangMotorRight;
  public static DoubleSolenoid sol;
  public static DigitalInput topLimit, bottomLimit;

  public HangSubsystem() {
    hangMotorLeft = new CANSparkMax(Constants.kCHangLeft, MotorType.kBrushless);
    hangMotorRight = new CANSparkMax(Constants.kCHangRight, MotorType.kBrushless);

    hangMotorLeft.restoreFactoryDefaults();
    hangMotorRight.restoreFactoryDefaults();
    
    hangMotorLeft.setInverted(false);
    hangMotorRight.setInverted(false);

    sol = new DoubleSolenoid(Constants.kPHangFwd, Constants.kPHangRev);

    topLimit = new DigitalInput(Constants.kDHangTop);
    bottomLimit = new DigitalInput(Constants.kDHangBottom);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public static boolean isPunchOut() {
    return sol.get() == DoubleSolenoid.Value.kReverse;
  }

  public static boolean isPunchIn() {
    return sol.get() == DoubleSolenoid.Value.kForward;
  }

  public static void setPunchOut() {
    sol.set(DoubleSolenoid.Value.kForward);
  }

  public static void setPunchIn() {
    sol.set(DoubleSolenoid.Value.kReverse);
  }
}