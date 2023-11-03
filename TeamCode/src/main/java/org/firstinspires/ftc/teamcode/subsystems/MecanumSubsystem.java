package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.TeleOperated.TeleOperatedMain;


public class MecanumSubsystem {

    private DcMotor front_left = null;
    private DcMotor front_right = null;
    private DcMotor back_left = null;
    private DcMotor back_right = null;
    public RevColorSensorV3 colorSensor = null;
    public DcMotor armMotor = null;
    public Servo pinch = null;
    public DcMotor eleMotor = null;
    public DcMotor intakeMotor = null;
    public Servo planeShooter = null;
    public CRServo wrist = null;
    public Servo wristA = null;

    public MecanumSubsystem(HardwareMap hardwareMap) {
        front_left = hardwareMap.get(DcMotor.class, "front_left");
        front_right = hardwareMap.get(DcMotor.class, "front_right");
        back_left = hardwareMap.get(DcMotor.class, "back_left");
        back_right = hardwareMap.get(DcMotor.class, "back_right");
        //  camera = hardwareMap.get(ConceptTensorFlowObjectDetection.class, "camera");
        colorSensor = hardwareMap.get(RevColorSensorV3.class, "cs");
        armMotor = hardwareMap.get(DcMotor.class,"armM");
        pinch =  hardwareMap.get(Servo.class,"pinch");
        eleMotor = hardwareMap.get(DcMotor.class,"eleMotor");
        intakeMotor = hardwareMap.get(DcMotor.class,"intakeMotor");
        planeShooter = hardwareMap.get(Servo.class,"plane");
        wrist = hardwareMap.get(CRServo.class,"wrist");
        wristA = hardwareMap.get(Servo.class,"wristA");

        front_left.setPower(0);
        front_right.setPower(0);
        back_left.setPower(0);
        back_right.setPower(0);
        armMotor.setPower(0);
        eleMotor.setPower(0);
        intakeMotor.setPower(0);
        wrist.setPower(0);
        planeShooter.setPosition(0);
// eleMotor auton = -3500
        //eleMotor.setTargetPosition(-10700);
        //armMotor.setTargetPosition(0);

        front_left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        front_right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        back_left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        back_right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    //    armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
  //      eleMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        eleMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        intakeMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        eleMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    private double converttoec(double inches) {
        double convert = 537.7 / (Math.PI * 3.77953);
        return convert;
    }

    public void AutonDrive(double inches) {
        front_left.setTargetPosition((int) converttoec(3.77953));
    }

    public void AutonToPosition(double x, double y, double z, double distance) {

    }

    private void wait(double time) {
        ElapsedTime elapsedTime = new ElapsedTime();
        elapsedTime.reset();
        while (elapsedTime.milliseconds() < time) {

        }
    }

    public void TeleOperatedDrive(double forward, double strafe, double turn) {

        double[] speeds = {
                (forward + strafe + turn),
                (forward - strafe - turn),
                (forward - strafe + turn),
                (forward + strafe - turn)
        };

        double max = Math.abs(speeds[0]);
        for (int i = 0; i < speeds.length; i++) {
            if (max < Math.abs(speeds[i])) max = Math.abs(speeds[i]);
        }

        if (max > 1) {
            for (int i = 0; i < speeds.length; i++) speeds[i] /= max;
        }

        front_left.setPower(speeds[0]);
        front_right.setPower(-1 * speeds[1]);
        back_left.setPower(speeds[2]);
        back_right.setPower(-1 * speeds[3]);
    }

    public void Forward(double power, double inches) {
        TeleOperatedDrive(power, 0, 0);
        converttoec(inches);
        TeleOperatedDrive(0, 0, 0);
    }

    public void Turn(double power, double inches) {
        TeleOperatedDrive(0, 0, power);
        converttoec(inches);
        TeleOperatedDrive(0, 0, 0);
    }

    public void Strafe(double power, double inches) {
        TeleOperatedDrive(0, power, 0);
        converttoec(inches);
        TeleOperatedDrive(0, 0, 0);
    }

    public void DiagLeft(double power, double inches) {
        TeleOperatedDrive(-power, power, 0);
        converttoec(inches);
        TeleOperatedDrive(0, 0, 0);
    }

    public void DiagRight(double power, double inches) {
        TeleOperatedDrive(-power, -power, 0);
       converttoec(inches);
        TeleOperatedDrive(0, 0, 0);
    }

    public void plane(boolean plane){
        planeShooter.setPosition(1);
    }

    public void eleMoveUp(int position){
        eleMotor.setPower(.5);
        eleMotor.setTargetPosition(position);
    }


    public void grab(){
        pinch.setPosition(0.54);
    }

    public void release(double time){
        pinch.setPosition(0.40);
        wait(time = 100);
        pinch.setPosition(0.54);
    }

//    public void arm(int position){
//        armMotor.setPower(.5);
//        armMotor.setTargetPosition(position);
//    }

    public void armM(double power){
//        if ((armMotor.getCurrentPosition() == 100000 ) && (power > 0)){
//            armMotor.setPower(0);
//        } else if ((armMotor.getCurrentPosition() == -28400) && (power < 0)){
//            armMotor.setPower(0);
//        } else {
            armMotor.setPower(power * 0.5);
        }
//    }

    public void EleM(double power) {
//        if ((eleMotor.getCurrentPosition() == -1350) && (power > 0)){
//            eleMotor.setPower(0);
//        } else if ((eleMotor.getCurrentPosition() == -666) && (power < 0)){
//            eleMotor.setPower(0);
//        } else {
            eleMotor.setPower(power * 0.5);
        }
//    }

    public void intake(double power){
        intakeMotor.setPower(power);
    }//works

    public double armHoverpos(){
        return armMotor.getCurrentPosition();
    }

    public void wristta(){
        wristA.setPosition(0);
    }

    public void wristt(double power, double time){
        wrist.setPower(power);
        wait(time = 50);
        wrist.setPower(0);
    }

    public double armHeightpos(){
        return eleMotor.getCurrentPosition();
    }

    public double pinchpos(){
        return pinch.getPosition();
    }//works

//    public void armHover() {
//        armMotor.setPower(0.8);
//        eleMotor.setPower(0.8);
//        wristta();
//        armMotor.setTargetPosition(6466);
//        while (armMotor.isBusy()) {
//            eleMotor.setTargetPosition(1250);
//        }
//    }

    private void wait(int sleeptime) {
        ElapsedTime timer = new ElapsedTime();
        timer.reset();
        while (timer.milliseconds() < sleeptime) {

        }
    }

//    public void test() {
//        armMotor.setPower(1);
//        eleMotor.setPower(1);
//
//        armMotor.setTargetPosition(6466);
//        wait(1000);
//        eleMotor.setTargetPosition(1250);
//
//    }1250

//    public void peck(double time) {
//       armHover();
//       pinch.setPosition(.40);
//       wait(time);
//       armMotor.setTargetPosition(1918);
//       wait(time);
//       pinch.setPosition(0.53);
//       wait(time);
//       armHover();
//    }

//    public void score(double time) {
//      armMotor.setTargetPosition(18190);
//      while (armMotor.isBusy()){
//          wristA.setPosition(1);
//      }
//            armMotor.setPower(0);
//            wait(time);
//            pinch.setPosition(.40);
//            wait(time);
//            pinch.setPosition(.54);
//            wait(time);
//            pinch.setPosition(.40);
//            wait(time);
//            armHover();
//        }

//    public void autoplace(double time){
//        armMotor.setTargetPosition(8781);
//        wait(time);
//        eleMotor.setTargetPosition(1250);
//        wait(time);
//        eleMotor.setTargetPosition(-3500);
//        wait(time);
//        pinch.setPosition(.1);
//        eleMotor.setTargetPosition(1250);
//        }

    public int ReturnColor() {
        return colorSensor.argb();

    }

    public int get() {
        return colorSensor.red();
    }

    public int GetColor(){
        int r = colorSensor.red();
        int g = colorSensor.green();
        int b = colorSensor.blue();

        if(r >= g && r >= b){
            // Red
            return 2;
        } else if(g >= b && g >= r){
            //Green
            return 1;
        } else if(b > r && b > g){
            //blue
            return 3;
        }
        return 1;
    }


}