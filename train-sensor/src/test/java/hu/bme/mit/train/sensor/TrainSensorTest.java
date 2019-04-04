package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorTest {

    TrainController controller;
    TrainUser user;
    TrainSensor sensor;


    @Before
    public void before() {
        controller = mock(TrainController.class);
        user = mock(TrainUser.class);
        sensor = new TrainSensorImpl(controller, user);
    }

    //1. teszt: speedlimit nagyobb-e mint 500
    @Test
    public void speedLimitAbove500Test(){
        sensor.overrideSpeedLimit(1000);
        verify(user).setAlarmState(true);
    }

    //2.teszt: speedlimit kisebb-e mint 0
    @Test
    public void speedLimitUnder0Test(){
        sensor.overrideSpeedLimit(-1000);
        verify(user).setAlarmState(true);
    }

    //3.teszt: speedlimit kisebb-e mint a jelenlegi sebesség 50%-a
    @Test
    public void speedLimitHalfSpeedTest(){
        when(controller.getReferenceSpeed()).thenReturn(150);
        sensor.overrideSpeedLimit(50);
        verify(user).setAlarmState(true);
    }

    //4.teszt: sebesség valid, setalarmstate false-e
    @Test
    public void alarmTest(){
        sensor.overrideSpeedLimit(150);
        verify(mockUser).setAlarmState(false);
    }
}
