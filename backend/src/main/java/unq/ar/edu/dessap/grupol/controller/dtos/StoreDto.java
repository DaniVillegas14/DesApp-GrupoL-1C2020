package unq.ar.edu.dessap.grupol.controller.dtos;

import unq.ar.edu.dessap.grupol.model.*;

import java.time.DayOfWeek;
import java.util.List;

public class StoreDto {

    private String name;
    private Location location;
    private Double maxDistance;
    private List<SectorDto> sectors;
    private List<DayOfWeek> openDays;
    private List<Payment> payments;
    private List<TimeDto> times;

    public Double getMaxDistance() {
        return maxDistance;
    }

    public Location getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public List<SectorDto> getSectors() { return sectors;}

    public List<DayOfWeek> getOpenDays() { return openDays; }

    public List<TimeDto> getTimes() { return times; }

    public List<Payment> getPayments() { return payments; }

    public void setTimes(List<TimeDto> times) {
        this.times = times;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public void setOpenDays(List<DayOfWeek> openDays) {
        this.openDays = openDays;
    }

    public void setSectors(List<SectorDto> sectors) {
        this.sectors = sectors;
    }

    public void setMaxDistance(Double maxDistance) {
        this.maxDistance = maxDistance;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }
}
