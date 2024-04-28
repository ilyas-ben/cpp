package com.example.cpp.presentation;

import com.example.cpp.model.Client;
import com.example.cpp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/****** Implement on success  *****/


@Controller
@RequestMapping("/clients") // KHRJTI 3LIA!  !!!!
public class ClientController {

    @Autowired
    private ClientService clientService;


                                /* METHODS */
    // DISPLAY CLIENT(S)
    @GetMapping
    public String getAllClients(Model model){
        model.addAttribute("clients",getAllClients());
        return "index";
    }

    @GetMapping("/{id}")
    public String getClientById(Model model,@PathVariable Long id){
        Client client = clientService.getClientById(id);
        model.addAttribute("client", client);
        return "detailClient";
    }



    // ADD CLIENT
    @GetMapping("/add")
    public String addForm(Model model){ // redirect to client add form
        Client client = new Client();
        model.addAttribute(client);
        return "add/form";
    }
    @PostMapping
    public String saveClient(@ModelAttribute("client") Client client){ // submit the new client
        clientService.saveClient(client);
        return "success";
    }


        // DELETE CLIENT
    @GetMapping("/delete/{id}") // redirect to client delete confirmation page
    public String deleteConfirm(Model model, @PathVariable Long id){
        model.addAttribute(id);
        model.addAttribute("nameOfClientToDelete", clientService.getClientById(id).getNom()); // just to display it in the confirmation
        System.out.println(clientService.getClientById(id).getNom());
        return "deleteOrNot";
    }

    @DeleteMapping("/{id}")
    public String deleteClientt(@PathVariable Long id){ // submittting the delete request
        clientService.deleteClient(id);
        return "success";
    }


    // update client
    @GetMapping("/update/{id}")
    public String updateClientForm( Model model, @PathVariable Long id){ // redirect to update form
        Client client = clientService.getClientById(id);
        model.addAttribute(client);
        return "update/updateForm";
    }

    @PutMapping
    public String updateClientt(@RequestBody Client client){ // submittting the update request
        clientService.updateClient(client);
        return "success";
    }


    // JSON
    @GetMapping("/json")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/json/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping("/json")
    public void saveClients(@RequestBody List<Client> clients) {
        clientService.saveClients(clients);
    }
    @DeleteMapping("/json/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
