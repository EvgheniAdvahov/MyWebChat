package com.form.RegLogin.Data.Repository;

import com.form.RegLogin.Data.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
