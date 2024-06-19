package pe.edu.vg.app.service;

import pe.edu.vg.app.exception.ResourceNotFoundException;
import pe.edu.vg.app.model.TableCL;
import pe.edu.vg.app.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    public List<TableCL> getAllTables() {
        return tableRepository.findAll();
    }

    public TableCL getTableById(Long id) {
        return tableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Table", "tableID", id));
    }

    public TableCL createTable(TableCL table) {
        return tableRepository.save(table);
    }

    public TableCL updateTable(Long id, TableCL tableDetails) {
        TableCL table = tableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Table", "tableID", id));

        table.setTableNumber(tableDetails.getTableNumber());
        table.setCapacity(tableDetails.getCapacity());
        table.setStatus(tableDetails.getStatus());

        return tableRepository.save(table);
    }

    public void deleteTable(Long id) {
        TableCL table = tableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Table", "tableID", id));
        tableRepository.delete(table);
    }

    public TableCL changeStatus(Long id, String status) {
        TableCL table = tableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Table", "tableID", id));
        table.setStatus(status);
        return tableRepository.save(table);
    }
}