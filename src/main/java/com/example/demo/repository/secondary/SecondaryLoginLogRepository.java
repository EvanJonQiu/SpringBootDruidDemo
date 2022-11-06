package com.example.demo.repository.secondary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.secondary.SecondaryLoginLog;

public interface SecondaryLoginLogRepository extends JpaRepository<SecondaryLoginLog, Integer> {

}
