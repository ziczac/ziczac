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

   public Todo getTodo(String userName, String id)
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
   
   public List<Todo> getTodos(String userName)
   {
      return cache.get(userName);
   }

   public void addTodo(String userName, Todo todo)
   {
      List<Todo> list = cache.get(userName);
      if (list == null)
      {
         list = new ArrayList<Todo>();
         cache.put(userName, list);
      }
      list.add(todo);
   }

   public Todo removeTodo(String userName, String id)
   {
      List<Todo> list = cache.get(userName);
      if (list != null)
      {
         Iterator<Todo> iterator = list.iterator();
         while (iterator.hasNext())
         {
            Todo todo = iterator.next();
            if (todo.id.equals(id))
            {
               list.remove(todo);
               return todo;
            }
         }
      }
      return null;
   }

   public Collection<Todo> findTodos(String userName, String shortTitle)
   {
      List<Todo> result = new ArrayList<Todo>();
      List<Todo> todos = getTodos(userName);
      Iterator<Todo> iterator = todos.iterator();
      while (iterator.hasNext())
      {
         Todo todo = iterator.next();
         if (todo.name.contains(shortTitle))
         {
            result.add(todo);
         }
      }
      
      if (result.size() > 0)
      {
         return result;
      }
      return null;
   }
}