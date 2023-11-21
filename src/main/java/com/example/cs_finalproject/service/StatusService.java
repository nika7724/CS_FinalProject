package com.example.cs_finalproject.service;
import com.example.cs_finalproject.model.Status;
import com.example.cs_finalproject.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    private final StatusRepository statusRepository;

    public StatusService(final StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    //find all status
    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }

    //find by id
    public Status getStatusById(Integer id) {
        return statusRepository.findById(id).orElse(null);
    }

    //
}

