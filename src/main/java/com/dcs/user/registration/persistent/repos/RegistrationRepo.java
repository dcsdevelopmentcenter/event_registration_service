package com.dcs.user.registration.persistent.repos;
/*
 * Copyright (c) 2023 Seiko Epson. All rights reserved.
 */

import com.dcs.user.registration.persistent.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepo extends MongoRepository<UserEntity,String>
{
}
