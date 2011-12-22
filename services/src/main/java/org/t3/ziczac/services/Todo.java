package org.t3.ziczac.services;

import java.util.Date;

/**
 * @author <a href="trongtt@gmail.com">Trong Tran</a>
 * @version $Revision$
 */
public class Todo
{
   public String id;

   public String name;

   public Date dueDate;

   public int state;
   
   public Todo(String name)
   {
      this.id = name;
      this.name = name;
   }
}
