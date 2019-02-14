package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.Drive;

public class DriveSystem extends Subsystem {

  // motors
  private WPI_TalonSRX leftMotor1 = new WPI_TalonSRX(1);
  private WPI_TalonSRX leftMotor2 = new WPI_TalonSRX(2);
  private WPI_TalonSRX rightMotor1 = new WPI_TalonSRX(3);
  private WPI_TalonSRX rightMotor2 = new WPI_TalonSRX(4);

  // pneumatics
  private Solenoid shifterHigh = new Solenoid(0);
  private Solenoid shifterLow = new Solenoid(1);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Drive());
  }

  public void tankDrive(double leftPower, double rightPower) {
    leftMotor1.set(leftPower);
    leftMotor2.set(leftPower);
    rightMotor1.set(-rightPower);
    rightMotor2.set(-rightPower);
  }

  public void arcadeDrive(double power, double steering) {
    double leftPower = (power + steering);
    double rightPower = (power - steering);
    tankDrive(leftPower, rightPower);
  }

  public void shiftGear(boolean high) {
    shifterHigh.set(!high);
    shifterLow.set(high);
  }

  public boolean isHighGear() {
    return shifterHigh.get();
  }

  public void stop() {
    tankDrive(0, 0);
  }
}
