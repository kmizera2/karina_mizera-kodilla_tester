package com.kodilla.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class NotificationServiceTestSuite {

    NotificationService notificationService = new NotificationService();
    Client client = Mockito.mock(Client.class);
    Client secondClient = Mockito.mock(Client.class);
    Client thirdClient = Mockito.mock(Client.class);
    Notification notification = Mockito.mock(Notification.class);

    @Test
    public void notSubscribedClientShouldNotReceiveNotification() {

        notificationService.sendNotification(notification);
        //Mockito.never() pozwala zweryfikować, czy dana metoda nigdy nie została wywołana z podanym argumentem
        Mockito.verify(client, Mockito.never()).receive(notification);
    }

    //moj test 2 w wyniku
    @Test
    public void subscribedClientShouldReceiveNotification() {

        notificationService.sendNotification(notification);
        client.receive(notification);
        Mockito.verify(client, Mockito.atLeastOnce()).receive(notification);
    }

    @Test
    public void subscribedClientShouldReceiveNotification2() {

        notificationService.addSubscriber(client);

        notificationService.sendNotification(notification);
       // client.receive(notification); gdybym to odkomentowala ponizej 2
        Mockito.verify(client, Mockito.times(1)).receive(notification);
    }

    @Test
    public void notificationShouldBeSentToAllSubscribedClients() {
        addSubscribers(client, secondClient, thirdClient);



        notificationService.sendNotification(notification);
        Mockito.verify(client, Mockito.times(1)).receive(notification);
        Mockito.verify(secondClient, Mockito.times(1)).receive(notification);
        Mockito.verify(thirdClient, Mockito.times(1)).receive(notification);
    }


    @Test
    public void shouldSendOnlyOneNotificationToMultiTimeSubscriber() {
        addSubscribers(client, client, client);
        notificationService.sendNotification(notification);

        Mockito.verify(client, Mockito.times(1)).receive(notification);
    }

    @Test
    public void unsubscribedClientShouldNotReceiveNotification() {

        notificationService.addSubscriber(client);
        notificationService.removeSubscriber(client);

        notificationService.sendNotification(notification);
        Mockito.verify(client, Mockito.never()).receive(notification);
    }

    private void addSubscribers(Client... clients) {
        for(Client currentClient : clients) {
            notificationService.addSubscriber(currentClient);
        }
    }
}

