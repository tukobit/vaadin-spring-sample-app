package ru.xpoft.vaadin.sample.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.xpoft.vaadin.DiscoveryNavigator;
import ru.xpoft.vaadin.sample.integration.beans.ApplicationCounter;
import ru.xpoft.vaadin.sample.integration.beans.SessionCounter;
import ru.xpoft.vaadin.sample.integration.service.SampleService;

import com.vaadin.annotations.Theme;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ui.PageState;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

/**
 * @author xpoft
 */
@Component
@Scope("prototype")
@Theme("rapid")
public class MyUI extends UI {
	@Autowired
	private transient ApplicationContext applicationContext;

	@Autowired
	private SessionCounter sessionCounter;

	@Autowired
	private ApplicationCounter applicationCounter;

	@Autowired
	private SampleService sampleService;

	@Override
	protected void init(final VaadinRequest request) {
		setSizeFull();

		DiscoveryNavigator navigator = new DiscoveryNavigator(this, this);

		Notification
				.show(String
						.format("Session counter: %d, application counter: %d, sampleService: %d",
								sessionCounter.getCount(),
								applicationCounter.getCount(),
								sampleService.getRandom()));

	}

	@Override
	public Page getPage() {
		Page page = super.getPage();
		if (page == null) {
			// Create the window object.
			PageState pstate = new PageState();
			pstate.title = "Index Page";
			page = new Page(this, pstate);
			
		}
		return page;
	}
}