package actionhook;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.persistence.LayoutFinderUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.Enumeration;


/**
 * @author mipradee
 */
@Component(immediate = true, property = {
		"javax.portlet.name=com_liferay_dynamic_data_lists_web_portlet_DDLDisplayPortlet",
		"javax.portlet.name=com_liferay_dynamic_data_lists_web_portlet_DDLDisplayPortlet", "mvc.command.name=addRecord",
		"service.ranking:Integer=700" }, service = MVCActionCommand.class)
public class DDLActionHook extends BaseMVCActionCommand {

	@Reference(target = "(component.name=com.liferay.dynamic.data.lists.web.internal.portlet.action.AddRecordMVCActionCommand)")

	public void setMvcActionCommand(MVCActionCommand mvcActionCommand) {
		this.mvcActionCommand = mvcActionCommand;
	}

	public MVCActionCommand getMvcActionCommand() {
		return this.mvcActionCommand;
	}

	protected MVCActionCommand mvcActionCommand;
	private Portal _portal;

	private static final Log _log = LogFactoryUtil.getLog(DDLActionHook.class);
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		_log.info("******************DDLMVCActionCommand.processAction()********************");
		
		//Uncomment below line if DDLForm default action is needed		
		//mvcActionCommand.processAction(actionRequest, actionResponse);
		sendRedirect(actionRequest, actionResponse);
		_log.info("after process...");

	}

	@Override
	protected void sendRedirect(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
		// TODO Auto-generated method stub
		// System.out.println("calling redirect..."+param);
		
		ThemeDisplay td=(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Enumeration<String> keys = actionRequest.getParameterNames();
		String emailAd = null;
		String loc = null;
		while (keys.hasMoreElements()) {
			String elem = keys.nextElement();
			if (elem.contains("Email")) {
				emailAd = elem;
			} else if (elem.contains("LocationId")) {
				loc = elem;
			}
		}

		String emailAddress = actionRequest.getParameter(emailAd);
		String location = actionRequest.getParameter(loc);
		String redirectURL = "/company";

		if (null != emailAddress) {
			
			int index = emailAddress.lastIndexOf("hpe.com");
			if (index > 0) {
				redirectURL = "/internalreg";
			} else if (null != location && index < 0) {
				redirectURL = "/newcompany";
			}
		}
		
		try {
			
			Layout layout=LayoutLocalServiceUtil.getLayout(td.getPlid());
			String redirectFinalURL=layout.getScopeGroup()+layout.getGroup().getFriendlyURL()+redirectURL;
			_log.info(redirectFinalURL);
			actionRequest.setAttribute(WebKeys.REDIRECT, redirectURL);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.sendRedirect(actionRequest, actionResponse);
		_log.info("redirectURL:"+redirectURL);
		//actionResponse.sendRedirect(redirectURL);
		
	}

	@Override
	protected boolean redirectToLogin(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
		// TODO Auto-generated method stub
		_log.info("calling redirect...");

		return true;
	}

}
