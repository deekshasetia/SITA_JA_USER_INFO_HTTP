package com.SITA.springboot.JA_USER_INFO_HTTP.service;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositry extends JpaRepository<UserInfo, Long> {

}
