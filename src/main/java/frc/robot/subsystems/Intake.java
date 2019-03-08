package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.*;

public class Intake extends Subsystem {

  private WPI_VictorSPX motor = new WPI_VictorSPX(8);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new IntakeDefault());
  }

  public void setMotor(double power) {
    motor.set(power);
  }

  public void stop() {
    setMotor(0);
  }
}
