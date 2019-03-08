package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import frclib.sensors.ADIS16448;
import frclib.vision.Camera;

public class RobotMap {

    //notes
    // vex encoder 360 counts per revolution

    // Encoder Constants
    public static final double liftEncoderScale = (0.5*Math.PI) / 360;
    public static final double climbEncoderScale = 1;



    // Lift calibration
    public static final int liftMax = 96;
    public static final int liftMin = 0;



    // Indexes
    public static final int CARGO = 0;
    public static final int HATCH = 1;
    public static final int LEVEL1 = 0;
    public static final int LEVEL2 = 1;
    public static final int LEVEL3 = 2;


    //GAME HEIGHTS IN INCHES

    // HAB
    public static final int[] HAB = { 0, 6, 19 }; // climb height for hab platforms {level 1, level 2, level 3}

    // Cargoship
    public static final int[] CARGOSHIP = { 40, 19 };// lift height of hatch placement on cargoship

    // Rocket
    public static final int[] ROCKET_LEVEL1 = { 28, 19 }; // lift height of level 1 rocket {cargo, hatch}
    public static final int[] ROCKET_LEVEL2 = { 56, 47 }; // lift height of level 2 rocket {cargo, hatch}
    public static final int[] ROCKET_LEVEL3 = { 84, 75 }; // lift height of level 3 rocket {cargo, hatch}

    // Loading Station
    public static final int[] LOADING_CARGO = { 43, 43 }; // lift height of loading station cargo
    public static final int[] LOADING_HATCH = { 19, 19 };// lift height of loading station hatch

    // Other Hights
    public static final int[] GROUND = { 0, 0 };



    // PID on target Identifiers
    public static boolean liftOnTarget = false;



    // Adjustments
    public static double liftAdjustment = 0;



    // Global lift height
    public static int liftTargetHeight = 0;



    // Sensors
    public static Camera camera;
    public static ADIS16448 imu = new ADIS16448();
    public static DigitalInput cargoDetectionSwitch = new DigitalInput(0);
}
