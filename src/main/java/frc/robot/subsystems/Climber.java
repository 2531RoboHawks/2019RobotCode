package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Climber extends Subsystem {

  // motors
  private WPI_TalonSRX frontMotor = new WPI_TalonSRX(9);
  private WPI_TalonSRX backMotor = new WPI_TalonSRX(10);
  private WPI_TalonSRX stiltMotor = new WPI_TalonSRX(11);

  @Override
  public void initDefaultCommand() {

  }

  public void setFrontClimb(double power) {
    frontMotor.set(power);
  }

  public void stopFrontClimb() {
    setFrontClimb(0);
  }

  public void setBackClimb(double power) {
    backMotor.set(power);
  }

  public void stopBackClimb() {
    setBackClimb(0);
  }

  public void setStilt(double drivePower) {
    stiltMotor.set(drivePower);
  }

  public void stopStilt() {
    setStilt(0);
  }

  public void stopAll() {
    stopFrontClimb();
    stopBackClimb();
    stopStilt();
  }

  public boolean isFrontAtTop() {
    return frontMotor.getSensorCollection().isFwdLimitSwitchClosed();
  }

  public boolean isFrontAtBottom() {
    return frontMotor.getSensorCollection().isRevLimitSwitchClosed();
  }

  public boolean isBackAtTop() {
    return backMotor.getSensorCollection().isFwdLimitSwitchClosed();
  }

  public boolean isBackAtBottom() {
    return backMotor.getSensorCollection().isRevLimitSwitchClosed();
  }

  public double getFrontPosition() {
    return (frontMotor.getSensorCollection().getQuadraturePosition() * RobotMap.climbEncoderScale);
  }

  public double getBackPosition() {
    return (backMotor.getSensorCollection().getQuadraturePosition() * RobotMap.climbEncoderScale);
  }
}
