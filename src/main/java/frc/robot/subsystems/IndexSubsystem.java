package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.playingwithfusion.TimeOfFlight;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IndexSubsystem extends SubsystemBase {
  public static WPI_VictorSPX lowMotor, highMotor;
  public static TimeOfFlight tof1, tof2;

  public static enum Stage {
    Wait,
    First,
    Second,
    Third,
    Fourth,
    Fifth,
    Done,
    WaitForBall,
    WaitForNoBall,
  }

  public static Stage State;
  public static Stage ReturnState;

  public IndexSubsystem() {
    lowMotor = new WPI_VictorSPX(Constants.CAN11);
    highMotor = new WPI_VictorSPX(Constants.CAN4);

    tof1 = new TimeOfFlight(Constants.CAN13);
    tof2 = new TimeOfFlight(Constants.CAN14);

    State = Stage.Wait;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
