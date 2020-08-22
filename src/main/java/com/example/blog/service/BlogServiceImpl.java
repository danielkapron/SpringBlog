package com.example.blog.service;

import com.example.blog.model.Category;
import com.example.blog.model.Post;
import com.example.blog.model.User;
import com.example.blog.repository.PostRepository;
import com.example.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    private UserRepository userRepository;
    private PostRepository postRepository;
    @Autowired
    public BlogServiceImpl(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }
    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll(Sort.by(Sort.Direction.DESC, "dateAdded"));
    }


    @Override
    public Post addPostByUser(long userId, String title, String content, Category category) {
        if (userRepository.existsById(userId)){
            User user = userRepository.findById(userId).get();
            return postRepository.save(new Post(title, content, category, user));
        }
        return null;
    }
    @Override
    public boolean addUser(User user) {
        if(userRepository.findFirstByEmail(user.getEmail()) == null) {
            userRepository.save(user);   // INSERT INTO user VALUES (?,?,?,?,?);
            return true;
        }
        return false;
    }
    @Override
    public boolean deleteUser(long userId) {
        boolean isDeleted = userRepository.existsById(userId);
        userRepository.deleteById(userId);
        return isDeleted;
    }
    @Override
    public Optional<User> getUserById(long userId) {
        return userRepository.findById(userId);
    }


    @Override
    public boolean updatePassword(long userId, String newPassword) {
        if(userRepository.findById(userId).isPresent()){
            User userToUpdate = userRepository.findById(userId).get();  // pobranie użytkownika po id
            userToUpdate.setPassword(newPassword);                      // aktualizacja pola password
            userRepository.save(userToUpdate);                          // zapis/update istniejącego obiektu
            return true;
        }
        return false;
    }
    @Override
    public List<User> getAllUsersOrderByregistrationDateDesc() {
        return userRepository.findAll();
    }



}
