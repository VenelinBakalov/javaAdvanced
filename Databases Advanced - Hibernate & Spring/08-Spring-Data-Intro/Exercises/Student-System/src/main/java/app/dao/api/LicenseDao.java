package app.dao.api;

import app.model.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Venelin on 24.7.2017 г..
 */
@Repository
public interface LicenseDao extends JpaRepository<License, Long> {
}
