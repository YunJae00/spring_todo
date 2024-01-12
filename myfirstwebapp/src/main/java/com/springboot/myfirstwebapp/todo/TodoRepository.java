package com.springboot.myfirstwebapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// 첫번째 pram 이 관리하는 bean 두번쨰가 id field의 type 여기서는 int 
public interface TodoRepository extends JpaRepository<Todo, Integer> {

	public List<Todo> findByUsername(String username);
}
