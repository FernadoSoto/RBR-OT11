package pe.edu.vg.app.controller;

import pe.edu.vg.app.model.TableCL;
import pe.edu.vg.app.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
public class TableController {

    @Autowired
    private TableService tableService;

    @GetMapping
    public List<TableCL> getAllTables() {
        return tableService.getAllTables();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TableCL> getTableById(@PathVariable Long id) {
        return ResponseEntity.ok(tableService.getTableById(id));
    }

    @PostMapping
    public ResponseEntity<TableCL> createTable(@RequestBody TableCL table) {
    	TableCL createdTable = tableService.createTable(table);
        return ResponseEntity.ok(createdTable);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TableCL> updateTable(@PathVariable Long id, @RequestBody TableCL tableDetails) {
    	TableCL updatedTable = tableService.updateTable(id, tableDetails);
        return ResponseEntity.ok(updatedTable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable Long id) {
        tableService.deleteTable(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<TableCL> changeStatus(@PathVariable Long id, @RequestBody String status) {
    	TableCL updatedTable = tableService.changeStatus(id, status);
        return ResponseEntity.ok(updatedTable);
    }
}