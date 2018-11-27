//package com.example.demo.service;
//
//import com.example.demo.constant.HTTPCodeResponse;
//import com.example.demo.entity.UserEntity;
//import com.example.demo.model.User;
//import com.example.demo.repository.UserRepository;
//import com.example.demo.security.JwtGenerator;
//import com.example.demo.service.response.LoginResponse;
//import com.example.demo.service.response.MessageResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private JwtGenerator jwtGenerator;
//
//
//    @Override
//    public LoginResponse login(User user) {
//        MessageResponse messageResponse = new MessageResponse();
//        UserEntity userEntity = userRepository.findUserEntityByUsername(user.getUsername());
//        if (userEntity == null) {
//            messageResponse.setCode(HTTPCodeResponse.OBJECT_NOT_FOUND);
//            messageResponse.setDescription("Wrong Information");
//            return new LoginResponse(messageResponse, null);
//        } else {
//            if (BCrypt.checkpw(user.getPasswprd(), userEntity.getPassword())) {
//                messageResponse.setCode(HTTPCodeResponse.SUCCESS);
//                messageResponse.setDescription("Success");
//                return new LoginResponse(messageResponse, jwtGenerator.generate(userEntity));
//            } else {
//                messageResponse.setCode(HTTPCodeResponse.OBJECT_NOT_FOUND);
//                messageResponse.setDescription("Wrong Information");
//                return new LoginResponse(messageResponse, null);
//            }
//        }
//    }
//
//    @Override
//    public LoginResponse register(User user) {
//        UserEntity userEntity = userRepository.findUserEntityByUsername(user.getUsername());
//        MessageResponse messageResponse = new MessageResponse();
//
//        if (userEntity == null) {
//            UserEntity userRegister = new UserEntity();
//            userRegister.setFullname(user.getFullname());
//            userRegister.setUsername(user.getUsername());
//            userRegister.setPassword(user.getPasswprd());
//            //userRegister.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
//
//            // userRegister.setRole("ROLE_MEMBER");
//            userRepository.save(userRegister);
//            messageResponse.setCode(HTTPCodeResponse.SUCCESS);
//            messageResponse.setDescription("You have been successfully registered");
//            return new LoginResponse(messageResponse, jwtGenerator.generate(userRepository.findUserEntityByUsername(user.getUsername())));
//        } else {
//            messageResponse.setCode(HTTPCodeResponse.OBJECT_EXISTED);
//            messageResponse.setDescription("Username existed!!");
//            return new LoginResponse(messageResponse, null);
//        }
//    }
//
//}
//
