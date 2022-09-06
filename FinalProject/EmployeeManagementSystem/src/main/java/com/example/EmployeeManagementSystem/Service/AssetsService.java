package com.example.EmployeeManagementSystem.Service;
import com.example.EmployeeManagementSystem.Model.Assets;
import com.example.EmployeeManagementSystem.Model.Organisation;
import com.example.EmployeeManagementSystem.Reposetory.AssetsRepo;
import com.example.EmployeeManagementSystem.Reposetory.OrganisationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AssetsService implements AssetsInterface {
    @Autowired
    AssetsRepo assetsRepo;
    @Autowired
    OrganisationRepo organisationRepo;
    @Override
    public void addAssets(Assets assets) {
        boolean found = false;
        for(Organisation o : organisationRepo.findAll()){
            if (o.getId() == assets.getOrgid()){
                found = true;
                break;
            }
        }
        if (! found){
            throw new NullPointerException("Organisation not exist");
        }
        assetsRepo.save(assets);
    }

    @Override
    public List<Assets> getAll() {
        return assetsRepo.findAll();
    }

    @Override
    public void deleteAssets(int id) {
        assetsRepo.deleteById(id);
    }

    @Override
    public void updateAssets(Assets assets) {
        boolean found = false;
        for(Organisation o : organisationRepo.findAll()){
            if (o.getId() == assets.getOrgid()){
                found = true;
                break;
            }
        }
        if (! found){
            throw new NullPointerException("Organisation not exist");
        }
        Assets assets1 = assetsRepo.findById(assets.getId());
        assets1.setAssets_type(assets.getAssets_type());
        assets1.setAssets_name(assets.getAssets_name());
        assets1.setAssets_value(assets.getAssets_value());
        assets1.setOrgid(assets1.getOrgid());
        assetsRepo.save(assets1);
    }
}
