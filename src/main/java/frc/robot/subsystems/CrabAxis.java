package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.CrabDefault;

public class CrabAxis extends Subsystem {

  private WPI_TalonSRX motor = new WPI_TalonSRX(7);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new CrabDefault());
  }

  public void set(double power) {
     motor.set(power);
  }

  public void stop() {
    set(0);
  }

  public double getPosition() {
    return (motor.getSensorCollection().getQuadraturePosition() * RobotMap.crabEncoderScale);
  }

  public boolean isAtLeft() {
    return motor.getSensorCollection().isRevLimitSwitchClosed();
  }

  public boolean isAtRight() {
    return motor.getSensorCollection().isFwdLimitSwitchClosed();
  }
}
