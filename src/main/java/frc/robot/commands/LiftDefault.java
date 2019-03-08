package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frclib.pid.PID;

public class LiftDefault extends Command {

  private int[] height = { 0, 0 };

  private PID pid = new PID(0.08, 0, 0, 0);

  public LiftDefault() {
    requires(Robot.lift);
  }

  @Override
  protected void initialize() {
    System.out.println("-> Lift Default");
    pid.setOnTargetCount(10);
    pid.setOutputLimits(-0.3, 1);
    pid.setOnTargetOffset(1);
  }

  @Override
  protected void execute() {
    if (OI.gamepad.getRawButton(OI.LOAD_HATCH_HEIGHT_BUTTON)) {
      height = RobotMap.LOADING_CARGO;
    } else if (OI.gamepad.getRawButton(OI.LOAD_CARGO_HEIGHT_BUTTON)) {
      height = RobotMap.LOADING_HATCH;
    } else if (OI.gamepad.getRawButton(OI.SCORE_CARGOSHIP_BUTTON)) {
      height = RobotMap.CARGOSHIP;
    } else if (OI.gamepad.getRawButton(OI.SCORE_ROCKET_LOW_BUTTON)) {
      height = RobotMap.ROCKET_LEVEL1;
    } else if (OI.gamepad.getRawButton(OI.SCORE_ROCKET_MID_BUTTON)) {
      height = RobotMap.ROCKET_LEVEL2;
    } else if (OI.gamepad.getRawButton(OI.SCORE_ROCKET_HIGH_BUTTON)) {
      height = RobotMap.ROCKET_LEVEL3;
    } else if (OI.gamepad.getRawButton(OI.RETURN_BUTTON)) {
      height = new int[] { 0, 0 };
    }
    double power = pid.compute(Robot.lift.getPosition());
    if ((power > 0 && Robot.lift.isAtTop()) || (power < 0 && Robot.lift.isAtBottom())) {
      Robot.lift.stop();
      if (Robot.lift.isAtBottom()) {
        Robot.lift.setSensor(RobotMap.liftMin);
      }
      if (Robot.lift.isAtTop()) {
        Robot.lift.setSensor(RobotMap.liftMax);
      }
    } else {
      Robot.lift.set(power);
    }
    if (OI.joystick_right.getRawButton(OI.LIFT_TRIGGER_BUTTON)) {
      int c = RobotMap.HATCH;
      if (RobotMap.cargoDetectionSwitch.get()) {
        c = RobotMap.CARGO;
      }
      pid.setSetpoint(-(height[c] + RobotMap.liftAdjustment));
    } else {
      // pid.setSetpoint(0);
      Robot.lift.stop();
    }
    RobotMap.liftOnTarget = pid.onTarget();
    int c = RobotMap.HATCH;
    if (RobotMap.cargoDetectionSwitch.get()) {
      c = RobotMap.CARGO;
    }
    RobotMap.liftTargetHeight = height[c];
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
