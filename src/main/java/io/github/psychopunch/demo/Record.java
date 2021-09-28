package io.github.psychopunch.demo;

import javax.persistence.*;

@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "json")
    @Convert(converter = PersonalInfoConverter.class)
    private PersonalInfo personalInfo;

    public Record() {}

    public Record(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

}
