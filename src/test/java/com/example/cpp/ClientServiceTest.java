package com.example.cpp;

import com.example.cpp.model.Client;
import com.example.cpp.repo.ClientRepo;
import com.example.cpp.service.ClientService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ClientServiceTest {


    private ClientService clientService;

    public ClientServiceTest() {
        clientService = new ClientService();
    }

    @Test
    public void test(){
        Client instanceofClient = clientService.getClientById(2L);
        Assert.assertTrue(instanceofClient!=null);
    }

    /*@Test
    public void testRepo(){
        ClientRepo clientRepo = mock(ClientRepo.class);
        when(clientRepo.findById(2L).get()).thenReturn(new Client())

    }*/

}
