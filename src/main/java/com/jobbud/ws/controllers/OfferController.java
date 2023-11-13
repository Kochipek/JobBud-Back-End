package com.jobbud.ws.controllers;


import com.jobbud.ws.entities.OfferEntity;
import com.jobbud.ws.requests.OfferRequest;
import com.jobbud.ws.requests.UpdateStatusRequest;
import com.jobbud.ws.services.OfferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1.0/offers")
public class OfferController {
    private OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping
    public OfferEntity createOffer(OfferRequest offerRequest) {
        return offerService.addOffer(offerRequest);

    }

    @GetMapping
    public List<OfferEntity> getOffers(@RequestParam Optional<Long> ownerId, @RequestParam Optional<Long> jobId) {
        return offerService.getOffers(ownerId, jobId);
    }

    // id
    @GetMapping("/{offerId}")
    public OfferEntity getOfferById(Long offerId) {
        return offerService.getOfferById(offerId);
    }

    @PutMapping("/{offerId}")
    public OfferEntity updateOfferStatus(@PathVariable long offerId, @RequestBody OfferRequest offerRequest) {
        return offerService.updateOffer(offerId, offerRequest);
    }

    @PutMapping("/{offerId}/status")
    public OfferEntity updateOfferStatus(@PathVariable long offerId, @RequestBody UpdateStatusRequest updateStatusRequest) {
        return offerService.updateOfferStatus(offerId, updateStatusRequest);
    }



}