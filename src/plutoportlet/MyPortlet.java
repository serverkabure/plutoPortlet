package plutoportlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class MyPortlet extends GenericPortlet {
	private String viewPage = "/WEB-INF/jsp/view.jsp";
	private String editPage = "/WEB-INF/jsp/edit.jsp";
	private String helpPage = "/WEB-INF/jsp/help.jsp";

	@Override
	public void init(PortletConfig config) throws PortletException {
		super.init(config);
		this.viewPage = config.getInitParameter("viewPage");
		this.editPage = config.getInitParameter("editPage");
		this.helpPage = config.getInitParameter("helpPage");
	}

	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		String message = request.getParameter("message");
		// if (message == null)
		request.setAttribute("message", message);

		PortletRequestDispatcher dispatcher = getPortletContext()
				.getRequestDispatcher(viewPage);
		dispatcher.include(request, response);
	}

	@Override
	protected void doEdit(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		PortletRequestDispatcher dispatcher = getPortletContext()
				.getRequestDispatcher(editPage);
		dispatcher.include(request, response);
	}

	@Override
	protected void doHelp(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		PortletRequestDispatcher dispatcher = getPortletContext()
				.getRequestDispatcher(helpPage);
		dispatcher.include(request, response);
	}

	@Override
	public void processAction(ActionRequest request, ActionResponse response)
			throws PortletException, IOException {
		String message = request.getParameter("message");
		// request.setAttribute("message", message);
		response.setRenderParameter("message", message);
	}
}
