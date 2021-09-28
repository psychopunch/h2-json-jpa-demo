package io.github.psychopunch.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ConversionTest {

    @Autowired
    private RecordRepository repository;

    @Test
    void jsonConversion() {
        //given:
        var personalInfo = new PersonalInfo("John Doe", 20);
        var record = new Record(personalInfo);

        //when:
        repository.save(record);

        //then:
        assertThat(repository.findAll()).hasSize(1);
    }

}
