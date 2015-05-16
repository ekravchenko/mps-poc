package org.testingzone.dbo.doctor;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.testingzone.dbo.base.AbstractSystemEntity;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.base.Inactivating;
import org.testingzone.dbo.business.Business;
import org.testingzone.dbo.common.Person;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "doctor")
@Getter
@Setter
public class Doctor extends AbstractSystemEntity implements Inactivating {

    private static final long serialVersionUID = -5453870138924517248L;

    @Id
    @GeneratedValue(generator = "HBGenerator")
    @GenericGenerator(name = "HBGenerator", strategy = "org.testingzone.dbo.base.IdGenerator")
    @Column(name = "Doctor_PK", unique = true, nullable = false)
    @Type(type = "org.testingzone.dbo.base.BinaryKeyType")
    private BinaryKey doctorPk;

    @Column(name = "EntityStatus_FK", nullable = false)
    private Integer entityStatus;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "Business_FK", nullable = false)
    private Business business;

    @Column(name = "Capacity_FK")
    private Integer capacity;

    @Column(name = "SpecialityCode")
    private Integer speciality;

    @Column(name = "SpecialityDescription", length = 250)
    private String specialityDescription;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "Person_FK")
    private Person person;

    @Column(name = "DoctorName", nullable = false, length = 101 /* name + " " + surname */)
    private String doctorName;

    @Column(name = "PracticeNumber", length = 20)
    private String practiceNumber;

    @Column(name = "HPCNumber", length = 50)
    private String hpcnumber;

    @Column(name = "Qualification")
    private String qualification;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor", cascade = CascadeType.ALL)
    private Set<DoctorNetwork> doctorNetworks = new HashSet<>(0);

    @Column(name = "RowVersion", nullable = false)
    private Integer rowVersion;

    @Override
    public BinaryKey getPrimaryKey() {
        return getDoctorPk();
    }
}
