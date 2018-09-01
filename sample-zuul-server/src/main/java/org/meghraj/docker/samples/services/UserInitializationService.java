package org.meghraj.docker.samples.services;

import org.meghraj.docker.samples.config.InitialUsers;
import org.meghraj.docker.samples.data.Account;
import org.meghraj.docker.samples.dto.User;
import org.meghraj.docker.samples.jpa.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.Collection;

/**
 * Created by C840290 on 8/30/2018.
 *
 * @author Chandra Annavajjala (C840290)
 */

@Service
public class UserInitializationService {

    @Autowired
    private InitialUsers initialUsers;

    @Autowired
    private AccountsRepository accountsRepository;

    @PostConstruct
    private void initBasedOnConfig() {
        initializeUserStore(initialUsers.getUsers());
    }

    @Transactional
    public void initializeUserStore(Collection<User> users) {
        clearAllUsers();
        for (User user:users) {
            accountsRepository.save(convertDto(user));
        }
    }

    private Account convertDto(User user) {
        Account account = new Account();
        account.setEmail(user.getEmail());
        account.setFirstName(user.getFirstName());
        account.setLastName(user.getLastName());
        account.setUserName(user.getUserName());
        return  account;
    }

    @Transactional
    private void clearAllUsers() {
        accountsRepository.deleteAll();
    }

}
