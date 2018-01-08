package com.sachin4java.Todo.bo;

import java.util.List;

import com.sachin4java.Todo.controller.model.TodoItem;

public interface TodoBO {

	List<TodoItem> getTodoItems();

	TodoItem addTodoItem(TodoItem todoItem);

	void deleteTodoItem(Integer id);

	List<TodoItem> getTodoItems(boolean complete);

}
