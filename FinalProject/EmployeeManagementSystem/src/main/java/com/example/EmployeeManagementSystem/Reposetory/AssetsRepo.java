package com.example.EmployeeManagementSystem.Reposetory;
import com.example.EmployeeManagementSystem.Model.Assets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AssetsRepo  extends JpaRepository<Assets,Integer> {
    Assets findById(int assets_id);

    List<Assets>findAllByOrgid(int id);
}
