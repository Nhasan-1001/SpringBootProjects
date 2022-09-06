package com.example.EmployeeManagementSystem.Controller;
import com.example.EmployeeManagementSystem.Model.Assets;
import com.example.EmployeeManagementSystem.Service.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetsController {
    @Autowired
    AssetsService assetsService;
    @PostMapping
    public ResponseEntity<String>addAssets(@RequestBody @Valid Assets assets) {
    assetsService.addAssets(assets);
    return new ResponseEntity<>("Assets details creation successful!", HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Assets>>getAssets() {
        try {
            List<Assets>assets = assetsService.getAll();
            return new ResponseEntity<>(assets, HttpStatus.OK);
        }
        catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteAssets(@PathVariable ("id") int id) {
        try {
            assetsService.deleteAssets(id);
            return new ResponseEntity<>("Asset deletion successful!", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Id not found!",HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping
    public ResponseEntity<String>updateAssets(@RequestBody @Valid Assets assets) {
        try {
                assetsService.updateAssets(assets);
                return new ResponseEntity<>("Asset details updated successfully!", HttpStatus.CREATED);
            }
        catch (NullPointerException e) {
            return new ResponseEntity<>("Id not not found",HttpStatus.NOT_FOUND);
        }
    }
}
