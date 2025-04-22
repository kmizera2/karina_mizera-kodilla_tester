package com.kodilla.mockito.homework;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WeatherAlertService {
    private final Map<Location, Set<Client>> subscriptions = new HashMap<>();

    public void subscribe(Client client, Location location) {
        subscriptions.computeIfAbsent(location, k -> new HashSet<>()).add(client);
    }

    public void unsubscribe(Client client, Location location) {
        if (subscriptions.containsKey(location)) {
            subscriptions.get(location).remove(client);
            if (subscriptions.get(location).isEmpty()) {
                subscriptions.remove(location);
            }
        }
    }

    public void unsubscribeFromAllLocations(Client client) {
        for (Set<Client> clients : subscriptions.values()) {
            clients.remove(client);
        }
        subscriptions.entrySet().removeIf(entry -> entry.getValue().isEmpty());
    }

    public void sendAlert(Location location, String message) {
        Set<Client> clients = subscriptions.get(location);
        if (clients != null) {
            for (Client client : clients) {
                client.receive(message);
            }
        }
    }

    public void sendAlertToAll(String message) {
        Set<Client> allClients = new HashSet<>();
        for (Set<Client> clients : subscriptions.values()) {
            allClients.addAll(clients);
        }
        for (Client client : allClients) {
            client.receive(message);
        }
    }

    public void deleteLocation(Location location) {
        subscriptions.remove(location);
    }
}


