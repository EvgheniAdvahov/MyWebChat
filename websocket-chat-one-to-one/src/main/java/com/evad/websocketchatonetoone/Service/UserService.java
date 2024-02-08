package com.evad.websocketchatonetoone.Service;

import com.evad.websocketchatonetoone.Data.User.UserRepository;
import com.evad.websocketchatonetoone.Data.User.Status;
import com.evad.websocketchatonetoone.Data.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public void saveUser(User user){
        user.setStatus(Status.ONLINE);
        repository.save(user);
    }

    public void disconnect(User user) {
        var stroreUser = repository.findById(user.getNickName())
                .orElse(null);
        if(stroreUser != null) {
            stroreUser.setStatus(Status.OFFLINE);
            repository.save(stroreUser);
        }
    }

    public List<User> findConnectedUsers() {

        return repository.findAllByStatus(Status.ONLINE);
    }
}
