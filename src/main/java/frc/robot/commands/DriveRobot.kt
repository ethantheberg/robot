import edu.wpi.first.wpilibj.XboxController
import edu.wpi.first.wpilibj2.command.CommandBase

class DriveRobot(val drivetrain: DrivetrainSubsystem, val controller: XboxController) :
        CommandBase() {
    init {
        addRequirements(drivetrain)
        drivetrain.resetEncoders()
    }

    // Called every time the scheduler runs while the command is scheduled.
    override fun execute() {
        val left = controller.leftY/4
        val right = controller.rightY/4
        drivetrain.tankDrive(left, right)
    }

    // Called once the command ends or is interrupted.
    override fun end(interrupted: Boolean) {}

    // Returns true when the command should end.
    override fun isFinished(): Boolean {
        return false
    }
}
