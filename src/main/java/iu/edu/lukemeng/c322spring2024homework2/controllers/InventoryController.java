package iu.edu.lukemeng.c322spring2024homework2.controllers;

import iu.edu.lukemeng.c322spring2024homework2.model.Guitar;
import iu.edu.lukemeng.c322spring2024homework2.repository.InventoryRepository;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class InventoryController {

    private InventoryRepository inventoryRepository;

    public InventoryController(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }
    @GetMapping("/search")
    public List<Guitar> search(@RequestParam(required = false) String serialNumber,
                               @RequestParam(required = false) Double price,
                               @RequestParam(required = false) String builder,
                               @RequestParam(required = false) String model,
                               @RequestParam(required = false) String type,
                               @RequestParam(required = false) String backWood,
                               @RequestParam(required = false) String topWood){
        try {
            Guitar guitar = new Guitar(serialNumber, price == null ? 0 : price, builder, model, type, backWood, topWood);
            return inventoryRepository.search(guitar);
        } catch (IOException e) {
            return null;
        }
    }


    @PostMapping("/add")
    public boolean add(@RequestBody Guitar data){
        System.out.println("here");
        try{
            return inventoryRepository.addGuitar(data);
        } catch(IOException e){
            return false;
        }
    }

    @GetMapping("/find/{serialNumber}")
    public Guitar findGuitar(@PathVariable String serialNumber){
        try {
            return inventoryRepository.getGuitar(serialNumber);
        } catch (IOException e) {
            return null;
        }
    }

}
