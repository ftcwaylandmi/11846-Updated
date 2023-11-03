package org.firstinspires.ftc.teamcode.TeleOperated;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.MecanumSubsystem;

@TeleOp(name = "TeleOperatedMain", group = "OpMode")
public class TeleOperatedMain extends OpMode {

    MecanumSubsystem mecanumSubsystem;

    double forward = 0.00;
    double strafe = 0.00;
    double turn = 0.00;
    //        boolean peck = gamepad2.x;
//        boolean score = gamepad2.y;
//        boolean hover = gamepad2.a;
    double elevator = 0.00;
    double arm =  0.00;
    double intake = 0.00;
    boolean plane = false;
    @Override
    public void init() {
        mecanumSubsystem = new MecanumSubsystem(hardwareMap);
        telemetry.addData("Startup", "Initializing Subsystems...");
//        telemetry.addData("Color Sensor",mecanumSubsystem.GetColor());
//        telemetry.addData("Arm Hover Pos", mecanumSubsystem.armHoverpos());
//        telemetry.addData("Ele Height Pos", mecanumSubsystem.armHeightpos());
//        telemetry.addData("Pinch Pos", mecanumSubsystem.pinchpos());
        telemetry.update();

        telemetry.addData("Startup", "Initialization Complete!");
//        telemetry.addData("Color Sensor", mecanumSubsystem.GetColor());
//        telemetry.addData("Arm Hover Pos", mecanumSubsystem.armHoverpos());
//        telemetry.addData("Ele Height Pos", mecanumSubsystem.armHeightpos());
//        telemetry.addData("Pinch Pos", mecanumSubsystem.pinchpos());
        telemetry.update();
    }

    @Override
    public void loop() {

        forward = -gamepad1.left_stick_y;
        strafe = -gamepad1.left_stick_x;
        turn = -gamepad1.right_stick_x;
//        boolean peck = gamepad2.x;
//        boolean score = gamepad2.y;
//        boolean hover = gamepad2.a;
        elevator = gamepad2.left_stick_y;
        arm = -gamepad2.right_stick_y;
        intake = gamepad2.left_trigger;
        plane = gamepad2.b;
//
        mecanumSubsystem.plane(plane);
        mecanumSubsystem.intake(intake);
        mecanumSubsystem.EleM(elevator);
        mecanumSubsystem.armM(arm);
        mecanumSubsystem.TeleOperatedDrive(forward, strafe, turn);
//        telemetry.addData("Arm Hover Pos", mecanumSubsystem.armHoverpos());
//        telemetry.addData("Ele Height Pos", mecanumSubsystem.armHeightpos());
//        telemetry.addData("Pinch Pos", mecanumSubsystem.pinchpos());
//        telemetry.update();
//        if (gamepad2.dpad_up) {
//            mecanumSubsystem.arm(7320);
//        }
//        if (gamepad2.dpad_down){
//            mecanumSubsystem.arm(-28400);
//        }
/*        if (gamepad2.a){
            mecanumSubsystem.eleMoveUp(-666);
        }
        if (gamepad2.y){
            mecanumSubsystem.eleMoveUp(-1350);
        }*/
//        if (gamepad2.dpad_up){
//            mecanumSubsystem.wristt(1,50);
//        }
//        if (gamepad2.dpad_down){
//            mecanumSubsystem.wristt(-1,50);
//        }
        if(gamepad2.right_bumper){
            mecanumSubsystem.grab();
        }
        if(gamepad2.left_bumper){
            mecanumSubsystem.release(0.5 );
        }
//        if (hover) {
//            mecanumSubsystem.armHover();
//        }
//        if(gamepad2.a) {
//            mecanumSubsystem.test();
//        }
//        if (score) {
//            mecanumSubsystem.score(1);
//        }
//
//        if (peck) {
//            mecanumSubsystem.peck(1);
//        }
        telemetry.addData("Color Sensor", mecanumSubsystem.GetColor());

        telemetry.addData("red", mecanumSubsystem.colorSensor.red());
        telemetry.addData("green", mecanumSubsystem.colorSensor.green());
        telemetry.addData("blue", mecanumSubsystem.colorSensor.blue());

        telemetry.addData("Arm Hover Pos", mecanumSubsystem.armHoverpos());
        telemetry.addData("Ele Height Pos", mecanumSubsystem.armHeightpos());
        telemetry.addData("Pinch Pos", mecanumSubsystem.pinchpos());
        telemetry.update();
    }
}


