package com.example.ktpapi.repository;

import com.example.ktpapi.entity.Ktp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KtpRepository extends JpaRepository<Ktp,Integer> {

}