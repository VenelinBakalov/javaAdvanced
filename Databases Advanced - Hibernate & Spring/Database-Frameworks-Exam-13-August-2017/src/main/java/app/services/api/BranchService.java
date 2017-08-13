package app.services.api;

import app.dto.branches.BranchImportJsonDto;
import app.entities.Branch;

import java.util.List;

public interface BranchService {

    String add(BranchImportJsonDto branchDto);
    Branch findByName(String name);
    List<Branch> findByTownName(String townName);
    List<Branch> findAll();
}
