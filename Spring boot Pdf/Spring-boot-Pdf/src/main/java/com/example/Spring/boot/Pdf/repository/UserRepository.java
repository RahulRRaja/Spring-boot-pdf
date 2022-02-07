package com.example.Spring.boot.Pdf.repository;

import com.example.Spring.boot.Pdf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
