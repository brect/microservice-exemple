package com.blimas.hroauth.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class User {

    private UUID id;

    private String name;

    private String email;

    private String password;

    private Set<Role> roles = new HashSet<>();

}
