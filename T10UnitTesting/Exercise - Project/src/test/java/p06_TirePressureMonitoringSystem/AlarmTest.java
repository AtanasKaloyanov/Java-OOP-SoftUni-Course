package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AlarmTest {
    @Test
    public void testAlarmWithLowerPressure() {
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(15.3);

        Alarm alarm = new Alarm(sensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmWithHigherPressure() {
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(22.5);

        Alarm alarm = new Alarm(sensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmWithNormalPressure() {
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(19.2);

        Alarm alarm = new Alarm(sensor);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }

}