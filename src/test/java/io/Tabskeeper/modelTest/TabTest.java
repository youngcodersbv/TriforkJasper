package io.Tabskeeper.modelTest;

import io.Tabskeeper.model.Tab;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class TabTest {

    Tab testTab = new Tab();

    @BeforeEach
    void setUp(){
        testTab.setName("test tab");
    }
    @Test
    void getTabProperties() {
        System.out.println("Running createTab...");
        // given

        // when

        //then
        assertEquals("test tab", testTab.getName());
    }
}
