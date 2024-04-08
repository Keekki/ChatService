package com.chatservice.springboot.Repository;

import com.chatservice.springboot.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
