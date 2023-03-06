package org.sid.ebankingbackend.resources;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.ebankingbackend.dtos.CustomerDTO;
import org.sid.ebankingbackend.exceptions.CustomerNotFoundException;
import org.sid.ebankingbackend.services.BankAccountService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Component
@Slf4j
@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerResource {

    private BankAccountService bankAccountService;

    public CustomerResource(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }


    @GET
    public List<CustomerDTO> listCustomers(){
        return bankAccountService.listCustomers();
    }

    @GET
    @Path("/search")
    public List<CustomerDTO> searchCustomers(@QueryParam("keyword") String keyword){
        return bankAccountService.searchCustomers("%"+keyword+"%");
    }

    @GET
    @Path("/{id}")
    public CustomerDTO getCustomer(@PathParam("id") Long customerId) throws CustomerNotFoundException {
        return bankAccountService.getCustomer(customerId);
    }

    @POST
    public CustomerDTO saveCustomer(CustomerDTO customerDTO){
        return bankAccountService.saveCustomer(customerDTO);
    }

    @PUT
    @Path("/{customerId}")
    public CustomerDTO updateCustomer(@PathParam("customerId") Long customerId, CustomerDTO customerDTO){
        customerDTO.setId(customerId);
        return bankAccountService.updateCustomer(customerDTO);
    }

    @DELETE
    @Path("/{id}")
    public void deleteCustomer(@PathParam("id") Long id){
        bankAccountService.deleteCustomer(id);
    }
}
