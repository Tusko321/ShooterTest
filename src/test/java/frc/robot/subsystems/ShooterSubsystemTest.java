package frc.robot.subsystems;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.lang.management.ManagementFactory;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import org.junit.Before;
import org.junit.Test;

/**
 * ShooterSubsystemTest
 */
public class ShooterSubsystemTest {
    ShooterSubsystem shooter;

    @Before
    public void init() {
        shooter = new ShooterSubsystem(mock(VictorSPX.class), mock(VictorSPX.class), mock(VictorSPX.class), mock(VictorSPX.class));
    }

    @Test
    public void testGetRPM() {
        assertEquals(5098, this.shooter.getRPM(0.85), 0.001);
    }

    @Test 
    public void test() {
        System.out.println(System.getenv("path"));
    }
}