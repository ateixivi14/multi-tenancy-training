# Multi-Tenancy

Multi-tenancy is an architecture in which a single instance of a software application serves multiple customers. Each customer is called a tenant.

It allows separated tenants to view the application as it was their own.

A typical scenario that lends itself to a multi-tenant application is one in which all users of the same application may wish to customize the user.


This implementation is a case of multi-tenancy with discriminator column. The database is shared with all tenants. The application has the responsibility to apply the filtering.

It's necessary to define an interceptor which will be responsible for capturing the tenant id that comes in the header of the requests.

Once we intercept the tenant id, we save it in the context (the same thread)


For filtering into the database, an AbstractBaseEntity is defined in which we define the filter that will be used:

@FilterDef(name = "tenantFilter", parameters = {@ParamDef(name = "tenantId", type = "string")})
@Filter(name = "tenantFilter", condition = "tenant_id = :tenantId")

And also use @PrePersist annotation to save the tenant in case we add some register.

The methods in the repository that filter by Id as for example findById in contract repository, it's necessary set as a default the method because it not uses entity manager to query in the database, so the filter won't be applied.

default Optional<Contract> findById(Long id) {
    return findByTenantIdAndId(TenantContext.getTenantId(), id);
}

To activate the filter we use an Aspect 