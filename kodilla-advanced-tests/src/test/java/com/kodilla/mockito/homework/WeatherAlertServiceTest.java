package com.kodilla.mockito.homework;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Set;

import static org.mockito.Mockito.*;

class WeatherAlertServiceTest {
    private WeatherAlertService alertService;
    private Client client1;
    private Client client2;
    private Location location1;
    private Location location2;

    @BeforeEach
    void setup() {
        alertService = new WeatherAlertService();
        client1 = mock(Client.class);
        client2 = mock(Client.class);
        location1 = new Location("Warsaw");
        location2 = new Location("Krakow");
    }

    @Test
    void shouldSubscribeClientToLocation() {
        alertService.subscribe(client1, location1);
        alertService.sendAlert(location1, "Hail alert!");

        verify(client1, times(1)).receive("Hail alert!");
    }

    @Test
    void shouldNotSubscribeClientTwiceToSameLocation() {
        alertService.subscribe(client1, location1);
        alertService.subscribe(client1, location1);
        alertService.sendAlert(location1, "Storm warning");

        verify(client1, times(1)).receive("Storm warning");
    }

    @Test
    void shouldUnsubscribeClientFromLocation() {
        alertService.subscribe(client1, location1);
        alertService.unsubscribe(client1, location1);
        alertService.sendAlert(location1, "Flood alert");

        verify(client1, never()).receive(anyString());
    }

    @Test
    void shouldUnsubscribeClientFromAllLocations() {
        alertService.subscribe(client1, location1);
        alertService.subscribe(client1, location2);

        alertService.unsubscribeFromAllLocations(client1);

        alertService.sendAlert(location1, "Storm");
        alertService.sendAlert(location2, "Snowfall");

        verify(client1, never()).receive(anyString());
    }

    @Test
    void shouldSendAlertToAllClients() {
        alertService.subscribe(client1, location1);
        alertService.subscribe(client2, location2);

        alertService.sendAlertToAll("Terms updated");

        verify(client1).receive("Terms updated");
        verify(client2).receive("Terms updated");
    }

    @Test
    void shouldSendAlertToClientsFromChosenLocation() {
        alertService.subscribe(client1, location1);
        alertService.subscribe(client2, location2);

        alertService.sendAlert(location1, "Storm");;

        verify(client1).receive("Storm");
        verify(client2, never()).receive(anyString());
    }

    @Test
    void shouldSendAlertToFewClientsFromOneLocation() {
        alertService.subscribe(client1, location1);
        alertService.subscribe(client2, location1);

        alertService.sendAlert(location1, "Storm");;

        verify(client1).receive("Storm");
        verify(client2).receive("Storm");
    }

    @Test
    void shouldDeleteLocation() {
        alertService.subscribe(client1, location1);
        alertService.deleteLocation(location1);
        alertService.sendAlert(location1, "Heatwave");

        verify(client1, never()).receive(anyString());
    }
}