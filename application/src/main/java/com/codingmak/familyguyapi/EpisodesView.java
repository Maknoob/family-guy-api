package com.codingmak.familyguyapi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "/episodes", layout = MainView.class)
@PageTitle("Family Guy - API - Episodes")
public class EpisodesView extends VerticalLayout {

    private static final long serialVersionUID = -1402067428633849786L;
    private TextArea codeArea;
    private Select<String> seasonSelect;

    public EpisodesView() {
        codeArea = new TextArea("API Response");
        codeArea.getStyle().set("height", "400px")
            .set("width", "100%")
            .set("border", "1px")
            .set("border-radius", "10px")
            .set("cursor", "text");
        codeArea.setReadOnly(true);

        TextField searchById = new TextField("Search By ID");
        searchById.getStyle().setBorder("1px");

        seasonSelect = new Select<>();
        seasonSelect.setItems("1", "2", "3", "4", "5");
        seasonSelect.setWidth("10em");
        seasonSelect.setPlaceholder("Select Season");

        seasonSelect.addValueChangeListener(event -> {
            String selectedSeason = event.getValue();
            if (selectedSeason != null) {
                updateTextAreaWithLoadingMessage(selectedSeason);
                String apiUrl = "http://localhost:8080/rest/episodes?season=" + selectedSeason;
                fetchApiData(apiUrl, selectedSeason);
            }
        });

        add(codeArea);
        add(searchById);
        add(seasonSelect);

        String apiUrl = "http://localhost:8080/rest/episodes";
        fetchApiData(apiUrl, null);
    }

    private void updateTextAreaWithLoadingMessage(String season) {
        getUI().ifPresent(ui -> ui.access(() -> {
            codeArea.setValue("Loading data for season: " + season + "...");
        }));
    }

    private void fetchApiData(String apiUrl, String season) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(response -> {
                    String formattedJson = formatJson(response);
                    getUI().ifPresent(ui -> ui.access(() -> {
                        if (season != null) {
                            codeArea.setValue("Season: " + season + "\n" + formattedJson);
                        } else {
                            codeArea.setValue(formattedJson);
                        }
                        codeArea.getElement().executeJs("this.scrollTop = 0");
                    }));
                })
                .exceptionally(ex -> {
                    ex.printStackTrace();
                    getUI().ifPresent(ui -> ui.access(() -> codeArea.setValue("Failed to fetch API data")));
                    return null;
                });
    }

    private String formatJson(String jsonString) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Object json = mapper.readValue(jsonString, Object.class);
            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
            return writer.writeValueAsString(json);
        } catch (IOException e) {
            e.printStackTrace();
            return jsonString;
        }
    }
}
