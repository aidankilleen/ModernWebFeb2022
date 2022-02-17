const fetch = require("node-fetch");

let url = "http://localhost/graphql";


let queries = {
    "users": `query{
                users{
                    id
                    name
                    email
                    active
                }
              }`,
    "user": `query($id: Int!){
                user(id: $id) {
                    id
                    name
                    email
                    active
                }
              }`,
    "add": `mutation($userToAdd: AddUserDto!) {
              addUser(userToAdd: $userToAdd) {
                id
                name
                email
                active
              }
            }`,
    "delete": `mutation($id: Int!) {
              delete(id: $id)
            }`,
    "update": `mutation($userToUpdate: UserDto!) {
              update(userToUpdate: $userToUpdate){
                id
                name
                email
                active
              }
            }`

};

function executeGraphQl(query, variables) {
    let body = {
        query,
        variables
    };

    let options = {
        method: "POST",
        header: {
            contentType: "applications/json"
        },
        body: JSON.stringify(body)
    };

    return fetch(url, options)
        .then(data=>data.json());
}



module.exports = async function() {

    // wouldn't it be cool if you could get 
    // this list from an api?????
    let result = await executeGraphQl(queries['users'], {});
        
    console.log(JSON.stringify(result.data.users));

    return {
        users: result.data.users
    }
}