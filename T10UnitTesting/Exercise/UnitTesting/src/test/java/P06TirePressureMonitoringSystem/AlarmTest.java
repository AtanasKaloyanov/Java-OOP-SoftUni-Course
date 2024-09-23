package P06TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {
    private Alarm alarm;
    private static final double thresholdMinus = 17.01;
    private static final double thresholdPlus = 20.99;
    private static final double insideTheBoundaries1 = 16.99;
    private static final double insideTheBoundaries2 = 21.01;

    @Test
    public void testAlarmOffWithLowerThreshold() {
        boolean expectedResult = getResult(thresholdMinus);
        Assert.assertFalse(expectedResult);
    }

    @Test
    public void testAlarmOffWithHigherThreshold() {
        boolean expectedResult = getResult(thresholdPlus);
        Assert.assertFalse(expectedResult);
    }

    @Test
    public void testAlarmOnWithThresholdInsideTheBoundaries() {
        boolean expectedResult = getResult(insideTheBoundaries1);
        Assert.assertTrue(expectedResult);
    }

    @Test
    public void testAlarmOnWithThresholdInsideTheBoundaries2() {
        boolean expectedResult = getResult(insideTheBoundaries2);
        Assert.assertTrue(expectedResult);
    }

    private boolean getResult(double number) {
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue())
                .thenReturn(number);
        this.alarm = new Alarm(sensor);
        this.alarm.check();
        return this.alarm.getAlarmOn();
    }
}
