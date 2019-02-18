package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.*;
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.HatchClamp;
import frc.robot.subsystems.Climber;

public class Robot extends TimedRobot {

  public static DriveSystem driveSystem;
  public static Climber climber;
  public static Intake intake;
  public static HatchClamp hatchClamp;
  public static Lift lift;
  public static OI oi;

  @Override
  public void robotInit() {
    System.out.println("# STARTING ROBOT");
    driveSystem = new DriveSystem();
    climber = new Climber();
    intake = new Intake();
    lift = new Lift();
    oi = new OI();
    RobotMap.imu.calibrate();
    initDashboard();
    System.out.println("Initalization Complete");
    System.out.println("ROBOT IS GO FOR DEEP SPACE MISSION");
    System.out.println("FTL Burn Initiated...");
    System.out.println("May the points be with you!");
  }

  @Override
  public void robotPeriodic() {
    updateDashboard();
  }

  @Override
  public void disabledInit() {
    System.out.println("# DISABLED");
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    System.out.println("# AUTONOMOUS");
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    System.out.println("# TELEOP");
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }

  public void initDashboard() {
    SmartDashboard.putNumber("Lift Position", lift.getPosition());
    SmartDashboard.putBoolean("Lift Top Limit", lift.isAtTop());
    SmartDashboard.putBoolean("Lift Bottom Limit", lift.isAtBottom());
    SmartDashboard.putNumber("Target Height", 0);
    SmartDashboard.putNumber("Lift Adjustment", 0);
  }

  public void updateDashboard() {
    SmartDashboard.putNumber("Lift Position", lift.getPosition());
    SmartDashboard.putBoolean("Lift Top Limit", lift.isAtTop());
    SmartDashboard.putBoolean("Lift Bottom Limit", lift.isAtBottom());
    SmartDashboard.putNumber("Target Height", RobotMap.liftTargetHeight);
    SmartDashboard.putNumber("Lift Adjustment", RobotMap.liftAdjustment);
  }

}
