package com.bookstore.repository;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bookstore.domain.User;
import com.bookstore.domain.security.PasswordResetToken;

/**
 * 
 * @author Manan
 *
 */
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {

		PasswordResetToken findByToken(String token);
	
		PasswordResetToken findyUser(User user);
		
		Stream<PasswordResetToken> findAllByExpiryDateLessThan(Date now);
		
		@Modifying
		@Query("Delete from PasswordResetToken t where t.expirydate <= ?1")
		void deleteAllExpiredSince(Date now);
	
}
