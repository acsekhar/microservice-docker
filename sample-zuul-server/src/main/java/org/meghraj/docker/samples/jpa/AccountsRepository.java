package org.meghraj.docker.samples.jpa;

import org.meghraj.docker.samples.data.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by C840290 on 8/30/2018.
 *
 * @author Chandra Annavajjala (C840290)
 */
public interface AccountsRepository extends JpaRepository<Account,Long> {
    Account findByUserName(String username);
}
