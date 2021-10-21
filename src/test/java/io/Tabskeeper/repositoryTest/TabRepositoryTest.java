package io.Tabskeeper.repositoryTest;

import io.Tabskeeper.model.Tab;
import io.Tabskeeper.repository.TabRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


@DataJpaTest
public class TabRepositoryTest {

    @Autowired
    private TabRepository underTest;
    Tab testTab = new Tab();
    Tab testTab2 = new Tab();

    @BeforeEach
    void setUp(){
        testTab.setName("test name");
        testTab2.setName("Name2");
    }
    @Test
    void saveTab(){
        System.out.println("Running saveTab...");
        //given
        underTest.save(testTab);

        //when
        Iterable<Tab> result = underTest.findAll();

        //then
        assertEquals(1, StreamSupport.stream(result.spliterator(), false).count());
        for (Tab i: result) { assertEquals(testTab, i);
        }
    }
    @Test
    void updateTab() {
        System.out.println("Running updateTab...");
        //given
        underTest.save(testTab);
        Long id = testTab.getId();
        Tab tab = underTest.findById(id).get();

        //when
        tab.setName("New Name");
        underTest.save(tab);
        Long testId = testTab.getId();

        //then
        Tab result = underTest.findById(testId).get();
        assertEquals("New Name", result.getName());
    }

    @Test
    void deleteTab() {
        System.out.println("Running deleteTab...");
        //given
        underTest.save(testTab);
        Long testTab1Id = testTab.getId();

        underTest.save(testTab2);
        Long testTab2Id = testTab2.getId();

        //when
        Tab tab1 = underTest.findById(testTab1Id).get();
        underTest.delete(tab1);
        underTest.deleteById(testTab2Id);

        //then
        assertFalse(underTest.existsById(testTab1Id));
        assertFalse(underTest.existsById(testTab2Id));
    }
}
