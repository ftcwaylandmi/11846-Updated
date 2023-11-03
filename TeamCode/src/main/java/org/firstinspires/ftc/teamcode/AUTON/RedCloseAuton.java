package org.firstinspires.ftc.teamcode.AUTON;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.MecanumSubsystem;

@Autonomous(name = "RedClose", group = "11846")
public class RedCloseAuton extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        MecanumSubsystem mecanumSubsystem = new MecanumSubsystem(hardwareMap);
        telemetry.addData("Camera", "Off");
        telemetry.update();
        waitForStart();
        telemetry.addData("Camera", "On");
        telemetry.update();
        mecanumSubsystem.Forward(1, 500);
        // Scan for Center is checked here
        mecanumSubsystem.Forward(-1, 200);
        mecanumSubsystem.Turn(-0.5, 500);
        // Scan for Left is checked here
        // If Left and Center are not scanned, run process for Right
        mecanumSubsystem.Turn(0.5, 500);
        mecanumSubsystem.Turn(1,500);
        mecanumSubsystem.Forward(0.5,1000);

    }
}