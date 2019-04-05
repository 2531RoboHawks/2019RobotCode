package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.commands.WristDefault;

public class Wrist extends Subsystem {

  private WPI_TalonSRX motor = new WPI_TalonSRX(7);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new WristDefault());
  }

  public void set(double pow) {
    motor.set(pow);
  }

  public void stop() {
    set(0);
  }
}
