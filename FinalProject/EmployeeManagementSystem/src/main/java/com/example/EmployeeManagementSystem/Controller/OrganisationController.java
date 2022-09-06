package com.example.EmployeeManagementSystem.Controller;
import com.example.EmployeeManagementSystem.Model.Assets;
import com.example.EmployeeManagementSystem.Model.Employee;
import com.example.EmployeeManagementSystem.Model.Organisation;
import com.example.EmployeeManagementSystem.Reposetory.AssetsRepo;
import com.example.EmployeeManagementSystem.Reposetory.EmployeeRepo;
import com.example.EmployeeManagementSystem.Service.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/organisation")
public class OrganisationController {
    @Autowired
    OrganisationService organisationService;
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    AssetsRepo assetsRepo;

    @PostMapping
    public ResponseEntity<String>addOrganisation(@RequestBody @Valid Organisation organisation)
    {
        organisationService.addOrganisation(organisation);
        return new ResponseEntity<>("Organisation details creation successful!",HttpStatus.CREATED);
    }

    @DeleteMapping("/{org_id}")
    public ResponseEntity<String>deleteOrganisation(@PathVariable int org_id)
    {
        try {
            organisationService.deleteOrganisation(org_id);
            List<Employee> emp=employeeRepo.deleteData(org_id);
            for(Employee e:emp)
            {
                employeeRepo.deleteById(e.getId());
            }
            List<Assets>ast=assetsRepo.findAllByOrgid(org_id);
            for(Assets assets:ast){
                assetsRepo.deleteById(assets.getId());
            }
            return new ResponseEntity<>("Organisation deleted successfully!",HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("Details not found!",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Organisation>>getAll()
    {
        try {
            return new ResponseEntity<List<Organisation>>(organisationService.getAllOrganisation(),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{org_id}")
    public ResponseEntity<String>updateOrganisation(@PathVariable int org_id,@RequestBody @Valid Organisation organisation)
    {
        try {
            organisationService.updateOrganisation(org_id,organisation);
            return new ResponseEntity<>("Organisation details updated successfully!",HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("Details not found!",HttpStatus.NOT_FOUND);
        }
    }
}
