package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import frclib.sensors.ADIS16448;
import frclib.vision.Camera;

public class RobotMap {

    // vex encoder 360 counts per revolution

    // scaling variables
    public static double liftEncoderScale = (1.3 * Math.PI) / 360;
    public static double climbEncoderScale = 1;

    public static final int liftMax = 96;
    public static final int liftMin = 0;

    // heights of game locations to the nearest inch in inches

    public static final int CARGO = 0;
    public static final int HATCH = 1;

    public static final int LEVEL1 = 0;
    public static final int LEVEL2 = 1;
    public static final int LEVEL3 = 2;

    // HAB
    public static final int[] HAB = { 0, 6, 19 }; // climb height for level 2 hab platform
    // Cargoship
    public static final int[] CARGOSHIP = { 40, 19 };// lift height of hatch placement on cargoship
    // Rocket
    public static final int[] ROCKET_LEVEL1 = { 28, 19 }; // lift height of level 1 cargo drop on rocket
    public static final int[] ROCKET_LEVEL2 = { 56, 47 }; // lift height of level 2 cargo drop on rocket
    public static final int[] ROCKET_LEVEL3 = { 84, 75 }; // lift height of level 3 cargo drop on rocket
    // Loading Station
    public static final int[] LOADING_CARGO = { 43, 43 }; // lift height to take cargo from loading station
    public static final int[] LOADING_HATCH = { 19, 19 };
    // PID On Target Identifiers
    public static boolean liftOnTarget = false;
    public static boolean crabOnTarget = false;

    // Adjustments
    public static double liftAdjustment = 0;

    // Global lift height
    public static int liftTargetHeight = 0;

    // Sensors
    public static Camera view;
    public static Camera linefinder;
    public static ADIS16448 imu = new ADIS16448();
    public static DigitalInput cargoDetestionSwitch = new DigitalInput(0);
}
