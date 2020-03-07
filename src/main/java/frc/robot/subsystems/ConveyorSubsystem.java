package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.playingwithfusion.TimeOfFlight;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ConveyorSubsystem extends SubsystemBase {
  public static WPI_VictorSPX verticalMotor, horizontalMotor;
  //public static TimeOfFlight tof1, tof2;

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

  public ConveyorSubsystem() {
    horizontalMotor = new WPI_VictorSPX(Constants.kCConveyorHoriz);
    verticalMotor = new WPI_VictorSPX(Constants.kCConveyorVert);

    //tof1 = new TimeOfFlight(Constants.CANUNKWN);
    //tof2 = new TimeOfFlight(Constants.CANUNKWN);

    State = Stage.Wait;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
