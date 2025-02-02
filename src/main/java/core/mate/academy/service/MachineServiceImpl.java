package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.ArrayList;
import java.util.List;

/**
 * Your implementation of MachineService.
 */
public class MachineServiceImpl implements MachineService<Machine> {
    @Override
    public List<? extends Machine> getAll(Class type) {
        if (Bulldozer.class == type) {
            BulldozerProducer bulldozerProducer = new BulldozerProducer();
            return new ArrayList<>(bulldozerProducer.get());
        } else if (Excavator.class == type) {
            ExcavatorProducer excavatorProducer = new ExcavatorProducer();
            return new ArrayList<>(excavatorProducer.get());
        } else if (Truck.class == type) {
            TruckProducer truckProducer = new TruckProducer();
            return new ArrayList<>(truckProducer.get());
        }
        return new ArrayList<>();
    }

    @Override
    public void fill(List<? super Machine> machines, Machine value) {
        for (int i = 0; i < machines.size(); i++) {
            machines.set(i,value);
        }
    }

    @Override
    public void startWorking(List<? extends Machine> machines) {
        for (int i = 0; i < machines.size(); i++) {
            machines.get(i).doWork();
        }
    }
}
