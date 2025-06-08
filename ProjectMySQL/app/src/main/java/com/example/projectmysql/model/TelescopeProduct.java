package com.example.projectmysql.model;

public class TelescopeProduct {
    public int id;
    public String productName;
    public String model;
    public int originalPrice;
    public int discountedPrice;
    public float tubeLengthCm;
    public int focalLengthMm;
    public float weightKg;
    public int apertureMm;
    public String eyepieces;
    public String additionalInfo;

    public TelescopeProduct(int id, String productName, String model, int originalPrice, int discountedPrice,
                            float tubeLengthCm, int focalLengthMm, float weightKg, int apertureMm,
                            String eyepieces, String additionalInfo) {
        this.id = id;
        this.productName = productName;
        this.model = model;
        this.originalPrice = originalPrice;
        this.discountedPrice = discountedPrice;
        this.tubeLengthCm = tubeLengthCm;
        this.focalLengthMm = focalLengthMm;
        this.weightKg = weightKg;
        this.apertureMm = apertureMm;
        this.eyepieces = eyepieces;
        this.additionalInfo = additionalInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }

    public int getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(int discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public float getTubeLengthCm() {
        return tubeLengthCm;
    }

    public void setTubeLengthCm(float tubeLengthCm) {
        this.tubeLengthCm = tubeLengthCm;
    }

    public int getFocalLengthMm() {
        return focalLengthMm;
    }

    public void setFocalLengthMm(int focalLengthMm) {
        this.focalLengthMm = focalLengthMm;
    }

    public float getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(float weightKg) {
        this.weightKg = weightKg;
    }

    public int getApertureMm() {
        return apertureMm;
    }

    public void setApertureMm(int apertureMm) {
        this.apertureMm = apertureMm;
    }

    public String getEyepieces() {
        return eyepieces;
    }

    public void setEyepieces(String eyepieces) {
        this.eyepieces = eyepieces;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
