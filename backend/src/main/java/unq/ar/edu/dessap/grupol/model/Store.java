package unq.ar.edu.dessap.grupol.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
@Table(name = "stores")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @JoinColumn(name = "sector_name")
    @Enumerated(value = EnumType.STRING)
    private Sector sector;

    @Column
    private Location location;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "rel_stores_days", joinColumns =
    @JoinColumn(name = "fk_store", nullable = false))
    @Column(name = "day")
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private List<DayOfWeek> openDays = new ArrayList<>();

    @JoinTable(
            name = "rel_stores_times",
            joinColumns = @JoinColumn(name = "fk_store"),
            inverseJoinColumns = @JoinColumn(name="fk_time")
    )
    @ManyToMany(cascade = CascadeType.ALL)
    @Builder.Default
    private List<Time> times = new ArrayList<>();

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "rel_stores_payments", joinColumns =
    @JoinColumn(name = "fk_store"))
    @Column(name = "payment")
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private List<Payment> payments = new ArrayList<>();

    @Column(nullable = false)
    private Double maxDistance;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "store")
    @Builder.Default
    @JsonIgnore
    private List<Product> products = new ArrayList<>();

    @Transient
    private List<Turn> turns;

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void addDay(DayOfWeek day) {
        this.openDays.add(day);
    }

    public void addPayments(Payment payment) {
        this.payments.add(payment);
    }

    public void addTimes(Time time) {
        this.times.add(time);
    }
}
