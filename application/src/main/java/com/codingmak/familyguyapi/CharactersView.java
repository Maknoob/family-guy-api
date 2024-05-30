package com.codingmak.familyguyapi;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "/characters", layout = MainView.class)
@PageTitle("Family Guy - API - Characters")
public class CharactersView extends VerticalLayout {

	private static final long serialVersionUID = -8255893756066906597L;
	
	public CharactersView() {
		
		Text dummText = new Text("working on it");
		add(dummText);
		
	}
}
