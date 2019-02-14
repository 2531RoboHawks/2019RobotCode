package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

  private WPI_TalonSRX motor = new WPI_TalonSRX(8);

  @Override
  public void initDefaultCommand() {

  }

  public void setMotor(double power) {
    motor.set(power);
  }

  public void stop() {
    setMotor(0);
  }
}
