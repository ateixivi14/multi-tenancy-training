package com.example.multitenancytraining.configuration;

public class TenantContext {

    private static ThreadLocal<String> currentTenant = new ThreadLocal<>();

    public static void setTenantId(String tenantId) {
        currentTenant.set(tenantId);
    }

    public static String getTenantId() {
        return currentTenant.get();
    }

    public static void clear(){
        currentTenant.remove();
    }
}
