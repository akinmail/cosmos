package com.cosmos.hack.model;

import com.cosmos.hack.model.document.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class Shipment {
    @Id
    private String id;
    private String edd;

    private ImportProcess importProcess;

    private Bol bol;
    private CommercialInvoice commercialInvoice;
    private Ccvo ccvo;
    private PackingList packingList;
    private ManufacturerCertificate manufacturerCertificate;
    private Cria cria;
    private boolean isDocumentComplete = false;
    private Float demurrage;

    public Shipment() {
    }

    public void copy(Shipment other) {
        this.id = UUID.randomUUID().toString().replaceAll("-","");
        this.edd = other.edd;
        this.importProcess = other.importProcess;
        this.bol = other.bol;
        this.commercialInvoice = other.commercialInvoice;
        this.ccvo = other.ccvo;
        this.packingList = other.packingList;
        this.manufacturerCertificate = other.manufacturerCertificate;
        this.cria = other.cria;
        this.isDocumentComplete = other.isDocumentComplete;
        this.demurrage = other.demurrage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEdd() {
        return edd;
    }

    public void setEdd(String edd) {
        this.edd = edd;
    }

    public ImportProcess getImportProcess() {
        return importProcess;
    }

    public void setImportProcess(ImportProcess importProcess) {
        this.importProcess = importProcess;
    }

    public Bol getBol() {
        return bol;
    }

    public void setBol(Bol bol) {
        this.bol = bol;
    }

    public CommercialInvoice getCommercialInvoice() {
        return commercialInvoice;
    }

    public void setCommercialInvoice(CommercialInvoice commercialInvoice) {
        this.commercialInvoice = commercialInvoice;
    }

    public Ccvo getCcvo() {
        return ccvo;
    }

    public void setCcvo(Ccvo ccvo) {
        this.ccvo = ccvo;
    }

    public PackingList getPackingList() {
        return packingList;
    }

    public void setPackingList(PackingList packingList) {
        this.packingList = packingList;
    }

    public ManufacturerCertificate getManufacturerCertificate() {
        return manufacturerCertificate;
    }

    public void setManufacturerCertificate(ManufacturerCertificate manufacturerCertificate) {
        this.manufacturerCertificate = manufacturerCertificate;
    }

    public Cria getCria() {
        return cria;
    }

    public void setCria(Cria cria) {
        this.cria = cria;
    }

    public boolean isDocumentComplete() {
        return isDocumentComplete;
    }

    public void setDocumentComplete(boolean documentComplete) {
        isDocumentComplete = documentComplete;
    }

    public Float getDemurrage() {
        return demurrage;
    }

    public void setDemurrage(Float demurrage) {
        this.demurrage = demurrage;
    }
}
