package org.t3.ziczac.services;

import java.util.Collection;
import java.util.List;

/**
 * @author <a href="trongtt@gmail.com">Trong Tran</a>
 * @version $Revision$
 */
public interface TodoService
{
   public Todo getTodo(String userName, String id) throws TodoException;
   
   public List<Todo> getTodos(String userName) throws TodoException;
   
   public void addTodo(String userName, Todo todo) throws TodoException;
   
   public Collection<Todo> findTodos(String userName, String shortTitle) throws TodoException;
}
