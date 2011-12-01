package org.t3.ziczac;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class ZicZacPortlet extends AbstractSamplePortlet
{
   @RenderMode(name = "view")
   public void renderViewMode(RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      getPortletContext().getRequestDispatcher("/view.jsp").include(request, response);
   }
}
