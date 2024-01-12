package com.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name") // name을 session에 넣음 이 값을 사용하려는 모든 controller에 넣어줘야함
public class TodoControllerJpa {

	public TodoControllerJpa(TodoService todoService, TodoRepository todoRepository) {
		super();
		this.todoService = todoService;
		this.todoRepository = todoRepository;
	}

	private TodoService todoService;

	private TodoRepository todoRepository;

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		// model.get이 session에서 받아오는 name?
		String username = getLoggedInUsername(model);
		List<Todo> todos = todoRepository.findByUsername(username);
		model.addAttribute("todos", todos);
		return "listTodos";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = getLoggedInUsername(model);
		// 단방향 바인딩 컨트롤러에서 양식에 표시되는 값으로 바인딩 -> 이걸 내거로 바꿔서 submit 하면 todo에 바인딩 (양방향 바인딩)
		Todo todo = new Todo(0, username, "", LocalDate.now(), false);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	// model이 먼저와야됨 bean에 바인딩(커맨드 빈/ 양식 보조 객체)
	// @valid 는 todo에서 한 size 검증을 트리거하기 위해 추가하는 어ㄴ테이션
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "todo";
		}
		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
//		todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
		return "redirect:list-todos";
	}

	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoRepository.findById(id).get();
		model.addAttribute("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	// model이 먼저와야됨 bean에 바인딩(커맨드 빈/ 양식 보조 객체)
	// @valid 는 todo에서 한 size 검증을 트리거하기 위해 추가하는 어ㄴ테이션
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "todo";
		}

		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
//		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}

	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

}
