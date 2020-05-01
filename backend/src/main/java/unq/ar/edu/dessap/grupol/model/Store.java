package unq.ar.edu.dessap.grupol.model;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stores")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @JoinTable(
            name = "rel_stores_sectors",
            joinColumns = @JoinColumn(name = "store_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name="sector_id", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Sector> sectors;

    @Column(nullable = false)
    private Location location;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "rel_stores_days", joinColumns =
    @JoinColumn(name = "store_id", nullable = false))
    @Column(name = "day", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<DayOfWeek> openDays;

    @JoinTable(
            name = "rel_stores_times",
            joinColumns = @JoinColumn(name = "store_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name="time_id", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Time> times;


    @ElementCollection(fetch = FetchType.LAZY)
    @JoinTable(name = "rel_stores_payments", joinColumns =
    @JoinColumn(name = "store_id", nullable = false))
    @Column(name = "payment", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<Payment> payments;

    @Column(nullable = false)
    private Double maxDistance;

    @JoinTable(
            name = "rel_stores_products",
            joinColumns = @JoinColumn(name = "store_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name="product_id", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Product> products;

    @OneToOne
    @JoinColumn(name = "FK_SELLER", updatable = false, nullable = false)
    private Seller seller;

    public Store(){}

    public Store(String name, List<Sector> sectors,  Location location,
                 List<DayOfWeek> openDays, List<Time> times, List<Payment> payments,
                 Double maxDistance, List<Product> products, Seller seller) {
        this.name = name;
        this.sectors = sectors;
        this.location = location;
        this.openDays = openDays;
        this.times = times;
        this.payments = payments;
        this.maxDistance = maxDistance;
        this.products = products;
        this.seller = seller;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Sector> getSectors() {
        return sectors;
    }

    public void setSectors(List<Sector> sectors) {
        this.sectors = sectors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<DayOfWeek> getOpenDays() {
        return openDays;
    }

    public void setOpenDays(List<DayOfWeek> openDays) {
        this.openDays = openDays;
    }

    public List<Time> getTimes() {
        return times;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Double getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(Double maxDistance) {
        this.maxDistance = maxDistance;
    }

    public void addSector(Sector sector) {
        this.sectors.add(sector);
    }

    public void addDay(DayOfWeek day) {
        this.openDays.add(day);
    }

    public void addTimes(Time time) {
        this.times.add(time);
    }

    public void addPayments(Payment payment) {
        this.payments.add(payment);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
