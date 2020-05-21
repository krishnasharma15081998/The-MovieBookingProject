/**
 * 
 */
package com.capgemini.moviemgt.dao.adminrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.moviemgt.model.Admin;

/**
 * @author krishna
 *
 */
@Repository
public interface AdminDao extends JpaRepository<Admin, Integer>{

}
