package com.example.demo.repository.primary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.primary.PrimaryLoginLog;

public interface PrimaryLoginLogRepository extends JpaRepository<PrimaryLoginLog, Integer> {

}
