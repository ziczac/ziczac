package org.t3.ziczac.services;

import java.util.List;

import junit.framework.TestCase;


/**
 * @author <a href="trongtt@gmail.com">Trong Tran</a>
 * @version $Revision$
 */
public class TestTodoService extends TestCase
{
   private TodoService service;

   @Override
   protected void setUp() throws Exception
   {
      service = new SimpleTodoService();
      service.addTodo("foo", new Todo("foo_todo1"));
   }
   
   public void testAddingTodo() throws Exception
   {
      service.addTodo("foo", new Todo("foo_todo2"));
      
      assertNotNull(service.getTodo("foo", "foo_todo2"));
      
      List<Todo> todos = service.getTodos("foo");
      assertNotNull(todos);
      assertEquals(2, todos.size());
   }

   public void testRemovingTodo() throws TodoException
   {
      service.addTodo("foo", new Todo("foo_todo2"));
      assertNotNull(service.getTodo("foo", "foo_todo2"));
      
      Todo todo = service.removeTodo("foo", "foo_todo2");
      assertNotNull(todo);
      
      todo = service.getTodo("foo", "foo_todo2");
      assertNull(todo);
   }
}
