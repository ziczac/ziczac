package org.t3.ziczac.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * A simple TODO service which uses memory for persisting
 * 
 * @author <a href="trongtt@gmail.com">Trong Tran</a>
 * @version $Revision$
 */
public class SimpleTodoService implements TodoService
{
   Map<String, List<Todo>> cache = new HashMap<String, List<Todo>>();

   public Todo getTodo(String userName, String id) throws TodoException
   {
      List<Todo> todos = getTodos(userName);
      for (Todo todo : todos)
      {
         if (todo.id.equals(id))
         {
            return todo;
         }
      }
      return null;
   }
   
   public List<Todo> getTodos(String userName) throws TodoException
   {
      return cache.get(userName);
   }

   public void addTodo(String userName, Todo todo) throws TodoException
   {
      List<Todo> list = cache.get(userName);
      if (list == null)
      {
         list = new ArrayList<Todo>();
         cache.put(userName, list);
      }
      list.add(todo);
   }

   public Collection<Todo> findTodos(String userName, String shortTitle) throws TodoException
   {
      List<Todo> todos = getTodos(userName);
      Iterator<Todo> iterator = todos.iterator();
      while (iterator.hasNext())
      {
         Todo todo = iterator.next();
         if (!todo.name.contains(shortTitle))
         {
            todos.remove(todos);
         }
      }
      return todos;
   }
}
