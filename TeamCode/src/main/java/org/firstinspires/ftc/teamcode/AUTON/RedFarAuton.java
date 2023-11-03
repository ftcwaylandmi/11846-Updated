package org.firstinspires.ftc.teamcode.AUTON;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.MecanumSubsystem;

@Autonomous(name = "RedFar", group = "11846")
public class RedFarAuton extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        MecanumSubsystem mecanumSubsystem = new MecanumSubsystem(hardwareMap);
        telemetry.addData("Camera","Off");
        telemetry.update();
        waitForStart();
        telemetry.addData("Camera","On");
        telemetry.update();
        mecanumSubsystem.Forward(1, 500);
        mecanumSubsystem.GetColor();
        // Scan for Center is checked here
        if (mecanumSubsystem.GetColor() == 2){

        }else if (mecanumSubsystem.GetColor() == 1) {
            mecanumSubsystem.Forward(-1, 12);
            mecanumSubsystem.Turn(-0.5, 3);
            mecanumSubsystem.GetColor();
            if (mecanumSubsystem.GetColor() == 2){
                mecanumSubsystem.Turn(0.5, 3);
                mecanumSubsystem.Forward(1, 2000);
                mecanumSubsystem.Turn(0.5,500);
                mecanumSubsystem.Forward(1,2);
                mecanumSubsystem.Strafe(1, 750);
                mecanumSubsystem.Forward(0.5, 1000);

                // Pixel should now be placed, you can actually just sit in this spot
                // and it will count for being parked in the station; 2 front wheels must be in station for points
                // If you need to move (for tm8), below is for left side parking

                mecanumSubsystem.Strafe(-1, 400);
                mecanumSubsystem.Forward(0.5, 500);

                // If you need to move (for tm8), below is for right side parking

                mecanumSubsystem.Strafe(1, 500);
                mecanumSubsystem.Forward(0.5, 500);

                // RedFar if Left is scanned: process for going through ALLEY (column of tiles touching wall) is below

                mecanumSubsystem.Forward(-1, 400);
                mecanumSubsystem.Turn(1, 500);
                mecanumSubsystem.Forward(1, 2000);
                mecanumSubsystem.Strafe(-1, 500);
                mecanumSubsystem.Forward(0.5, 1000);

                // (copy and pasted from above) Pixel should now be placed, you can actually just sit in this spot
                // and it will count for being parked in the station; 2 front wheels must be in station for points
                // If you need to move (for tm8), below is for left side parking

                mecanumSubsystem.Strafe(-1, 400);
                mecanumSubsystem.Forward(0.5, 500);

            }
        }

        // Scan for Left is checked here
        // If Left and Center are not scanned, run process for Right
        mecanumSubsystem.Turn(0.5, 500);

        // !!!!! RFL -------------------------------------------------------------
        // RedFar if Left is scanned: process for going under STAGE is below

        mecanumSubsystem.Forward(1, 500);
        mecanumSubsystem.Turn(0.5, 1000);
        mecanumSubsystem.Forward(1, 2000);
        mecanumSubsystem.Strafe(1, 750);
        mecanumSubsystem.Forward(0.5, 1000);

        // Pixel should now be placed, you can actually just sit in this spot
        // and it will count for being parked in the station; 2 front wheels must be in station for points
        // If you need to move (for tm8), below is for left side parking

        mecanumSubsystem.Strafe(-1, 400);
        mecanumSubsystem.Forward(0.5, 500);

        // If you need to move (for tm8), below is for right side parking

        mecanumSubsystem.Strafe(1, 500);
        mecanumSubsystem.Forward(0.5, 500);

        // RedFar if Left is scanned: process for going through ALLEY (column of tiles touching wall) is below

        mecanumSubsystem.Forward(-1, 400);
        mecanumSubsystem.Turn(1, 500);
        mecanumSubsystem.Forward(1, 2000);
        mecanumSubsystem.Strafe(-1, 500);
        mecanumSubsystem.Forward(0.5, 1000);

        // (copy and pasted from above) Pixel should now be placed, you can actually just sit in this spot
        // and it will count for being parked in the station; 2 front wheels must be in station for points
        // If you need to move (for tm8), below is for left side parking

        mecanumSubsystem.Strafe(-1, 400);
        mecanumSubsystem.Forward(0.5, 500);

        // If you need to move (for tm8), below is for right side parking

        mecanumSubsystem.Strafe(1, 500);
        mecanumSubsystem.Forward(0.5, 500);

        // !!!!! RFC -------------------------------------------------------------
        // RedFar if Center is scanned: process for going under STAGE is below

        mecanumSubsystem.Strafe(-1, 400);
        mecanumSubsystem.Forward(1, 500);
        mecanumSubsystem.Turn(1,500);
        mecanumSubsystem.Forward(1, 1900);
        mecanumSubsystem.Strafe(1, 750);
        mecanumSubsystem.Forward(0.5, 1000);

        // Pixel should now be placed, you can actually just sit in this spot
        // and it will count for being parked in the station; 2 front wheels must be in station for points
        // If you need to move (for tm8), below is for left side parking

        mecanumSubsystem.Strafe(-1, 400);
        mecanumSubsystem.Forward(0.5, 500);

        // If you need to move (for tm8), below is for right side parking

        mecanumSubsystem.Strafe(1, 500);
        mecanumSubsystem.Forward(0.5, 500);

        // RedFar if Center is scanned: process for going through ALLEY (column of tiles touching wall) is below

        mecanumSubsystem.Forward(-1,400);
        mecanumSubsystem.Turn(1, 500);
        mecanumSubsystem.Forward(1,2000);
        mecanumSubsystem.Strafe(-1,500);
        mecanumSubsystem.Forward(0.5, 1000);

        // (copy and pasted from above) Pixel should now be placed, you can actually just sit in this spot
        // and it will count for being parked in the station; 2 front wheels must be in station for points
        // If you need to move (for tm8), below is for left side parking

        mecanumSubsystem.Strafe(-1, 400);
        mecanumSubsystem.Forward(0.5, 500);

        // If you need to move (for tm8), below is for right side parking

        mecanumSubsystem.Strafe(1, 500);
        mecanumSubsystem.Forward(0.5, 500);

        // !!!!! RFR -------------------------------------------------------------
        // RedFar if Left and Center are not scanned, run right: process for going under STAGE is below

        mecanumSubsystem.Forward(1, 500);
        mecanumSubsystem.Turn(0.5, 1000);
        mecanumSubsystem.Forward(1, 2000);
        mecanumSubsystem.Strafe(1, 750);
        mecanumSubsystem.Forward(0.5, 1000);

        // Pixel should now be placed, you can actually just sit in this spot
        // and it will count for being parked in the station; 2 front wheels must be in station for points
        // If you need to move (for tm8), below is for left side parking

        mecanumSubsystem.Strafe(-1, 400);
        mecanumSubsystem.Forward(0.5, 500);

        // If you need to move (for tm8), below is for right side parking

        mecanumSubsystem.Strafe(1, 500);
        mecanumSubsystem.Forward(0.5, 500);

        // RedFar if Left and center ane not scanned, run right: process for going through ALLEY (column of tiles touching wall) is below

        mecanumSubsystem.Forward(-1, 400);
        mecanumSubsystem.Turn(1, 500);
        mecanumSubsystem.Forward(1, 2000);
        mecanumSubsystem.Strafe(-1, 500);
        mecanumSubsystem.Forward(0.5, 1000);

        // (copy and pasted from above) Pixel should now be placed, you can actually just sit in this spot
        // and it will count for being parked in the station; 2 front wheels must be in station for points
        // If you need to move (for tm8), below is for left side parking

        mecanumSubsystem.Strafe(-1, 400);
        mecanumSubsystem.Forward(0.5, 500);

        // If you need to move (for tm8), below is for right side parking

        mecanumSubsystem.Strafe(1, 500);
        mecanumSubsystem.Forward(0.5, 500);

    }
}
