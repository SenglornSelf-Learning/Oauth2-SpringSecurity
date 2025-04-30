package com.senglornOauth2.repository.clientDatabase;

import java.util.Optional;

import com.senglornOauth2.entity.clientDatabase.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
	Optional<Client> findByClientId(String clientId);
}