package iu.edu.lukemeng.c322spring2024homework2.repository;

import java.util.ArrayList;
import java.util.List;

import iu.edu.lukemeng.c322spring2024homework2.model.Guitar;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class InventoryRepositoryTest {

    @Test
    void addGuitar() throws IOException {

        // Test 1
        InventoryRepository inventoryRepository = new InventoryRepository();
        inventoryRepository.addGuitar(new Guitar("101", 1200.0, "Builder1", "Model1", "Type1", "BackWood1", "TopWood1"));

        Guitar foundGuitar = inventoryRepository.getGuitar("101");
        assertNotNull(foundGuitar);
        assertTrue(foundGuitar.getSerialNumber().equals("101"));
        assertEquals(1200.0, foundGuitar.getPrice(), "The prices do not match");
        assertTrue(foundGuitar.getBuilder().equals("Builder1"), "Builders do not match");
        assertTrue(foundGuitar.getModel().equals("Model1"), "Models do not match");
        assertTrue(foundGuitar.getType().equals("Type1"), "Types do not match");
        assertTrue(foundGuitar.getBackWood().equals("BackWood1"), "Back woods do not match");
        assertTrue(foundGuitar.getTopWood().equals("TopWood1"), "Top woods do not match");

        //Test 2
        inventoryRepository.addGuitar(new Guitar("79890808", 10.0, "Builder2", "Model2", "Type2", "BackWood2", "TopWood2"));
        Guitar foundGuitar2 = inventoryRepository.getGuitar("79890808");
        assertNotNull(foundGuitar2);
        assertEquals("79890808", foundGuitar2.getSerialNumber(), "Serial numbers do not match");
        assertEquals(10.0, foundGuitar2.getPrice(), "The prices do not match");
        assertEquals("Builder2", foundGuitar2.getBuilder(), "Builders do not match");
        assertEquals("Model2", foundGuitar2.getModel(), "Models do not match");
        assertEquals("Type2", foundGuitar2.getType(), "Types do not match");
        assertEquals("BackWood2", foundGuitar2.getBackWood(), "Back woods do not match");
        assertEquals("TopWood2", foundGuitar2.getTopWood(), "Top woods do not match");

    }

    @Test
    void getGuitar() throws IOException {
        InventoryRepository inventoryRepository = new InventoryRepository();
        inventoryRepository.addGuitar(new Guitar("102", 1200.0, "Builder1", "Model1", "Type1", "BackWood1", "TopWood1"));

        Guitar foundGuitar = inventoryRepository.getGuitar("102");
        assertNotNull(foundGuitar);
        assertTrue(foundGuitar.getSerialNumber().equals("102"));
        assertEquals(1200.0, foundGuitar.getPrice(), "The prices do not match");
        assertTrue(foundGuitar.getBuilder().equals("Builder1"), "Builders do not match");
        assertTrue(foundGuitar.getModel().equals("Model1"), "Models do not match");
        assertTrue(foundGuitar.getType().equals("Type1"), "Types do not match");
        assertTrue(foundGuitar.getBackWood().equals("BackWood1"), "Back woods do not match");
        assertTrue(foundGuitar.getTopWood().equals("TopWood1"), "Top woods do not match");

    }

    @Test
    void search() throws IOException {
        InventoryRepository inventoryRepository = new InventoryRepository();
        inventoryRepository.addGuitar(new Guitar("103", 1200.0, "Builder1", "Model1", "Type1", "BackWood1", "TopWood1"));
        inventoryRepository.addGuitar(new Guitar("109", 1200.0, "Builder1", "Model2", "Type2", "BackWood1", "TopWood1"));

        List<Guitar> guitarList1 = inventoryRepository.search(new Guitar("103", 1200.0, "Builder1", "Model1", "Type1", "BackWood1", "TopWood1"));
        assertTrue(guitarList1.get(0).getSerialNumber().equals("103"));

        List<Guitar> guitarList2 = inventoryRepository.search(new Guitar(null, 1200.0, "Builder1", null, null, "BackWood1", "TopWood1"));

        // Note: if you run this more than one time this will return false
        assertEquals(guitarList2.size(), 2);
        assertTrue(guitarList1.get(0).getSerialNumber().equals("103"));
        assertTrue(guitarList1.get(1).getSerialNumber().equals("109"));

    }
}