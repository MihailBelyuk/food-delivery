package com.solvd.belyuk.fooddelivery.entity.vehicle;

import com.solvd.belyuk.fooddelivery.exception.TooBigValueException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Car extends Vehicle implements IDoService {

    private static final Logger LOGGER = LogManager.getLogger(Car.class);

    private static final int OIL_SERVICE_PERIOD = 15_000;
    private static final int AIR_FILTER_SERVICE_PERIOD = 30_000;

    private int horsePower;
    private int fuelConsumption;
    private int odometerCurrent;
    private int nextOilService;
    private boolean oilChanged;
    private int nextAirFilterService;
    private boolean airFilterChanged;

    public Car(String brand, int nextOilService) {
        super(brand);
        this.nextOilService = nextOilService;
    }

    @Override
    public void changeOil() throws TooBigValueException {
        if (oilChanged) {
            setNextOilService(this.nextOilService + OIL_SERVICE_PERIOD);
        }
        double index = getOdometerCurrent() / (double) getNextOilService();
        if (getOdometerCurrent() >= 1000000) {
            LOGGER.error("Threw 'TooBigValueException'.");
            throw new TooBigValueException("Odometer value is out of permitted bounds.");
        }
        if (index <= 0.93) {
            LOGGER.info("Oil change is not needed.");
        } else if (index > 0.93 && index <= 1.03) {
            LOGGER.info("Oil needs to be changed.");

        } else {
            LOGGER.info("Change oil as soon as possible.");
        }
    }

    @Override
    public void changeAirFilter() {
        if (airFilterChanged) {
            setNextOilService(this.nextAirFilterService + AIR_FILTER_SERVICE_PERIOD);
        }
        double index = getOdometerCurrent() / (double) getNextAirFilterService();
        if (index <= 0.93) {
            LOGGER.info("Air filter change is not needed.");
        } else if (index > 0.93 && index <= 1.03) {
            LOGGER.info("Air filter needs to be changed.");
        } else {
            LOGGER.info("Change air filter as soon as possible.");
        }
    }

    public int getNextAirFilterService() {
        return nextAirFilterService;
    }

    public void setNextAirFilterService(int nextAirFilterService) {
        this.nextAirFilterService = nextAirFilterService;
    }

    public boolean isAirFilterChanged() {
        return airFilterChanged;
    }

    public void setAirFilterChanged(boolean airFilterChanged) {
        this.airFilterChanged = airFilterChanged;
    }

    public boolean isOilChanged() {
        return oilChanged;
    }

    public void setOilChanged(boolean oilChanged) {
        this.oilChanged = oilChanged;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getOdometerCurrent() {
        return odometerCurrent;
    }

    public void setOdometerCurrent(int odometerCurrent) {
        this.odometerCurrent = odometerCurrent;
    }

    public int getNextOilService() {
        return nextOilService;
    }

    public void setNextOilService(int nextOilService) {
        this.nextOilService = nextOilService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Car car = (Car) o;

        if (horsePower != car.horsePower) return false;
        if (fuelConsumption != car.fuelConsumption) return false;
        if (odometerCurrent != car.odometerCurrent) return false;
        if (nextOilService != car.nextOilService) return false;
        if (oilChanged != car.oilChanged) return false;
        if (nextAirFilterService != car.nextAirFilterService) return false;
        return airFilterChanged == car.airFilterChanged;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + horsePower;
        result = 31 * result + fuelConsumption;
        result = 31 * result + odometerCurrent;
        result = 31 * result + nextOilService;
        result = 31 * result + (oilChanged ? 1 : 0);
        result = 31 * result + nextAirFilterService;
        result = 31 * result + (airFilterChanged ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("horsePower=").append(horsePower);
        sb.append(", fuelConsumption=").append(fuelConsumption);
        sb.append(", odometerCurrent=").append(odometerCurrent);
        sb.append(", nextOilService=").append(nextOilService);
        sb.append(", oilChanged=").append(oilChanged);
        sb.append(", nextAirFilterService=").append(nextAirFilterService);
        sb.append(", airFilterChanged=").append(airFilterChanged);
        sb.append('}');
        return sb.toString();
    }
}
