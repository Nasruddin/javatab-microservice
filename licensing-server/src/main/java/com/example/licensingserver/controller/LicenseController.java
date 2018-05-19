package com.example.licensingserver.controller;

import com.example.licensingserver.model.License;
import com.example.licensingserver.service.LicenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/organizations/{organizationId}/licenses")
public class LicenseController {

    private LicenseService licenseService;

    public LicenseController(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @PostMapping("/")
    public ResponseEntity<License> createLincense(@RequestBody License license) {
        return new ResponseEntity<>(this.licenseService.createLicense(license),
                HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<License>> getLicenses(@PathVariable("organizationId") String organizationId) {

        return new ResponseEntity<>(this.licenseService.findByOrganizationId(organizationId),
                HttpStatus.OK);
    }

    @GetMapping("/{licenseId}")
    public ResponseEntity<License> getLicenses( @PathVariable("organizationId") String organizationId,
                                @PathVariable("licenseId") String licenseId) {
        return new ResponseEntity<>(this.licenseService.findByOrganizationIdAndLicenseId(organizationId, licenseId),
                HttpStatus.OK);
    }
}
