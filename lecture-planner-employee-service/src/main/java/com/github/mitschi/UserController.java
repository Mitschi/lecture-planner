package com.github.mitschi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserDao userDao;

    //    @RequestMapping("/user")
//    public String home() {
//        LOG.info("home!");
//        try {
//            return "Hello Docker World from "+ InetAddress.getLocalHost().getHostName()+" !  Time is: "+new Date();
//        } catch (UnknownHostException e) {
//            return "Hello DOCKER!";
//        }
//    }
    @GetMapping(name = "/users")
    public List<User> listUsers() {
        return this.userDao.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
        User user = userDao.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userDao.save(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
                                           @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userDao.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

//        user.setEmailId(userDetails.getEmailId());
//        user.setLastName(userDetails.getLastName());
//        user.setFirstName(userDetails.getFirstName());
        user.setName(userDetails.getName());
        user.setAge(userDetails.getAge());

        final User updatedUser = userDao.save(user);

        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
        User user = userDao.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        userDao.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
