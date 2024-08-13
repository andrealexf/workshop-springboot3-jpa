package com.projetowebservices.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetowebservices.course.entities.User;

//não é necessário, pois já está herdando do JpaRepository
public interface UserRepository extends JpaRepository<User, Long>{//já está usando a entidade (user) e seu tipo (long), então esta pronto

}