package com.codingmak.familyguyapi;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@Route("/")
@PageTitle("Family Guy - API")
public class MainView extends AppLayout {

    private static final long serialVersionUID = -3912490948791898544L;

    public MainView() {
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Family Guy - API");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        FlexLayout navWrapper = getNavWrapper();

        Scroller scroller = new Scroller(navWrapper);
        scroller.setClassName(LumoUtility.Padding.SMALL);

        addToDrawer(scroller);
        addToNavbar(toggle, title);

        Div footer = createFooter();
        addToNavbar(true, footer);
    }

    private FlexLayout getNavWrapper() {
        FlexLayout navWrapper = new FlexLayout();
        navWrapper.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        navWrapper.setHeightFull();
        navWrapper.setWidthFull();

        SideNav sideNav = getSideNav();
        navWrapper.add(sideNav);
        navWrapper.expand(sideNav);

        Anchor externalLink = new Anchor("https://www.codingmak.com", "CodingMak");
        externalLink.setTarget("_blank");
        externalLink.getElement().getStyle().set("margin-top", "auto");
        externalLink.getStyle().set("padding", "10px").set("display", "block");

        navWrapper.add(externalLink);

        return navWrapper;
    }

    private SideNav getSideNav() {
        SideNav sideNav = new SideNav();
        sideNav.addItem(
                new SideNavItem("Dashboard", "/",
                        VaadinIcon.DASHBOARD.create()),
                new SideNavItem("Episodes", "/episodes", 
                        VaadinIcon.DESKTOP.create()),
                new SideNavItem("Characters", "/characters",
                        VaadinIcon.USER.create()));

        return sideNav;
    }

    private Div createFooter() {
        Div footer = new Div();
        footer.getStyle().set("background-color", "var(--lumo-shade-10pct)")
                .set("padding", "0.5em")
                .set("text-align", "center")
                .set("position", "fixed")
                .set("bottom", "0")
                .set("width", "100%");

        Paragraph footerText = new Paragraph("© 2024 Family Guy API");
        footerText.getStyle().set("margin", "0");

        footer.add(footerText);
        return footer;
    }
}
