package io.Tabskeeper.modelTest;

import io.Tabskeeper.model.Note;
import io.Tabskeeper.model.Tab;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TabTest {
    Tab tab = new Tab();
    @Test
    void createTab() {
        System.out.println("Running createTab...");
        // given
        String name = "Test tab";

        // when
        tab.setName(name);

        //then
        assertEquals("Test tab", tab.getName());
    }
}
