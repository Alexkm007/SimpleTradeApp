API- v1

registration
/api/v1/auth/registration - post

        login, - NonNull
        password, - NonNull
        name,     - NonNull
        surname,
        email, - NonNull
        phoneNumber

/api/v1/auth/login
        login, - NonNull
        password, - NonNull

Users
api/v1/users - get all users
api/v1/users/edit/{id} - get, user by id
api/v1/users/add - post, add user

        login, - NonNull
        password, - NonNull
        name,     - NonNull
        surname,
        email, - NonNull
        phoneNumber

api/v1/users/update  - put, update user

        id, - if null error
        login, - NonNull
        password, - NonNull
        name,     - NonNull
        surname,
        email, - NonNull
        phoneNumber

api/v1/users/delete/{id} - delete, find and delete user by id


