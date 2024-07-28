package ar.com.laboratory.candidatesapi.application.repository;

import ar.com.laboratory.candidatesapi.infrastructure.entity.document.AppUserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AppUserRepository extends MongoRepository<AppUserDocument, String> {

    Optional<AppUserDocument> findByUsername(String username);
}
