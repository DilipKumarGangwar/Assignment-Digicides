package com.dilip.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dilip.springrest.dto.Dealer;

public interface DealerDAO extends JpaRepository<Dealer, String> {


}
