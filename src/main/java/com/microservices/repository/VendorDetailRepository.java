package com.microservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.microservices.domain.VendorDetail;

@RepositoryRestResource(collectionResourceRel = "vendorService", path = "vendorService")
public interface VendorDetailRepository extends CrudRepository<VendorDetail, String> {
	

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    <S extends VendorDetail> S save(S s);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    <S extends VendorDetail> Iterable<S> save(Iterable<S> iterable);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void delete(String s);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void delete(VendorDetail tourPackage);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void delete(Iterable<? extends VendorDetail> iterable);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void deleteAll();
}
