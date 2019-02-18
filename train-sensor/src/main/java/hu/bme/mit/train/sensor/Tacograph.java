package hu.bme.mit.train.sensor;

import com.google.common.collect.HashBasedTable;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.interfaces.TrainSensor;


public class Tacograph {

    private Table adatok = HashBasedTable.create();

    public Tacograph(TrainController controller, TrainUser user) {
        adatok.put(0,0,System.currentTimeMillis());
        adatok.put(0,1,user.getJoystickPosition());
        adatok.put(0,2,controller.getReferenceSpeed());
    }

    public Table getAdatok() {
        return adatok;
    }
}