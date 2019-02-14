package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.LiftDefault;

public class Lift extends Subsystem {

  private WPI_TalonSRX motor1 = new WPI_TalonSRX(5);
  private WPI_TalonSRX motor2 = new WPI_TalonSRX(6);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new LiftDefault());
  }

  public void set(double power) {
    motor1.set(power);
    motor2.set(power);
  }

  public void stop() {
    set(0);
  }

  public double getPosition() {
    return motor1.getSensorCollection().getQuadraturePosition() * RobotMap.liftEncoderScale;
  }

  public boolean isAtBottom() {
    return motor1.getSensorCollection().isRevLimitSwitchClosed();
  }

  public boolean isAtTop() {
    return motor1.getSensorCollection().isFwdLimitSwitchClosed();
  }

  public void zero() {
    setSensor(0);
  }

  public void setSensor(int pos) {
    motor1.getSensorCollection().setQuadraturePosition(pos, 30);
  }
}
