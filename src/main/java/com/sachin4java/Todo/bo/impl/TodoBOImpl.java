package com.sachin4java.Todo.bo.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sachin4java.Todo.bo.TodoBO;
import com.sachin4java.Todo.controller.model.TodoItem;
import com.sachin4java.Todo.dao.TodoRepository;
import com.sachin4java.Todo.entity.TodoItemEntity;

@Component
public class TodoBOImpl implements TodoBO{
	@Autowired
	private TodoRepository todoRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<TodoItem> getTodoItems() {
		List<TodoItemEntity> list = todoRepository.findAll();
		Type type = new TypeToken<List<TodoItem>>() {}.getType();
		return modelMapper.map(list, type);
	}

	@Override
	public TodoItem addTodoItem(TodoItem todoItem) {
		return modelMapper.map(todoRepository.save(modelMapper.map(todoItem, TodoItemEntity.class)), TodoItem.class);
	}

	@Override
	public void deleteTodoItem(Integer id) {
		todoRepository.delete(id);
	}

	@Override
	public List<TodoItem> getTodoItems(boolean complete) {
		
		List<TodoItemEntity> list = todoRepository.findByComplete(complete);
		Type type = new TypeToken<List<TodoItem>>() {}.getType();
		return modelMapper.map(list, type);
	}

}
