package app.services.impl;

import app.constants.ResultMessages;
import app.dto.branches.BranchImportJsonDto;
import app.entities.Branch;
import app.repositories.BranchRepository;
import app.repositories.TownRepository;
import app.services.api.BranchService;
import app.utils.DTOConverter;
import app.utils.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private TownRepository townRepository;

    @Override
    public String add(BranchImportJsonDto branchDto) {
        Branch branch = DTOConverter.convert(branchDto, Branch.class);
        branch.setTown(this.townRepository.findByName(branchDto.getTown()));

        String result;
        if (DataValidator.isValid(branch)) {
            this.branchRepository.save(branch);
            result = String.format(ResultMessages.SUCCESSFUL, branch.getClass().getSimpleName(), branch);
        } else {
            result = ResultMessages.ERROR;
        }

        return result;
    }

    @Override
    public Branch findByName(String name) {
        return this.branchRepository.findByName(name);
    }

    @Override
    public List<Branch> findByTownName(String townName) {
        return this.branchRepository.findByTownName(townName);
    }

    @Override
    public List<Branch> findAll() {
        return this.branchRepository.findAll();
    }
}
