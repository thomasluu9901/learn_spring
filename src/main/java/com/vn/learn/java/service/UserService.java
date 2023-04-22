package com.vn.learn.java.service;

import com.vn.learn.java.entity.UserEntity;
import com.vn.learn.java.dto.SortUpdateDTO;
import com.vn.learn.java.repository.UserRepository;
import com.vn.learn.java.security.CustomUserDetails;
import com.vn.learn.java.ultil.lexorank.LexoRank;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new CustomUserDetails(userRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException(username)));
    }
    public List<UserEntity> findAll(){
        return userRepository.findAllOrderBy();
    }
    public void update(SortUpdateDTO dto){
        UserEntity user = userRepository.findById(dto.getId()).orElseThrow();
        if (StringUtils.isNotBlank(dto.getNext())&& StringUtils.isNotBlank(dto.getPre())){
            user.setOrderColumn(LexoRank.parse(dto.getPre()).between(LexoRank.parse(dto.getNext())).toString());
        }else if (StringUtils.isBlank(dto.getPre())){
            user.setOrderColumn(LexoRank.parse(dto.getNext()).genPrev().toString());
        } else if (StringUtils.isBlank(dto.getNext())) {
            user.setOrderColumn(LexoRank.parse(dto.getPre()).genNext().toString());
        }
        userRepository.save(user);
    }
}
