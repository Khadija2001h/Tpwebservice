package com.example.tpwebservices.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.example.tpwebservices.Entity.Compte;
import com.example.tpwebservices.Repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Path("/banque")
public class CompteRestJaxRSAPI {

    @Autowired
    private CompteRepository compteRepository;

    // Récupérer tous les comptes (JSON et XML)
    @GET
    @Path("/comptes")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Compte> getComptes() {
        return compteRepository.findAll();
    }

    // Récupérer un compte par ID (JSON et XML)
    @GET
    @Path("/comptes/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Compte getCompte(@PathParam("id") Long id) {
        return compteRepository.findById(id).orElse(null);
    }

    // Ajouter un nouveau compte (JSON et XML)
    @POST
    @Path("/comptes")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Compte addCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    // Mettre à jour un compte existant (JSON et XML)
    @PUT
    @Path("/comptes/{id}")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Compte updateCompte(@PathParam("id") Long id, Compte compte) {
        Compte existingCompte = compteRepository.findById(id).orElse(null);
        if (existingCompte != null) {
            existingCompte.setSolde(compte.getSolde());
            existingCompte.setDateCreation(compte.getDateCreation());
            existingCompte.setType(compte.getType());
            return compteRepository.save(existingCompte);
        }
        return null;
    }

    // Supprimer un compte (JSON et XML)
    @DELETE
    @Path("/comptes/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void deleteCompte(@PathParam("id") Long id) {
        compteRepository.deleteById(id);
    }
}

