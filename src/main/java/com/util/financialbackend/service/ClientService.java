package com.util.financialbackend.service;

import com.util.financialbackend.model.Client;
import com.util.financialbackend.model.Spent;
import com.util.financialbackend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;
    @Autowired
    private SpentService service;

    public Client save(Client c){
        return repository.save(c);
    }
    public List<Client> list(){
        return repository.findAll();
    }
    public List<Client> listActive(){
        return repository.findAllAtiveClient();
    }
    public Client find(Long id) throws Exception {
        Optional<Client> client = repository.findById(id);
        if(client.isEmpty()){
            throw new Exception("Client not found by id"+id);
        }
        return client.get();
    }
    public Client update(Client client,Long id) throws Exception {
        Client temp = find(id);
        temp.setName(client.getName());
        temp.setSalary(client.getSalary());
        return repository.save(temp);
    }
    public void addSpent(Long idClient,Long idSpent) throws Exception {
        Client temp = find(idClient);
        List<Spent> spents = temp.getSpents();
        spents.add(service.find(idSpent));
        temp.setSpents(spents);
    }
    public void deleteLogic(Long id) throws Exception {
        Client client = find(id);
        client.setDeleted(true);
        repository.save(client);
    }
}
