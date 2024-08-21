package com.toyproject.messenger.user.repository.custom;


import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MessengerUserCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

}
