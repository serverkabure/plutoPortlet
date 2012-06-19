package plutoportlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

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
		response.setContentType("text/html; charset=UTF-8");
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
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write("<form>");
		writer.write("<p>EDITÉyÅ[ÉW</p>");
		writer.write("</form>");
		writer.close();
	}

	@Override
	protected void doHelp(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write("<form>");
		writer.write("<p>getenv</p>");
		writer.write("<table border='1'>");
		writer.write("<tr><td>key</td><td>value</td></tr>");
		Map<String, String> map = System.getenv();
		for (Map.Entry<String, String> e : map.entrySet())
			writer.write("<tr><td>" + e.getKey() + "</td><td>" + e.getValue()
					+ "</td></tr>");
		writer.write("</table>");
		writer.write("</form>");
		writer.close();

		// PortletRequestDispatcher dispatcher = getPortletContext()
		// .getRequestDispatcher(helpPage);
		// dispatcher.include(request, response);
	}

	@Override
	public void processAction(ActionRequest request, ActionResponse response)
			throws PortletException, IOException {
		String message = request.getParameter("message");
		// request.setAttribute("message", message);
		response.setRenderParameter("message", message);
	}
}
