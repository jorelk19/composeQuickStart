package com.composequickstart.mocks

import com.composequickstart.entities.User


fun userList() : ArrayList<User> {
    val userList = ArrayList<User>()
    userList.add(User(
        name = "User 1",
        lastName = "LastName 1",
        address = "street 1",
        email = "test1@test.com"
    ))
    userList.add(User(
        name = "User 2",
        lastName = "LastName 2",
        address = "street 2",
        email = "test2@test.com"
    ))
    userList.add(User(
        name = "User 3",
        lastName = "LastName 3",
        address = "street 3",
        email = "test3@test.com"
    ))
    userList.add(User(
        name = "User 4",
        lastName = "LastName 4",
        address = "street 4",
        email = "test4@test.com"
    ))

    return userList
}