package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShiftSubsystem extends SubsystemBase {
  public static DoubleSolenoid sol1;

  public ShiftSubsystem() {
    sol1 = new DoubleSolenoid(Constants.kPShiftFwd, Constants.kPShiftRev);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}