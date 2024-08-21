package com.projetowebservices.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetowebservices.course.entities.OrderItem;
import com.projetowebservices.course.entities.pk.OrderItemPK;

//não é necessário, pois já está herdando do JpaRepository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{//já está usando a entidade (user) e seu tipo (long), então esta pronto

}