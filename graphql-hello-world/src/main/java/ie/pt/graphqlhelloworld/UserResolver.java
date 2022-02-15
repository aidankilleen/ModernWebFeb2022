package ie.pt.graphqlhelloworld;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserResolver implements DataFetcher<List<User>> {

    @Autowired
    UserRepository userRepository;


    @Override
    public List<User> get(DataFetchingEnvironment environment) {

        List<User> users = userRepository.findAll();
        return users;
    }
}
