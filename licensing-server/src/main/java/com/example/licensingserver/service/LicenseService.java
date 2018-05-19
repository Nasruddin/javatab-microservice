package com.example.licensingserver.service;

import com.example.licensingserver.model.License;
import com.example.licensingserver.repository.LicenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicenseService {

    private LicenseRepository licenseRepository;

    public LicenseService(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    public License createLicense(License license) {
        return this.licenseRepository.save(license);
    }

    public List<License> findByOrganizationId(String organisationId) {
        return this.licenseRepository.findByOrganizationId(organisationId);
    }

    public License findByOrganizationIdAndLicenseId(String organizationId, String licenseId) {
        return this.licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
    }
}

