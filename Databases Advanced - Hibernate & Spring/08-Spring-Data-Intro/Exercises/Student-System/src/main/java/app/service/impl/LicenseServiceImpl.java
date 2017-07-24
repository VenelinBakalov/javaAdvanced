package app.service.impl;

import app.dao.api.LicenseDao;
import app.model.License;
import app.service.api.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Venelin on 24.7.2017 г..
 */
@Service
@Transactional
public class LicenseServiceImpl implements LicenseService<License, Long> {

    @Autowired
    private LicenseDao licenseDao;

    @Override
    public License findById(Long id) {
        return licenseDao.findOne(id);
    }

    @Override
    public void remove(License object) {
        licenseDao.delete(object);
    }

    @Override
    public List<License> findAll() {
        return licenseDao.findAll();
    }

    @Override
    public void save(License object) {
        licenseDao.save(object);
    }
}
