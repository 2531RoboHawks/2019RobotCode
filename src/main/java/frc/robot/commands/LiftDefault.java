package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frclib.pid.PID;

public class LiftDefault extends Command {

  private int height = 0;

  private PID pid = new PID(0.08, 0, 0, 0);

  public LiftDefault() {
    requires(Robot.lift);
  }

  @Override
  protected void initialize() {
    System.out.println("-> Lift Default");
    pid.setOnTargetCount(10);
    pid.setOutputLimits(-0.1, 0.1);
    pid.setOnTargetOffset(1);
  }

  @Override
  protected void execute() {
    if (OI.gamepad.getRawButton(OI.LOAD_HATCH_HEIGHT_BUTTON)) {
      height = RobotMap.LOADING_HATCH;
    } else if (OI.gamepad.getRawButton(OI.LOAD_CARGO_HEIGHT_BUTTON)) {
      height = RobotMap.LOADING_HATCH;
    } else if (OI.gamepad.getRawButton(OI.SCORE_CARGOSHIP_BUTTON)) {
      if (RobotMap.cargoDetestionSwitch.get()) {
        height = RobotMap.CARGOSHIP_CARGO;
      } else {
        height = RobotMap.CARGOSHIP_HATCH;
      }
    } else if (OI.gamepad.getRawButton(OI.SCORE_ROCKET_LOW_BUTTON)) {
      if (RobotMap.cargoDetestionSwitch.get()) {
        height = RobotMap.ROCKET_LEVEL1_CARGO;
      } else {
        height = RobotMap.ROCKET_LEVEL1_HATCH;
      }
    } else if (OI.gamepad.getRawButton(OI.SCORE_ROCKET_MID_BUTTON)) {
      if (RobotMap.cargoDetestionSwitch.get()) {
        height = RobotMap.ROCKET_LEVEL2_CARGO;
      } else {
        height = RobotMap.ROCKET_LEVEL2_HATCH;
      }
    } else if (OI.gamepad.getRawButton(OI.SCORE_ROCKET_HIGH_BUTTON)) {
      if (RobotMap.cargoDetestionSwitch.get()) {
        height = RobotMap.ROCKET_LEVEL3_CARGO;
      } else {
        height = RobotMap.ROCKET_LEVEL3_HATCH;
      }
    } else if (OI.gamepad.getRawButton(OI.RETURN_BUTTON)) {
      height = 0;
    }
    if (OI.joystick.getRawButton(OI.LIFT_TRIGGER_BUTTON)) {
      pid.setSetpoint(height + RobotMap.liftAdjustment);
    } else {
      // pid.setSetpoint(0);
      Robot.lift.stop();
    }
    double power = pid.compute(Robot.lift.getPosition());
    if ((power > 0 && Robot.lift.isAtTop()) || (power < 0 && Robot.lift.isAtBottom())) {
      Robot.lift.stop();
    } else {
      Robot.lift.set(power);
    }
    RobotMap.liftOnTarget = pid.onTarget();
    RobotMap.liftTargetHeight = height;
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.lift.stop();
    System.out.println("-! Lift Default");
  }

  @Override
  protected void interrupted() {
    end();
  }
}
