package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class GearboxShift extends SubsystemBase {
  public static DoubleSolenoid sol1;

  public GearboxShift() {
    sol1 = new DoubleSolenoid(Constants.PWM0, Constants.PWM1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}