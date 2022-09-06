package com.example.EmployeeManagementSystem.Service;
import com.example.EmployeeManagementSystem.Model.Assets;
import java.util.List;

public interface AssetsInterface {
void addAssets(Assets assets);

List<Assets>getAll();

    void deleteAssets(int id);

    void updateAssets(Assets assets);
}
