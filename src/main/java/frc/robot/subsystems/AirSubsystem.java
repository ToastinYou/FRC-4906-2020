package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class AirSubsystem extends SubsystemBase {
  public static Compressor air;

  public AirSubsystem() {
    air = new Compressor(0);
    air.setClosedLoopControl(true);
    air.start();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
