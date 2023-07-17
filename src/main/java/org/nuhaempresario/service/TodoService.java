package org.nuhaempresario.service;

import org.nuhaempresario.model.Todo;
import org.nuhaempresario.model.dao.TodoDao;
import org.nuhaempresario.utils.exception.BadRequestException;
import org.nuhaempresario.utils.exception.NotFoundException;
import org.nuhaempresario.utils.exception.ServerErrorException;

import java.util.List;

public class TodoService {
    private final TodoDao repository;
    private final static String NotFoundMessage = "No se ha encontrado la tarea con la id indicada";
    public TodoService() {
        repository = new TodoDao();
    }
    public Todo create(Todo t) throws RuntimeException {
        try {
            Todo todo = repository.create(t);
            if (todo == null) {
                throw new BadRequestException();
            }
            return todo;
        }catch (Exception e){
            throw new ServerErrorException(e.getMessage());
        }
    }

    public Todo findOneById(long id) throws RuntimeException {
        Todo todo = repository.findOneById(id);
        if (todo == null) {
            throw new NotFoundException(NotFoundMessage);
        }
        return todo;
    }
    public List<Todo> findAll() throws RuntimeException {
        List<Todo> todos = repository.findAll();
        if(todos == null){
            throw new ServerErrorException();
        }
        return todos;
    }
    public void remove(long id) throws RuntimeException{
        Todo delete = findOneById(id);
        repository.remove(delete.getId());
    }
    public Todo update(long id, Todo todo) throws RuntimeException{
        Todo update = repository.update(id,todo);
        if (update == null) {
            throw new NotFoundException();
        }
        return update;
    }
}
